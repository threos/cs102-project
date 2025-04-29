package co.xreos.lms;

import co.xreos.lms.data.DataLoader;
import co.xreos.lms.data.DataSync;
import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.navigation.route.base.NamedRoute;
import co.xreos.lms.repository.CoreRepository;
import co.xreos.lms.repository.IRepository;
import co.xreos.lms.routes.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        initialize();

        ArrayList<NamedRoute> routes = new ArrayList<>();
        routes.add(new LoginRoute());
        routes.add(new TeacherRoute());
        routes.add(new CreateCourseRoute());
        routes.add(new DeleteCourseRoute());
        routes.add(new ApproveCourseRequestRoute());
        routes.add(new CreateGradebookItemRoute());
        routes.add(new StudentRoute());

        Navigator.initialize(routes);
    }

    private static void initialize() {
        CoreRepository coreRepository = CoreRepository.getInstance();
        DataSync.attachTo(coreRepository);
        loadData(coreRepository);
    }

    private static void loadData(IRepository<SerializableSchemaModel> repository) {
        try {
            DataLoader.loadAllData(repository);
        } catch (Throwable e) {
            System.out.println("Failed to load data: " + e.getMessage());

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
