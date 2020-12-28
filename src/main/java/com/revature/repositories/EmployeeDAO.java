package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.CurrentUser;
import com.revature.models.EmployeeReimbursement;
import com.revature.models.ListOfReimbursements;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO {
	ConnectionFactory cf;
	CurrentUser user;

	public EmployeeDAO(CurrentUser user) {
		this.user = user;
		this.cf = new ConnectionFactory();
	}

	public ListOfReimbursements readAllTickets() {

		ListOfReimbursements list = new ListOfReimbursements();
		EmployeeReimbursement reimbursement = new EmployeeReimbursement();

		try {

			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "select ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount,"
					+ " ers_reimbursement.reimb_description, ers_reimbursement.reimb_submitted,"
					+ " ers_reimbursement.reimb_resolved, ers_reimbursement.reimb_resolver, "
					+ "ers_reimbursement_status.reimb_status, ers_reimbursement_type.reimb_type"
					+ " from ers_reimbursement inner join ers_reimbursement_status on "
					+ "ers_reimbursement_status.reimb_status_id=ers_reimbursement.reimb_status_id"
					+ " inner join ers_reimbursement_type on "
					+ "ers_reimbursement.reimb_type_id=ers_reimbursement_type.reimb_type_id " + "where reimb_author=?;";

			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			reimbursementStatement.setInt(1, this.user.getUserId());
			ResultSet result = reimbursementStatement.executeQuery();

			while (result.next()) {
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("reimb_amount"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setType(result.getString("reimb_status"));
				reimbursement.setDateSubmitted(result.getTimestamp("reimb_submitted"));
				reimbursement.setDateResolved(result.getTimestamp("reimb_resolved"));
				reimbursement.setResolverId(result.getInt("reimb_resolver"));
				list.addEmployeeReimbursement(reimbursement);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
