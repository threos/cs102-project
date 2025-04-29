package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.routes.*;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.user.Teacher;
import co.xreos.lms.type.user.User;
import co.xreos.lms.view.LoginView;
import co.xreos.lms.view.TeacherView;

import javax.swing.*;

public class TeacherController extends AppController<TeacherView> {
    public TeacherController(TeacherView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getCreateCourseButton().addActionListener(e -> {
            Navigator.getInstance().pushNamed("/create-course");
        });
        view.getDeleteCourseButton().addActionListener(e -> {
            Navigator.getInstance().pushNamed("/delete-course");
        });
        view.getApproveCourseRequestButton().addActionListener(e -> {
            Navigator.getInstance().pushNamed("/approve-course-request");
        });
        view.getCreateGradebookItemButton().addActionListener(e -> {
            Navigator.getInstance().pushNamed("/create-gradebook-item");
        });
        view.getGradeStudentsButton().addActionListener(e -> {
            Navigator.getInstance().push(
                    new ChooseCourseRoute(course -> {
                        Navigator.getInstance().push(new GradeStudentRoute(course));
                    })
            );
        });
        view.getMakeAnnouncementButton().addActionListener(e -> {
            Navigator.getInstance().push(
                    new ChooseCourseRoute(course -> {
                        Navigator.getInstance().push(new MakeAnnouncementTopicRoute((topic) -> {
                            Navigator.getInstance().push(new MakeAnnouncementContentRoute(course, topic));
                        }));
                    })
            );
        });
        view.getViewCourseParticipantsButton().addActionListener(e -> {
            Navigator.getInstance().push(
                    new ChooseCourseRoute(course -> {
                        Navigator.getInstance().push(new ParticipantsRoute(course));
                    })
            );
        });
        view.getLogoutButton().addActionListener(e -> {
            AuthState.getInstance().logout();
            Navigator.getInstance().reset();
            Navigator.getInstance().push(new LoginRoute());
        });
    }

    @Override
    public void onDestroy() {}
}