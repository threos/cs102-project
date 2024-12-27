package co.xreos.lms;

import co.xreos.lms.data.DataLoader;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.navigation.route.base.NamedRoute;
import co.xreos.lms.routes.LoginRoute;
import co.xreos.lms.routes.TeacherRoute;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        initialize();

        ArrayList<NamedRoute> routes = new ArrayList<>();
        routes.add(new LoginRoute());
        routes.add(new TeacherRoute());

        Navigator.initialize(routes);
    }

    private static void initialize() {
        try {
            DataLoader.loadAllData();
        } catch (Throwable e) {
            System.out.println("Failed to load data: " + e.getMessage());
            e.printStackTrace();

            int dialogResult = JOptionPane.showConfirmDialog (null, "The file seems to be corrupted. Would you like to reset all data and try again?","Warning", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                DataLoader.reset();
                initialize();
            } else {
                System.exit(0);
            }
        }
    }
}
