package co.xreos.lms.navigation.route.impl;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.base.controller.ViewControllerBuilder;
import co.xreos.lms.navigation.base.view.AppView;

public class TransientViewControllerRoute<V extends AppView, C extends AppController<V>> extends ViewControllerRoute<V, C> {
    public TransientViewControllerRoute(String id, V view, ViewControllerBuilder<V, C> controller) {
        super(id, view, controller);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}