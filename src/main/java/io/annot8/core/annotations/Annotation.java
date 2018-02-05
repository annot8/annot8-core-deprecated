package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.WithBuild;
import io.annot8.core.helpers.builders.WithFrom;
import io.annot8.core.helpers.builders.WithNewIdBuilder;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;
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
   * Get the name of the Content to which this annotation refers
   */
  String getContentName();

  /**
   * Builder interface to create (immutable) Annotation classes
   */
  interface Builder extends
      WithTypeBuilder<Annotation.Builder>,
      WithPropertiesBuilder<Annotation.Builder>,
      WithNewIdBuilder<Annotation.Builder>,
      WithFrom<Annotation.Builder, Annotation>,
      WithBuild<Annotation> {

    /**
     * Set the {@link Bounds} associated with this annotation
     */
    Annotation.Builder withBounds(final Bounds bounds);
  }
}
