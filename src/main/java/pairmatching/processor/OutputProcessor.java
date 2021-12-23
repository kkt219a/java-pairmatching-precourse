package pairmatching.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;

public class OutputProcessor {
	public String getMissionInformation() {
		List<String> titles = Arrays.stream(Course.values())
			.map(Course::getTitle)
			.collect(Collectors.toList());
		return String.join(" | ",titles);
	}
}
