package pairmatching.domain;

import java.util.Arrays;

import pairmatching.constant.Notification;

public enum Feature {
	PAIR_MATCHING("1", "페어 매칭"),
	PAIR_INQUIRY("2", "페어 조회"),
	PAIR_INITIALIZATION("3", "페어 초기화"),
	EXIT("Q", "종료");

	private final String key;
	private final String title;

	Feature(String key, String title) {
		this.key = key;
		this.title = title;
	}

	@Override
	public String toString() {
		return key + ". " + title;
	}

	public static Feature of(String key) {
		return Arrays.stream(values())
			.filter(feature -> feature.isKey(key))
			.findAny()
			.orElseThrow(()-> new IllegalArgumentException(Notification.NOT_FOUND_FEATURE.getMessage()));
	}

	public boolean isKey(String key) {
		return this.key.equals(key);
	}
}
