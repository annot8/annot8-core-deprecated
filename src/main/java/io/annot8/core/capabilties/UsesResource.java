package io.annot8.core.capabilties;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.annot8.core.components.Resource;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Inherited
public @interface UsesResource {

	Class<? extends Resource>[] value();


}
