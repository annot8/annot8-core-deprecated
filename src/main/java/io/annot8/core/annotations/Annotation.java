package io.annot8.core.annotations;

import java.util.Optional;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.WithFrom;
import io.annot8.core.helpers.builders.WithIdBuilder;
import io.annot8.core.helpers.builders.WithNewIdBuilder;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;
import io.annot8.core.helpers.builders.WithSave;
import io.annot8.core.helpers.builders.WithTypeBuilder;

/**
 * Base annotation interface from which all other annotations extend.
 */
public interface Annotation extends WithId, WithType, WithProperties {

  /**
   * Get the {@link Bounds} associated with this annotation
   */
  Bounds getBounds();

  /**
   * Get the {@link Bounds} associated with this annotation casting it to the bounds provided (if it
   * is of that type / subtype).
   */
  @SuppressWarnings("unchecked")
  default <B extends Bounds> Optional<B> getBounds(Class<B> boundsClass) {
    Bounds bounds = getBounds();
    if (bounds != null && boundsClass.isInstance(bounds)) {
      // This is checked
      return Optional.of((B) bounds);
    }
    return Optional.empty();
  }

  /**
   * Get the name of the Content to which this annotation refers
   */
  String getContentName();

  /**
   * Do two instances represent the same underlying annotations?
   *
   * That is do they have the same id, even if the rest of the data is different.
   */
  default boolean sameAnnotation(Annotation other) {
    return other != null && getId().equals(other.getId());
  }

  /**
   * Builder interface to create (immutable) Annotation classes
   */
  interface Builder extends WithTypeBuilder<Annotation.Builder>, WithIdBuilder<Annotation.Builder>,
      WithPropertiesBuilder<Annotation.Builder>, WithNewIdBuilder<Annotation.Builder>,
      WithFrom<Annotation.Builder, Annotation>, WithSave<Annotation> {

    /**
     * Set the {@link Bounds} associated with this annotation
     */
    Annotation.Builder withBounds(final Bounds bounds);
  }
}
