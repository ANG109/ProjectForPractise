package bw.practise.ang.bean;

public class RedisClient {
	private String name;
	private ChatSubscribe roomSubListerner;
	
	public RedisClient(){
		roomSubListerner = new ChatSubscribe();
	} 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ChatSubscribe getRoomSubListerner() {
		return roomSubListerner;
	}
	public void setRoomSubListerner(ChatSubscribe roomSubListerner) {
		this.roomSubListerner = roomSubListerner;
	}
	
	
}
