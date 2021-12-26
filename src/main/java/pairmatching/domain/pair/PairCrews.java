package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pairmatching.domain.Crew.Crew;
import pairmatching.domain.Crew.Crews;

public class PairCrews {
	private final List<Crews> pairCrews;

	public PairCrews() {
		this.pairCrews = new ArrayList<>();
	}

	public PairCrews(List<Crews> pairCrews) {
		this.pairCrews = pairCrews;
	}

	public void add(Crews crews) {
		pairCrews.add(crews);
	}

	public void addLastCrew(Crew crew) {
		Crews lastCrews = pairCrews.remove(pairCrews.size() - 1);
		lastCrews.add(crew);
	}

	public List<Crews> getPairCrews() {
		return new ArrayList<>(pairCrews);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PairCrews pairCrews1 = (PairCrews)o;
		return Objects.equals(pairCrews, pairCrews1.pairCrews);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pairCrews);
	}
}
