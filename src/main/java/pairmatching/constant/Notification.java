package pairmatching.constant;

public enum Notification {
	CREW_NAME_DUPLICATE("[ERROR] 크루들 간의 이름은 중복될 수 없습니다."),
	NOT_FOUND_FEATURE("[ERROR] 존재하지 않는 기능입니다."),
	NOT_FOUND_LEVEL("[ERROR] 존재하지 않는 레벨입니다."),
	NOT_FOUND_MISSION("[ERROR] 존재하지 않는 미션입니다."),
	NOT_FOUND_COURSE("[ERROR] 존재하지 않는 코스입니다."),
	INVALID_PAIR_INFORMATION("[ERROR] 과정, 레벨, 미션을 올바르게 입력해주세요.");



	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
