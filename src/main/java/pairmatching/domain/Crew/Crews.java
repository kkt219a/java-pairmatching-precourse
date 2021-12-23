package pairmatching.domain.Crew;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.constant.Notification;
import pairmatching.domain.Course;

public class Crews {
	private final List<Crew> crews;

	private Crews(List<Crew> crews) {
		validateDuplicate(crews);
		this.crews = crews;
	}

	private void validateDuplicate(List<Crew> crews) {
		Set<Crew> crewSet = new HashSet<>(crews);
		if(crewSet.size() != crews.size()) {
			throw new IllegalArgumentException(Notification.CREW_NAME_DUPLICATE.getMessage());
		}
	}

	public static Crews of(Course course, List<String> crewNames) {
		List<Crew> crews = crewNames.stream()
			.map(name -> Crew.of(course, name))
			.collect(Collectors.toList());
		return new Crews(crews);
	}
}
