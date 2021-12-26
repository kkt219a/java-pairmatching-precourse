package pairmatching.dto;

import pairmatching.constant.Notification;
import pairmatching.domain.pair.Content;
import pairmatching.domain.pair.Pair;

public class ContentInformationDto {
	private static final int SPLIT_SIZE = 3;
	private final String input;

	public ContentInformationDto(String input) {
		this.input = input;
	}

	public Content toContent() {
		String[] pairValues = input.split(", ");
		validateSplitSize(pairValues.length);
		return Content.of(pairValues[0], pairValues[1], pairValues[2]);
	}

	private void validateSplitSize(int length) {
		if(length != SPLIT_SIZE) {
			throw new IllegalArgumentException(Notification.INVALID_PAIR_INFORMATION.getMessage());
		}
	}

}
