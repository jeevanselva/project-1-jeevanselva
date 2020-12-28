package com.revature.models;

import java.util.ArrayList;

public class ListOfReimbursements {
	private ArrayList<Reimbursement> list;
	private ArrayList<EmployeeReimbursement> employeeList;

	public ListOfReimbursements() {
		this.list = new ArrayList<Reimbursement>();
		this.employeeList = new ArrayList<EmployeeReimbursement>();

	}

	public ArrayList<Reimbursement> getList() {
		return list;
	}

	public void setList(ArrayList<Reimbursement> list) {
		this.list = list;
	}

	public ArrayList<EmployeeReimbursement> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<EmployeeReimbursement> employeeList) {
		this.employeeList = employeeList;
	}

	public void addEmployeeReimbursement(EmployeeReimbursement r) {
		this.employeeList.add(r);
	}

	public void addReimbursement(Reimbursement r) {
		this.list.add(r);
	}

	@Override
	public String toString() {
		return "ListOfReimbursements [list=" + list + ", employeeList=" + employeeList + "]";
	}

}
