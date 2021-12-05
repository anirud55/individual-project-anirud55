package com.lafaconmod;

public enum Category {
	ESSENTIALS(5),
	LUXURY(3),
	MISC(6);
	
	public final int maxCount;
	
	Category(int _maxCount) {
		this.maxCount = _maxCount;
	}
	
	public int getMaxCount() {
		return this.maxCount;
	}
}
