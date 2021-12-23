package pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pairmatching.domain.Course;

class CrewsTest {
	@Test
	@DisplayName("중복된 이름은 허용할 수 없다.")
	public void duplicatedName() {
		List<String> names = new ArrayList<>();
		names.add("철수");
		names.add("철수");
		names.add("영희");
		Assertions.assertThrows(IllegalArgumentException.class,()->Crews.of(Course.BACKEND, names));
	}
}
