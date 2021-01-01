package com.revature.models;

public class ReimbursementSubmission {
	private int authorId;
	private double amount;
	private String description;
	private String type;

	public ReimbursementSubmission() {
		super();

	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementSubmission [authorId=" + authorId + ", amount=" + amount + ", description=" + description
				+ ", type=" + type + "]";
	}

}
