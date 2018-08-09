package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes the group types the component may output.
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Repeatable(CreatesGroups.class)
public @interface CreatesGroup {

	/**
	 * @return group types
	 */
	String value();

}