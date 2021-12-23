package pairmatching.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputProcessor {
	private static final String MISSION_OUTPUT = "미션: ";
	private static final String COURSE_OUTPUT = "과정: ";
	private static final String DELIMITER = "#############################################";
	private static final String SELECT_INFORMATION = "과정, 레벨, 미션을 선택하세요.";
	private static final String SELECT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

	public void printPairInterface() {
		System.out.println(DELIMITER);
		printCourseInformation();
		printMissionInformation();
		System.out.println(DELIMITER);
		System.out.println(SELECT_INFORMATION);
		System.out.println(SELECT_EXAMPLE);
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
}
