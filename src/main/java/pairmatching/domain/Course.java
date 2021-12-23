package pairmatching.domain;

import java.util.Arrays;

import pairmatching.constant.Notification;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String title;

	Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public static Course of(String title) {
		return Arrays.stream(Course.values())
			.filter(course -> course.title.equals(title))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Notification.NOT_FOUND_COURSE.getMessage()));
	}
}
