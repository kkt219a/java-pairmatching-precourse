package pairmatching.domain.pair;

public class Pair {
	private final Content content;

	private Pair(Content content) {
		this.content = content;
	}

	public static Pair of(String course, String level, String mission) {
		Content content = Content.of(course, level, mission);
		return new Pair(content);
	}

}
