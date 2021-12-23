package pairmatching.domain.pair;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class Pair {
	private final Course course;
	private final Level level;
	private final Mission mission;

	private Pair(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public static Pair of(String course, String level, String mission) {
		return new Pair(Course.of(course), Level.of(level), Mission.of(mission));
	}
}
