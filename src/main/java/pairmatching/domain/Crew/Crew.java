package pairmatching.domain.Crew;

import java.util.Objects;

import pairmatching.domain.Course;

public class Crew {
	private final Course course;
	private final String name;

	private Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public static Crew of(Course course, String name) {
		return new Crew(course, name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Crew crew = (Crew)o;
		return course == crew.course && Objects.equals(name, crew.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, name);
	}

	public String getName() {
		return name;
	}
}
