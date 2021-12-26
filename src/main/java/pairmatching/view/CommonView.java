package pairmatching.view;

import pairmatching.controller.PairMatchingController;
import pairmatching.processor.InputProcessor;
import pairmatching.processor.OutputProcessor;

public abstract class CommonView {
	protected final PairMatchingController pairMatchingController;
	protected final InputProcessor inputProcessor = new InputProcessor();
	protected final OutputProcessor outputProcessor = new OutputProcessor();
	private ViewState viewState = ViewState.SHOW;

	public CommonView(PairMatchingController pairMatchingController) {
		this.pairMatchingController = pairMatchingController;
	}

	public void hide() {
		this.viewState = ViewState.HIDE;
	}

	public boolean isShow() {
		return viewState.isShow();
	}

	public abstract void show();

}
