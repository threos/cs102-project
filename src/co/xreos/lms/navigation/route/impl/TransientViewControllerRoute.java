package co.xreos.lms.navigation.route.impl;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.base.controller.ViewControllerBuilder;
import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.base.view.ViewBuilder;

public class TransientViewControllerRoute<V extends AppView, C extends AppController<V>> extends ViewControllerRoute<V, C> {
    public TransientViewControllerRoute(String id, ViewBuilder<V> viewBuilder, ViewControllerBuilder<V, C> controllerBuilder) {
        super(id, viewBuilder, controllerBuilder);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}