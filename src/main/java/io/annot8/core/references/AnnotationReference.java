package io.annot8.core.references;

import io.annot8.core.annotations.Annotation;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A reference to an annotation.
 *
 * As annotations can change (though their id and content stays the same) we can't simply hold
 * Annotation in Java objects. Instead we hold a reference to them (based on content and annotation
 * ids).
 *
 * Since an content or annotation may be deleted, we do not know if the annotation still exists when
 * we call toAnnotation.
 */
public interface AnnotationReference {


  /**
   * Convert a stream of annotation references to annotations
   */
  static Stream<Annotation> toAnnotations(Stream<AnnotationReference> references) {
    return references.map(AnnotationReference::toAnnotation)
        .filter(Optional::isPresent)
        .map(Optional::get);
  }

  /**
   * The name of the content to which this annotation belongs.
   */
  String getContentName();

  /**
   * The annotation's id
   */
  String getAnnotationId();

  /**
   * Convert the reference to an annotations.
   *
   * Since the underlying content or annotation may have been deleted this returns an optional.
   *
   */
  Optional<Annotation> toAnnotation();

}
