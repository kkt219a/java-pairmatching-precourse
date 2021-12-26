package pairmatching.view;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Feature;

public class FeatureSelectView extends CommonView {
	private final PairMatchingView pairMatchingView;
	public FeatureSelectView(PairMatchingController pairMatchingController) {
		super(pairMatchingController);
		pairMatchingView = new PairMatchingView(pairMatchingController);
	}

	@Override
	public void show() {
		while(this.isShow()) {
			String featureKey = inputProcessor.readFeatureSelect();
			try {
				Feature feature = pairMatchingController.getFeature(featureKey);
				startFeature(feature);
			} catch (IllegalArgumentException e) {
				outputProcessor.printMessage(e.getMessage());
			}
		}
	}

	public void startFeature(Feature feature) {
		if(feature.equals(Feature.PAIR_MATCHING)) {
			pairMatchingView.show();
		} else if(feature.equals(Feature.PAIR_INQUIRY)) {

		} else if(feature.equals(Feature.PAIR_INITIALIZATION)) {

		} else if(feature.equals(Feature.EXIT)) {
			this.hide();
		}
	}

}
