package pairmatching.dto;

import pairmatching.constant.Notification;
import pairmatching.domain.pair.Pair;

public class PairInformationDto {
	private static final int SPLIT_SIZE = 3;
	private final String input;

	public PairInformationDto(String input) {
		this.input = input;
	}

	public Pair toPair() {
		String[] pairValues = input.split(", ");
		validateSplitSize(pairValues.length);
		return Pair.of(pairValues[0],pairValues[1],pairValues[2]);
	}

	private void validateSplitSize(int length) {
		if(length != SPLIT_SIZE) {
			throw new IllegalArgumentException(Notification.INVALID_PAIR_INFORMATION.getMessage());
		}
	}

}
