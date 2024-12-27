package co.xreos.lms.navigation.base.view;

import co.xreos.lms.navigation.base.controller.AppController;

public interface ViewBuilder<V extends AppView> {
    public V build();
}
