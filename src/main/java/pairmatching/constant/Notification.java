package pairmatching.constant;

public enum Notification {
	CREW_NAME_DUPLICATE("[ERROR] 크루들 간의 이름은 중복될 수 없습니다.");
	private final String message;

	Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
