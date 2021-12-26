package pairmatching.controller;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew.Crew;
import pairmatching.domain.Crew.Crews;
import pairmatching.domain.Feature;
import pairmatching.domain.pair.Content;
import pairmatching.dto.ContentInformationDto;
import pairmatching.processor.CrewFile;
import pairmatching.processor.FileProcessor;
import pairmatching.service.PairService;

public class PairMatchingController {
	private final PairService pairService;

	public PairMatchingController() {
		FileProcessor fileProcessor = new FileProcessor();
		List<String> frontEndCrewNames = fileProcessor.readCrewNames(CrewFile.FRONT_END);
		List<String> backEndCrewNames = fileProcessor.readCrewNames(CrewFile.BACK_END);
		List<Crew> frontEndCrews = makeCrews(frontEndCrewNames, Course.FRONTEND);
		List<Crew> backEndCrews = makeCrews(backEndCrewNames, Course.BACKEND);
		this.pairService = new PairService(Crews.of(frontEndCrews), Crews.of(backEndCrews));
	}

	public Feature getFeature(String featureKey) {
		return Feature.of(featureKey);
	}

	private List<Crew> makeCrews(List<String> names, Course course) {
		return names.stream()
			.map(name -> Crew.of(course,name))
			.collect(Collectors.toList());
	}

	public List<Crews> addPair(ContentInformationDto contentInformationDto) {
		Content content = contentInformationDto.toContent();
		return pairService.addPair(content);
	}
}
