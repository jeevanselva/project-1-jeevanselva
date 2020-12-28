package com.revature.models;

import java.sql.Timestamp;

public class EmployeeReimbursement {
	int reimbursementId;
	int amount;
	String description;
	String status;
	String type;
	Timestamp dateSubmitted;
	Timestamp dateResolved;
	int resolverId;

	public EmployeeReimbursement() {
		super();
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Timestamp getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	@Override
	public String toString() {
		return "EmployeeReimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", description="
				+ description + ", status=" + status + ", type=" + type + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", resolverId=" + resolverId + "]";
	}

}
