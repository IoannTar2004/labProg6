package src.annotations;

public @interface Validation {
    String value() default ".*";
}
