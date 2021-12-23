package pairmatching.domain.pair;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair = (Pair)o;
		return course == pair.course && level == pair.level && mission == pair.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
