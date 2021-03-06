package act.data.annotation;

import act.util.EqualField;
import act.util.EqualIgnore;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark a class eligible to auto generation on {@link Object#equals(Object)}
 * and {@link Object#hashCode()}.
 * <p>By default all fields will be used when generating the methods except</p>
 * <ul>
 *     <li>static fields are not considered</li>
 *     <li>transient fields are not considered unless {@link EqualField} annotation
 *     found on the field</li>
 *     <li>fields with {@link EqualIgnore} annotation presented</li>
 * </ul>
 * <p>If the {@link Object#equals(Object)} method found in the class, then the method
 * will not be generated</p>
 * <p>If the {@link Object#hashCode()} method found in the class, then the metheod
 * will not be generated</p>
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Data {
    /**
     * Whether the generated {@code equals} and {@code hashCode}
     * method should call super methods.
     * <p>If not specified, then super method will not be called</p>
     * @return {@code true} if super should be called in autogenerated
     *         methods
     */
    boolean callSuper() default false;
}
