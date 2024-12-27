package co.xreos.lms.navigation.base.view;

import co.xreos.lms.navigation.base.lifecycle.LifecycleObject;

import javax.swing.*;

public abstract class AppView extends JFrame implements LifecycleObject {
    public AppView(String title) {
        super(title);
    }

    @Override
    public void onDestroy() {
        dispose();
    }
}