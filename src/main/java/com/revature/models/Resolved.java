package com.revature.models;

public class Resolved {
	int reimbursementId;
	String status;
	int ResolverId;

	public Resolved() {
		super();

	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResolverId() {
		return ResolverId;
	}

	public void setResolverId(int resolverId) {
		ResolverId = resolverId;
	}

	@Override
	public String toString() {
		return "Resolved [reimbursementId=" + reimbursementId + ", status=" + status + ", ResolverId=" + ResolverId
				+ "]";
	}

}
