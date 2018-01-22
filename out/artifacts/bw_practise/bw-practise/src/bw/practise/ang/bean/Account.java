package bw.practise.ang.bean;

public class Account {
	private int id;
	private int sms_type_id;
	private int balance;
	private int warning_balance;
	private int warning_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSms_type_id() {
		return sms_type_id;
	}
	public void setSms_type_id(int sms_type_id) {
		this.sms_type_id = sms_type_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getWarning_balance() {
		return warning_balance;
	}
	public void setWarning_balance(int warning_balance) {
		this.warning_balance = warning_balance;
	}
	public int getWarning_status() {
		return warning_status;
	}
	public void setWarning_status(int warning_status) {
		this.warning_status = warning_status;
	}

}
