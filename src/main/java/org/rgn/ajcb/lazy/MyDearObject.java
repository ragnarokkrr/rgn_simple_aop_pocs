package org.rgn.ajcb.lazy;

public class MyDearObject {

	private int id;
	private String description;

	public MyDearObject(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String doTheMagic(String message) {
		return "MyDearObject [messageParam=" + message + "]";
	}

	@Override
	public String toString() {
		return "MyDearObject [id=" + id + ", description=" + description + "]";
	}

}
