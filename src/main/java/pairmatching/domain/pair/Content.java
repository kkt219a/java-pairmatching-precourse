package pairmatching.domain.pair;

import java.util.Objects;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class Content {
	private final Course course;
	private final Level level;
	private final Mission mission;

	private Content(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public static Content of(String course, String level, String mission) {
		return new Content(Course.of(course), Level.of(level), Mission.of(mission));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Content content = (Content)o;
		return course == content.course && level == content.level && mission == content.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}

	public Course getCourse() {
		return course;
	}

	public boolean equalLevel(Level level) {
		return this.level.equals(level);
	}

	public Level getLevel() {
		return level;
	}
}
