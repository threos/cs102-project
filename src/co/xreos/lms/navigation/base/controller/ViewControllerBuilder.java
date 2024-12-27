package co.xreos.lms.navigation.base.controller;

import co.xreos.lms.navigation.base.view.AppView;

public interface ViewControllerBuilder<V extends AppView, C extends AppController<V>> {
    public C build(V view);
}
