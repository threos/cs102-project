package co.xreos.lms.navigation.route.impl;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.base.controller.ViewControllerBuilder;
import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.base.view.ViewBuilder;
import co.xreos.lms.navigation.route.base.NamedRoute;

public class ViewControllerRoute<V extends AppView, C extends AppController<V>> implements NamedRoute {
    private final String id;
    private final ViewBuilder<V> viewBuilder;
    private final ViewControllerBuilder<V, C> controllerBuilder;

    private V view;
    private C controller;

    public ViewControllerRoute(String id, ViewBuilder<V> viewBuilder, ViewControllerBuilder<V, C> controllerBuilder) {
        this.id = id;
        this.viewBuilder = viewBuilder;
        this.controllerBuilder = controllerBuilder;
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
        dispose();
        this.view = this.viewBuilder.build();
        this.controller = this.controllerBuilder.build(this.view);
        view.onCreate();
        controller.onCreate();
        this.view.activate();
        this.controller.activate();
    }

    @Override
    public void dispose() {
        if (this.view == null && this.controller == null) {
            return;
        }
        this.controller.deactivate();
        this.controller.onDestroy();
        this.view.deactivate();
        this.view.onDestroy();
        this.view = null;
        this.controller = null;
    }

    @Override
    public boolean isTransient() {
        return false;
    }
}
