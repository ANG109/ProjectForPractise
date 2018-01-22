package bw.practise.ang.bean;

import java.sql.Date;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class SmsTimingRecord {
	
	private int id;
	private int order_id;
	private int user_id;
	private String phone;
    private int sms_type_id;
    private int total;
    private int sign_id;
    private String title;	
    private Text content;
    private Date send_time;
    private Date insert_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSms_type_id() {
		return sms_type_id;
	}
	public void setSms_type_id(int sms_type_id) {
		this.sms_type_id = sms_type_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSign_id() {
		return sign_id;
	}
	public void setSign_id(int sign_id) {
		this.sign_id = sign_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Text getContent() {
		return content;
	}
	public void setContent(Text content) {
		this.content = content;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}
	@Override
	public String toString() {
		return "SmsTimingRecord [id=" + id + ", order_id=" + order_id + ", user_id=" + user_id + ", phone=" + phone
				+ ", sms_type_id=" + sms_type_id + ", total=" + total + ", sign_id=" + sign_id + ", title=" + title
				+ ", content=" + content + ", send_time=" + send_time + ", insert_time=" + insert_time + "]";
	}

}
