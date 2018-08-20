package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.components.Resource;

/**
 * The resources which this component will required and use
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Repeatable(UsesResources.class)
public @interface UsesResource {

	/**
	 * @return resource class
	 */
	Class<? extends Resource> value();

	boolean optional() default false;

}
