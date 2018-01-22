package bw.practise.ang.bean;

public class Resp {
	/** 操作成功 */
	public static final int RESULT_OK = 0;//成功
	public static final int RESULT_FAIL = 1000;//失败（未知异常）
	public static final int ERROR_HEAD_INVALID = 1001;//app_head为空
	public static final int ERROR_USER_PASS = 1002;//账号密码错误
	public static final int ERROR_USER_DISABLE = 1003;//账号被禁用
	public static final int ERROR_GET_CODE_FAIL = 1004;//获取验证码失败
	public static final int ERROR_PARAMS = 1005;//参数错误
	public static final int ERROR_VERCODE = 1006;//验证码错误
	public static final int ERROR_REG_FAIL = 1007;//注册失败
	public static final int ERROR_USER_EXISTING = 1008;//账户已存在
	public static final int ERROR_NO_USER = 1009;//账户不存在
	public static final int ERROR_UPLOAD_FILE_FAIL = 1010;//上传文件失败
	public static final int ERROR_INVITE_CODE_INVALID = 1011;//邀请码无效
	public static final int ERROR_INVITE_CODE_USERD = 1012;//已使用过邀请码
	
	public static final int ERROR_ACT1003_INVALID = 1013;//该活动已无效
	public static final int ERROR_ACT1003_GROUP_INVALID = 1014;//该团已无效
	public static final int ERROR_ACT1003_GROUP_FULL = 1015;//该团已满员
	public static final int ERROR_ACT1003_GROUP_SINGLE = 1016;//超出单人投注上限
	public static final int ERROR_ACT1003_NO_RESOURCE = 10131;//您无该团所需要的可用特权卡
	public static final int ERROR_ACT1003_NO_PRIVILEGE_CARD = 10132;//您使用不是该团所需要的特权卡
	
	public static final int ERROR_GUESS_FULL = 1017;//该答题竞猜已超出人数上限
	public static final int ERROR_GUESS_SINGLE = 1018;//超出单人参与上限
	
	public static final int ERROR_BALANCE_NO_ENOUGH = 1019;//账户余额不足
	public static final int ERROR_KUCUN_NO_ENOUGH = 1020;//库存不足

	public static final int ERROR_SINGED_TODAY = 1021;//今日已签到
	public static final int ERROR_NO_PHONE_INFO = 1022;//获取不到手机信息
	public static final int ERROR_NO_FLOW_INFO = 1023;//获取不到流量包信息
	public static final int ERROR_FLOW_INFO = 1024;//获取流量包信息错误
	
	//整点摇奖
	public static final int ERROR_ACT1007_NO_START = 1025;//无进行中活动
	public static final int ERROR_ACT1007_JOINED = 1026;//请在下个整点再摇奖
	
	//充值
	public static final int ERROR_RES_INVALID = 1027;//资源不存在
	public static final int ERROR_RES_USERD = 1028;//资源过期或已被使用
	public static final int ERROR_RES_NOT_USER = 1029;//资源不属于该用户
	public static final int ERROR_RES_OPERATOR_NO_MATCHER = 1030;//手机号与资源运营商不匹配
	public static final int ERROR_ORDER_FLOW_FAIL = 1031;//充值下单失败
	
	//幸运转盘
	public static final int ERROR_ACT1006_NONE_PRIZE = 1032;//没有可用的奖品设置
	public static final int ERROR_ACT1006_NONE_ACTIVITY = 1033;//该活动已暂停
	public static final int ERROR_ACT1006_ILLEGAL_USER = 1034;//用户账户异常
	public static final int ERROR_ACT1006_GOLD_RUN_OUT = 1035;//金币不足
	
	//WIFI充值
	public static final int ERROR_ACTWIFI_NONE_PARAM = 1036;//参数异常
	public static final int ERROR_ACTWIFI_UNABLE_COUPON = 1037;//不可用的优惠券
	public static final int ERROR_ACTWIFI_NONE_WIFI_CARD = 1038;//不存在的WIFI类型
	
	public static final int ERROR_RESOUCE_INVALID = 1039;//资源无效（不存在、过期、删除~~）
	public static final int EEROR_INVITE_CODE_SELF = 1040;//不能使用自己的邀请码
	
	private int result = RESULT_OK;
	private String msg = "成功";
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
