package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.Objects;

import pairmatching.domain.Crew.Crews;
import pairmatching.domain.Level;

public class Pair {
	private final Content content;
	private final PairCrews pairCrews;

	private Pair(Content content, PairCrews pairCrews) {
		Objects.requireNonNull(content);
		Objects.requireNonNull(pairCrews);
		this.content = content;
		this.pairCrews = pairCrews;
	}

	public static Pair of(Content content, PairCrews pairCrews) {
		return new Pair(content, pairCrews);
	}

	public boolean equalContent(Content content) {
		return this.content.equals(content);
	}

	public boolean equalLevel(Level level) {
		return this.content.equalLevel(level);
	}

	public boolean equalPairCrew(PairCrews pairCrews) {
		return this.pairCrews.equals(pairCrews);
	}

	public Content getContent() {
		return content;
	}
}
