package pairmatching.processor;

public enum ViewState {
	HIDE, SHOW;

	public boolean isShow() {
		return this == ViewState.SHOW;
	}
}
