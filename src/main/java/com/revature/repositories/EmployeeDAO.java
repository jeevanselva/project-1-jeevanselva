package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.models.CurrentUser;
import com.revature.models.EmployeeReimbursement;
import com.revature.models.ListOfReimbursements;
import com.revature.models.ReimbursementSubmission;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO {
	ConnectionFactory cf;
	CurrentUser user;

	public EmployeeDAO(CurrentUser user) {
		this.user = user;
		this.cf = new ConnectionFactory();
	}

	public EmployeeDAO() {
		this.cf = new ConnectionFactory();
	}

	public void newReimbursement(ReimbursementSubmission r) {

		try {

			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_status,"
					+ " reimb_type, reimb_description, reimb_author) values (?,?,?,?,?,?)" + " returning reimb_id;";
			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			reimbursementStatement.setDouble(1, r.getAmount());
			reimbursementStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			reimbursementStatement.setString(3, "pending");
			reimbursementStatement.setString(4, r.getType());
			reimbursementStatement.setString(5, r.getDescription());
			reimbursementStatement.setInt(6, r.getAuthorId());
			ResultSet result = reimbursementStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ListOfReimbursements readAllReimbursements() {

		ListOfReimbursements list = new ListOfReimbursements();

		try {

			Connection newConnection = ConnectionFactory.getNewConnection();

			String sql = "select reimb_id, reimb_amount, reimb_description, reimb_submitted,"
					+ " reimb_resolved, reimb_resolver, reimb_status, reimb_type from ers_reimbursement"
					+ " where reimb_author=?;";
			PreparedStatement reimbursementStatement = newConnection.prepareStatement(sql);
			reimbursementStatement.setInt(1, this.user.getUserId());
			ResultSet result = reimbursementStatement.executeQuery();

			while (result.next()) {
				EmployeeReimbursement reimbursement = new EmployeeReimbursement();
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
