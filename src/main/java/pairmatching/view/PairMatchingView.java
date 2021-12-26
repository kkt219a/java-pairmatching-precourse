package pairmatching.view;

import java.util.List;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Crew.Crews;
import pairmatching.dto.ContentInformationDto;

public class PairMatchingView extends CommonView {
	public PairMatchingView(PairMatchingController pairMatchingController) {
		super(pairMatchingController);
	}

	@Override
	public void show() {
		outputProcessor.printPairInterface();
		String pairInformation = inputProcessor.readPairInformation();
		ContentInformationDto contentInformationDto = new ContentInformationDto(pairInformation);
		try {
			List<Crews> crews = pairMatchingController.addPair(contentInformationDto);
			outputProcessor.printMatchingCrews(crews);
		} catch (IllegalArgumentException e) {
			outputProcessor.printMessage(e.getMessage());
		}
	}
}
