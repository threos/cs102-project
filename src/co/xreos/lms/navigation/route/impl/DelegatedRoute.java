package co.xreos.lms.navigation.route.impl;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.route.base.NamedRoute;

public class DelegatedRoute<V extends AppView, C> implements NamedRoute {
    private final String id;
    private final V view;
    private final C controller;
    private final boolean bTransient;

    public DelegatedRoute(String id, V view, C controller, boolean bTransient) {
        this.id = id;
        this.view = view;
        this.controller = controller;
        this.bTransient = bTransient;
        view.onCreate();
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
    }

    @Override
    public void dispose() {
        this.view.deactivate();
        this.view.onDestroy();
    }

    @Override
    public boolean isTransient() {
        return this.bTransient;
    }
}
