package org.example;

import java.io.Serializable;

public class Issue implements Serializable {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
