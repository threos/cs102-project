package co.xreos.lms.routes;

import co.xreos.lms.controller.LoginController;
import co.xreos.lms.navigation.base.controller.ViewControllerBuilder;
import co.xreos.lms.navigation.route.base.NamedRoute;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.LoginView;

public class LoginRoute extends ViewControllerRoute<LoginView, LoginController> {
    public LoginRoute() {
        super("/login", new LoginView(), LoginController::new);
    }
}
