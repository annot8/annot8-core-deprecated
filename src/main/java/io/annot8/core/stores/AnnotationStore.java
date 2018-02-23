package io.annot8.core.stores;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Base annotations interface from which all other annotation stores extend.
 */
public interface AnnotationStore {

  /**
   * Return a builder object for the supported annotations
   */
  Annotation.Builder getBuilder();

  /**
   * Return a builder to create a new annotation
   */
  default Annotation.Builder create() {
    return getBuilder();
  }

  /**
   * Return a builder to based on the an existing  annotation, but don't overwrite that annotation
   * on save.
   */
  default Annotation.Builder copy(Annotation existing) {
    return getBuilder().from(existing).newId();
  }

  /**
   * Return a builder to edit an existing annotation
   */
  default Annotation.Builder edit(Annotation existing) {
    return getBuilder().from(existing);
  }

  /**
   * Delete an annotation from the store
   */
  void delete(final Annotation annotation);

  /**
   * Delete a collection of annotations from the store
   */
  default void delete(final Collection<Annotation> annotations) {
    annotations.forEach(this::delete);
  }

  /**
   * Delete all annotations from the store
   */
  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  /**
   * Get all annotations currently held in this store
   */
  Stream<Annotation> getAll();

  /**
   * Get all annotations of a given type currently held in this store
   */
  default Stream<Annotation> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

  /**
   * Get all annotations of a given bounds currently held in this store
   */
  default <B extends Bounds> Stream<Annotation> getByBounds(final Class<B> boundsClass) {
    return getAll()
        .filter(a -> a.getBounds() != null && boundsClass.isInstance(a.getBounds()));
  }

  /**
   * Get the annotation with the given ID, if it is currently held in this store
   */
  Optional<Annotation> getById(final String annotationId);

}
