package pairmatching.domain;

import java.util.Arrays;

import pairmatching.constant.Notification;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String title;

	Level(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public static Level of(String title) {
		return Arrays.stream(Level.values())
			.filter(level -> level.title.equals(title))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Notification.NOT_FOUND_LEVEL.getMessage()));
	}
}
