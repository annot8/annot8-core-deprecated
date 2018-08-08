package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.data.Content;

/**
 * Denotes that the component will generate content.
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Inherited
public @interface CreatesContent {

	/**
	 * @return the content class which will be generated
	 */
	Class<? extends Content<?>>[] value();

}
