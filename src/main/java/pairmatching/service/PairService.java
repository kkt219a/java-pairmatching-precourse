package pairmatching.service;

import pairmatching.constant.Notification;
import pairmatching.domain.Course;
import pairmatching.domain.Crew.Crews;
import pairmatching.domain.pair.Content;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.PairCrews;
import pairmatching.domain.pair.PairGenerator;
import pairmatching.domain.pair.Pairs;
import pairmatching.domain.pair.RandomPairGenerator;

public class PairService {
	private static final int MAX_PAIR_COUNT = 3;

	private final Crews frontEndCrews;
	private final Crews backEndCrews;
	private final Pairs pairs = new Pairs();
	private final PairGenerator pairGenerator = new RandomPairGenerator();

	public PairService(Crews frontEndCrews, Crews backEndCrews) {
		this.frontEndCrews = frontEndCrews;
		this.backEndCrews = backEndCrews;
	}

	public void addPair(Content content) {
		PairCrews pairCrews = makePair(content);
		Pair pair = Pair.of(content, pairCrews);
		pairs.add(pair);
	}

	public PairCrews makePair(Content content) {
		int remainCount = 0;
		PairCrews pairCrews = null;
		for(; remainCount < MAX_PAIR_COUNT ; remainCount++) {
			pairCrews = makePairCrews(content.getCourse());
			if(pairs.isDuplicateCrew(content,pairCrews)) {
				break;
			}
		}
		validateMatchingSuccess(remainCount);
		return pairCrews;
	}

	private void validateMatchingSuccess(int remainCount) {
		if(remainCount == MAX_PAIR_COUNT) {
			throw new IllegalArgumentException(Notification.MATCHING_FAIL.getMessage());
		}
	}

	private PairCrews makePairCrews(Course course) {
		if(course == Course.FRONTEND) {
			return pairGenerator.generate(frontEndCrews);
		} else if(course == Course.BACKEND) {
			return pairGenerator.generate(backEndCrews);
		}
		return null;
	}
}
