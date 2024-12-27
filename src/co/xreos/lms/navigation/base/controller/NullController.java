package co.xreos.lms.navigation.base.controller;

import co.xreos.lms.navigation.base.lifecycle.LifecycleObject;
import co.xreos.lms.navigation.base.view.AppView;

public class NullController extends AppController<AppView> {
    public NullController(AppView view) {
        super(view);
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}