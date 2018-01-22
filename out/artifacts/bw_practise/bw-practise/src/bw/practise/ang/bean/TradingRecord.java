package bw.practise.ang.bean;

public class TradingRecord {

	private int id;
	private int user_id;
	private int trading_type_id;
	private int sms_type_id;
	private int income_type;
	private int trading_value;
	private int balance;
	private int insert_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTrading_type_id() {
		return trading_type_id;
	}
	public void setTrading_type_id(int trading_type_id) {
		this.trading_type_id = trading_type_id;
	}
	public int getSms_type_id() {
		return sms_type_id;
	}
	public void setSms_type_id(int sms_type_id) {
		this.sms_type_id = sms_type_id;
	}
	public int getIncome_type() {
		return income_type;
	}
	public void setIncome_type(int income_type) {
		this.income_type = income_type;
	}
	public int getTrading_value() {
		return trading_value;
	}
	public void setTrading_value(int trading_value) {
		this.trading_value = trading_value;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(int insert_time) {
		this.insert_time = insert_time;
	}
	@Override
	public String toString() {
		return "TradingRecord [id=" + id + ", user_id=" + user_id + ", trading_type_id=" + trading_type_id
				+ ", sms_type_id=" + sms_type_id + ", income_type=" + income_type + ", trading_value=" + trading_value
				+ ", balance=" + balance + ", insert_time=" + insert_time + "]";
	}
}
