package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.grade.StudentGrade;
import co.xreos.lms.type.user.User;

public class StudentGradeRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static StudentGradeRepository instance;

    public static StudentGradeRepository getInstance() {
        if (instance == null) {
            instance = new StudentGradeRepository();
        }
        return instance;
    }

    public StudentGradeRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof StudentGrade);
    }
}