package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes the groups types which are processed by the component.
 * 
 * To simply use value and required are synonymous and either can be used. If both are used they are merged into a combined list. 
 * 
 * Optional types are not needed in order for the component to generate output, but they may enhance the processing.
 *  
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface ProcessesGroup {

	/**
	 * @return required annotation types 
	 */
	String value();

	boolean optional() default false;


}
