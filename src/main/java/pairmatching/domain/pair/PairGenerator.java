package pairmatching.domain.pair;

import pairmatching.domain.Crew.Crews;

public interface PairGenerator {
	PairCrews generate(Crews crews);
}
