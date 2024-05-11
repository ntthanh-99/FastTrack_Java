package day4.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = TestAnnotations.class)
public @interface TestAnnotation {
    String name() default "ThanhNT";
    int age() default 18;
    String[] reviewer();
}
