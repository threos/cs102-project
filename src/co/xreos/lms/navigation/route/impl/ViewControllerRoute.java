package co.xreos.lms.navigation.route.impl;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.base.controller.ViewControllerBuilder;
import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.route.base.NamedRoute;

public class ViewControllerRoute<V extends AppView, C extends AppController<V>> implements NamedRoute {
    private final String id;
    private final V view;
    private final C controller;

    public ViewControllerRoute(String id, V view, ViewControllerBuilder<V, C> controllerBuilder) {
        this.id = id;
        this.view = view;
        this.controller = controllerBuilder.build(view);
        view.onCreate();
        controller.onCreate();
    }

    public String getId() {
        return this.id;
    }

    public V getView() {
        return this.view;
    }

    public C getController() {
        return this.controller;
    }

    @Override
    public void generate() {
        this.view.activate();
        this.controller.activate();
    }

    @Override
    public void dispose() {
        this.controller.deactivate();
        this.controller.onDestroy();
        this.view.deactivate();
        this.view.onDestroy();
    }

    @Override
    public boolean isTransient() {
        return false;
    }
}
