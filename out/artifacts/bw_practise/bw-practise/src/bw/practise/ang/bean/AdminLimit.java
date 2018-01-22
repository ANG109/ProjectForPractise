package bw.practise.ang.bean;

public class AdminLimit {
	
	private int id;
	private String name;
	private String action;
	private int menu_id;
	@Override
	public String toString() {
		return "AdminLimit [id=" + id + ", name=" + name + ", action=" + action + ", menu_id=" + menu_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

}
