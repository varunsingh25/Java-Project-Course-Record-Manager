package edu.ccrm.util;

import edu.ccrm.domain.Course;
import java.util.Comparator;

/**
 * A utility class holding common Comparator instances.
 * Demonstrates: Lambdas for functional interfaces.
 */
public class Comparators {

    /** A comparator to sort courses by their code. */
    public static final Comparator<Course> COURSE_BY_CODE =
            (c1, c2) -> c1.getCode().getCode().compareTo(c2.getCode().getCode());

    /** A comparator to sort courses by their title. */
    public static final Comparator<Course> COURSE_BY_TITLE =
            Comparator.comparing(Course::getTitle);
}
