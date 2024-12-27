package co.xreos.lms.navigation.base.controller;

import co.xreos.lms.navigation.base.lifecycle.LifecycleObject;
import co.xreos.lms.navigation.base.view.AppView;

import javax.swing.text.View;

public abstract class AppController <V extends AppView> implements LifecycleObject {
    public final V view;
    public AppController(V view) {
        super();
        this.view = view;
    }
}