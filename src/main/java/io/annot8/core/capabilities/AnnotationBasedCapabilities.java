package io.annot8.core.capabilities;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Resource;
import io.annot8.core.data.Content;

/**
 * Implementation of Capabilities which uses annotations on the component class to determine its' capabilities.
 * 
 * Annotations are defined in the same package.
 * 
 * Ideally this implementation would not be part of core, but it acts as the default implementation and as such needs to be
 * importable by {@link Annot8Component}.
 *
 */
public class AnnotationBasedCapabilities implements Capabilities {
	
	private final Class<? extends Annot8Component> clazz;

	/**
	 * Constructor which will review the annotations on the provided class to implement interface. 
	 * 
	 * @param clazz
	 */
	public AnnotationBasedCapabilities(Class<? extends Annot8Component> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Stream<String> getRequiredAnnotations() {
		return extractFromAnnotations(ProcessesAnnotations.class, a -> {
			
			Stream<String> value = extractArrayAsStream(a.value());
			Stream<String> required = extractArrayAsStream(a.required());
			
			return Stream.concat(required, value);
		});
				
	}

	@Override
	public Stream<String> getOptionalAnnotations() {
		return extractFromAnnotations(ProcessesAnnotations.class, a -> extractArrayAsStream(a.optional()));
	}

	@Override
	public Stream<String> getCreatedAnnotations() {
		return extractFromAnnotations(CreatesAnnotation.class, a -> extractItemAsStream(a.type()));
	}
	
	@Override
	public Stream<String> getRequiredGroups() {
		return extractFromAnnotations(ProcessesGroups.class, a -> {
			
			Stream<String> value = extractArrayAsStream(a.value());
			Stream<String> required = extractArrayAsStream(a.required());
			
			return Stream.concat(required, value);
		});
				
	}

	@Override
	public Stream<String> getOptionalGroups() {
		return extractFromAnnotations(ProcessesGroups.class, a -> extractArrayAsStream(a.optional()));
	}

	@Override
	public Stream<String> getCreatedGroups() {
		return extractFromAnnotations(CreatesGroup.class, a -> extractItemAsStream(a.value()));
	}

	@Override
	public Stream<Class<? extends Content<?>>> getCreatedContent() {
		return extractFromAnnotations(CreatesContent.class, a -> extractItemAsStream(a.value()));

	}

	@Override
	public Stream<Class<? extends Content<?>>> getRequiredContent() {
		return extractFromAnnotations(ProcessesContent.class, a -> extractArrayAsStream(a.value()));
	}

	@Override
	public Stream<Class<? extends Resource>> getUsedResources() {
		return extractFromAnnotations(UsesResource.class, a -> extractItemAsStream(a.value()));

	}

	@Override
	public Stream<Class<? extends Bounds>> getCreatedBounds() {
		return extractFromAnnotations(CreatesAnnotation.class, a -> extractItemAsStream(a.bounds()));
	}
	
	protected <T>  Stream<T> extractArrayAsStream(T[] value) {
		if(value == null || value.length == 0) {
			return Stream.empty();
		} else {
			return Arrays.stream(value).filter(Objects::nonNull);
		}
	}


	protected <T>  Stream<T> extractItemAsStream(T value) {
		if(value == null) {
			return Stream.empty();
		} else {
			return Stream.of(value);
		}
	}

	protected <A extends Annotation,T> Stream<T> extractFromAnnotations(Class<A> annotationClass, Function<A,Stream<T>> extractor) {
		A[] annotations = clazz.getAnnotationsByType(annotationClass);
		return Arrays.stream(annotations)
				.flatMap(extractor)
				.distinct();
	}

}
