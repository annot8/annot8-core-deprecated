package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import io.annot8.core.bounds.Bounds;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes the annotation types which the component will output.
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Repeatable(CreatesAnnotations.class)
public @interface CreatesAnnotation {


	/**
	 * @return annotation types
	 */
	String type();

	/**
	 * @return the bound classes
	 */
	Class<? extends Bounds> bounds();
	
}
