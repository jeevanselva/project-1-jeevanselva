package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.models.ListOfReimbursements;
import com.revature.models.Reimbursement;
import com.revature.models.Resolved;
import com.revature.util.ConnectionFactory;

public class ManagerDAO {
	ConnectionFactory cf;

	public ManagerDAO() {
		this.cf = new ConnectionFactory();
	}

	public ListOfReimbursements readEmployeeReimbursements() {

		ListOfReimbursements list = new ListOfReimbursements();

		try {
			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "select * from ers_reimbursement;";

			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			ResultSet result = reimbursementStatement.executeQuery();

			while (result.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setAuthorId(result.getInt("reimb_author"));
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("reimb_amount"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setType(result.getString("reimb_type"));
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

	public ListOfReimbursements readPendingReimbursements() {

		ListOfReimbursements list = new ListOfReimbursements();
		Reimbursement reimbursement = new Reimbursement();

		try {
			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "select * from ers_reimbursement where reimb_status='pending';";

			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			ResultSet result = reimbursementStatement.executeQuery();

			while (result.next()) {
				reimbursement.setAuthorId(result.getInt("reimb_author"));
				reimbursement.setReimbursementId(result.getInt("reimb_id"));
				reimbursement.setAmount(result.getInt("reimb_amount"));
				reimbursement.setDescription(result.getString("reimb_description"));
				reimbursement.setStatus(result.getString("reimb_status"));
				reimbursement.setType(result.getString("reimb_type"));
				reimbursement.setDateSubmitted(result.getTimestamp("reimb_submitted"));
				list.addReimbursement(reimbursement);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void updateReimbursementStatus(Resolved reimbursement) {

		try {
			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "update ers_reimbursement set reimb_status = ?, "
					+ "reimb_resolved = ?, reimb_resolver = ? where reimb_id = ?" + " returning reimb_author;";

			PreparedStatement updateReimbursementStatement = newConnection.prepareStatement(sql);
			updateReimbursementStatement.setString(1, reimbursement.getStatus());
			updateReimbursementStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			updateReimbursementStatement.setInt(3, reimbursement.getResolverId());
			updateReimbursementStatement.setInt(4, reimbursement.getReimbursementId());
			ResultSet result = updateReimbursementStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
