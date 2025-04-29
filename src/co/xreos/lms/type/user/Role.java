package co.xreos.lms.type.user;

public enum Role {
    TEACHER,
    STUDENT,
    TA;

    @Override
    public String toString() {
        return switch (this) {
            case TEACHER -> "Teacher";
            case STUDENT -> "Student";
            case TA -> "TA";
        };
    }
}