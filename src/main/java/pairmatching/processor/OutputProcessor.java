package pairmatching.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew.Crew;
import pairmatching.domain.Crew.Crews;
import pairmatching.domain.Feature;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputProcessor {
	private static final String MISSION_OUTPUT = "미션: ";
	private static final String COURSE_OUTPUT = "과정: ";
	private static final String DELIMITER = "#############################################";
	private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";

	public void printPairInterface() {
		System.out.println(DELIMITER);
		printCourseInformation();
		printMissionInformation();
		System.out.println(DELIMITER);
	}

	private void printCourseInformation() {
		System.out.print(COURSE_OUTPUT);
		List<String> titles = Arrays.stream(Course.values())
			.map(Course::getTitle)
			.collect(Collectors.toList());
		System.out.println(String.join(" | ",titles));
	}

	private void printMissionInformation() {
		System.out.println(MISSION_OUTPUT);
		for (Level level : Level.values()) {
			System.out.print("  - " + level.getTitle() + ": ");
			List<String> titles = Mission.getMissionTitleByLevel(level);
			System.out.println(String.join(" | ", titles));
		}
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printMatchingCrews(List<Crews> crews) {
		System.out.println(PAIR_MATCHING_RESULT);
		for (Crews crew : crews) {
			List<String> names = crew.getCrews()
				.stream()
				.map(Crew::getName)
				.collect(Collectors.toList());
			System.out.println(String.join(" : ", names));
		}
	}
}
