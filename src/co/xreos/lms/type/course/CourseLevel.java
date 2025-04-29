package co.xreos.lms.type.course;

public enum CourseLevel {
    UNDERGRADUATE,
    GRADUATE;

    @Override
    public String toString() {
        return switch (this) {
            case UNDERGRADUATE -> "Undergraduate";
            case GRADUATE -> "Graduate";
        };
    }
}