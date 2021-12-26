package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.FeatureSelectView;

public class Application {
    public static void main(String[] args) {
        FeatureSelectView featureSelectView = new FeatureSelectView(new PairMatchingController());
        featureSelectView.show();
    }
}
