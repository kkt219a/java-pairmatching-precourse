package pairmatching.processor;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Feature;

public class InputProcessor {
	private static final String FEATURE_SELECT = "기능을 선택하세요.";
	private static final String SELECT_INFORMATION = "과정, 레벨, 미션을 선택하세요.";
	private static final String SELECT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

	public String readFeatureSelect() {
		System.out.println(FEATURE_SELECT);
		for (Feature feature : Feature.values()) {
			System.out.println(feature);
		}
		return readLine();
	}

	public String readPairInformation() {
		System.out.println(SELECT_INFORMATION);
		System.out.println(SELECT_EXAMPLE);
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
