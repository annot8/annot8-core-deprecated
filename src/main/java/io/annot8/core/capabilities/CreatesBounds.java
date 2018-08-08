package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.bounds.Bounds;

/**
 * Denotes the annotation bounds which will be created by the component
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Inherited
public @interface CreatesBounds {

	/**
	 * @return the bound classes
	 */
	Class<? extends Bounds>[] value();


}
