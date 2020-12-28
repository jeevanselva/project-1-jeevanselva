package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ListOfReimbursements;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ManagerDAO {
	ConnectionFactory cf;

	public ManagerDAO() {
		this.cf = new ConnectionFactory();
	}

	public ListOfReimbursements readEmployeeReimbursements() {

		ListOfReimbursements list = new ListOfReimbursements();
		Reimbursement reimbursement = new Reimbursement();

		try {
			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "select ers_reimbursement.reimb_author, ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount,"
					+ " ers_reimbursement.reimb_description, ers_reimbursement.reimb_submitted,"
					+ " ers_reimbursement.reimb_resolved, ers_reimbursement.reimb_resolver, "
					+ "ers_reimbursement_status.reimb_status, ers_reimbursement_type.reimb_type"
					+ " from ers_reimbursement inner join ers_reimbursement_status on "
					+ "ers_reimbursement_status.reimb_status_id=ers_reimbursement.reimb_status_id"
					+ " inner join ers_reimbursement_type on "
					+ "ers_reimbursement.reimb_type_id=ers_reimbursement_type.reimb_type_id;";

			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			ResultSet result = reimbursementStatement.executeQuery();

			while (result.next()) {
				reimbursement.setAuthorId(result.getInt("reimb_author"));
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("reimb_amount"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setType(result.getString("reimb_status"));
				reimbursement.setDateSubmitted(result.getTimestamp("reimb_submitted"));
				reimbursement.setDateResolved(result.getTimestamp("reimb_resolved"));
				reimbursement.setResolverId(result.getInt("reimb_resolver"));
				list.addReimbursement(reimbursement);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void updateReimbursementStatus(Reimbursement reimbursement) {

		try {
			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "update ers_reimbursement_status set reimb_status " + "= ? from ers_reimbursement where "
					+ " ers_reimbursement_status.reimb_status_id=ers_reimbursement.reimb_status_id"
					+ " and ers_reimbursement.reimb_id = ? returning " + "ers_reimbursement_status.reimb_status;";

			PreparedStatement updateReimbursementStatement = newConnection.prepareStatement(sql);
			updateReimbursementStatement.setString(1, reimbursement.getStatus());
			updateReimbursementStatement.setInt(2, reimbursement.getReimbursementId());
			ResultSet result = updateReimbursementStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
