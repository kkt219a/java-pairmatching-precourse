package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

import pairmatching.constant.Notification;
import pairmatching.domain.Course;

public class Pairs {
	private final List<Pair> pairs;

	public Pairs() {
		pairs = new ArrayList<>();
	}

	public void validateAddDuplicate(Pair pair) {
		boolean duplicate = pairs.stream()
			.anyMatch(thisPair -> thisPair.equalContent(pair.getContent()));
		if(duplicate) {
			throw new IllegalArgumentException(Notification.DUPLICATE_PAIR_INFORMATION.getMessage());
		}
	}

	public void add(Pair pair) {
		validateAddDuplicate(pair);
	}

	public boolean isDuplicateCrew(Content content, PairCrews pairCrews) {
		return pairs.stream()
			.filter(pair -> pair.equalLevel(content.getLevel()))
			.anyMatch(pair -> pair.equalPairCrew(pairCrews));
	}
}
