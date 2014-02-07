package org.rgn.ajia.around.infra;

public class TXContext {
	private String id;
	private int connectionId;

	public TXContext(String id, int connId) {
		super();
		this.id = id;
		this.connectionId = connId;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TXContext [id=" + id + ", connectionId=" + connectionId + "]";
	}

}
