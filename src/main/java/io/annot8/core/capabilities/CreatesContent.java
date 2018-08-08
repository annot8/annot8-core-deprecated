package io.annot8.core.capabilities;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.data.Content;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Inherited
public @interface CreatesContent {

	Class<? extends Content<?>>[] value();

}
