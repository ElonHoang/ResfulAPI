package com.example.demo.model;



import java.util.Objects;

public class Manager {
	private int userId;
	private String title;
	private String content;
	private Long current_balance;
	private String type;
	private String partner;
	public Manager() {
		
	}
	public Manager(int userId, String title, String content, Long c_b, String type, String partner) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.current_balance = c_b;
		this.type = type;
		this.partner = partner;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(Long current_balance) {
		this.current_balance = current_balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, current_balance, partner, title, type, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(content, other.content) && Objects.equals(current_balance, other.current_balance)
				&& Objects.equals(partner, other.partner) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Manager [userId=" + userId + ", title=" + title + ", content=" + content + ", current_balance="
				+ current_balance + ", type=" + type + ", partner=" + partner + "]";
	}
	
}
