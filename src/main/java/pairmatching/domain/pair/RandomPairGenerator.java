package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew.Crew;
import pairmatching.domain.Crew.Crews;

public class RandomPairGenerator implements PairGenerator {
	private static final int DEFAULT_PERSON_NUMBER = 2;
	private static final int DIVIDER_ODD = 1;
	@Override
	public PairCrews generate(Crews crews) {
		List<Crew> shuffleCrews = Randoms.shuffle(crews.getCrews());
		return makePairCrews(shuffleCrews);
	}

	public PairCrews makePairCrews(List<Crew> crews) {
		PairCrews pairCrews = new PairCrews();
		for(int iterator = 0; iterator < crews.size()-DEFAULT_PERSON_NUMBER; iterator += DEFAULT_PERSON_NUMBER) {
			List<Crew> pairCrewList = new ArrayList<>(crews.subList(iterator, iterator + DEFAULT_PERSON_NUMBER));
			Crews newCrews = Crews.of(pairCrewList);
			pairCrews.add(newCrews);
		}
		if(isOddSize(crews.size())) {
			pairCrews.addLastCrew(crews.get(crews.size()-1));
		}
		return pairCrews;
	}

	private boolean isOddSize(int size) {
		return size % DEFAULT_PERSON_NUMBER == DIVIDER_ODD;
	}
}
