package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import io.annot8.core.data.Content;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes the content classes that the component will act upon
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Repeatable(ProcessesContents.class)
public @interface ProcessesContent {

  /**
   * @return content classes
   */
  Class<? extends Content<?>> value();

  boolean optional() default false;

}
