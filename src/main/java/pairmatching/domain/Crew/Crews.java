package pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.constant.Notification;
import pairmatching.domain.Course;

public class Crews {
	private static final int MINIMUM_PERSON_NUMBER = 2;
	private final List<Crew> crews;

	private Crews(List<Crew> crews) {
		validateDuplicate(crews);
		validateSize(crews);
		this.crews = crews;
	}

	public static Crews of(List<Crew> crews) {
		return new Crews(crews);
	}
	public static Crews of(Course course, List<String> crewNames) {
		List<Crew> crews = crewNames.stream()
			.map(name -> Crew.of(course, name))
			.collect(Collectors.toList());
		return new Crews(crews);
	}

	private void validateDuplicate(List<Crew> crews) {
		Set<Crew> crewSet = new HashSet<>(crews);
		if (crewSet.size() != crews.size()) {
			throw new IllegalArgumentException(Notification.CREW_NAME_DUPLICATE.getMessage());
		}
	}

	private void validateSize(List<Crew> crews) {
		if(crews.size() < MINIMUM_PERSON_NUMBER) {
			throw new IllegalArgumentException(Notification.CREW_MINIMUM_PERSON_INSUFFICIENT.getMessage());
		}
	}

	public List<Crew> getCrews() {
		return new ArrayList<>(crews);
	}

	public void add(Crew crew) {
		crews.add(crew);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Crews crews1 = (Crews)o;
		return Objects.equals(crews, crews1.crews);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crews);
	}
}
