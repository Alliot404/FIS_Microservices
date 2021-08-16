package com.fis.loan.bean;

public class Loan {
	String number, type;
	long loanAmt;
	int emi, tenure;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(long loanAmt) {
		this.loanAmt = loanAmt;
	}
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "Loan [number=" + number + ", type=" + type + ", loanAmt=" + loanAmt + ", emi=" + emi + ", tenure="
				+ tenure + "]";
	}
	public Loan(String number, String type, long loanAmt, int emi, int tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loanAmt = loanAmt;
		this.emi = emi;
		this.tenure = tenure;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
