package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.data.Content;

/**
 * Denotes the content classes that the component will act upon
 *
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ProcessesContent {

	/**
	 * @return content classes
	 */
	Class<? extends Content<?>>[] value();

}
