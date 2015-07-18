package de.hsnr.abts.what2do.data.entities;

import java.io.Serializable;

public enum Priority implements Serializable{
	LOW(-1), NORMAL(0), HIGH(1);
	
	private Integer prio;
	private Priority(Integer p) {
		this.prio = p;
	}
	public Integer getPriority() {
		return prio;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.prio);
	}
}
