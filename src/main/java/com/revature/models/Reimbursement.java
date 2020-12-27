package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	int reimbursementId;
	int amount;
	Timestamp dateSubmitted;
	Timestamp dateResolved;
	String description;
	int authorId;
	int resolverId;
	int status;
	int type;

}
