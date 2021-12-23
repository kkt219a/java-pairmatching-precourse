package pairmatching.constant;

public enum Notification {
	CREW_NAME_DUPLICATE("[ERROR] 크루들 간의 이름은 중복될 수 없습니다."),
	NOT_FOUND_FEATURE("[ERROR] 존재하지 않는 기능입니다.");

	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
