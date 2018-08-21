package io.annot8.core.data;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.builders.WithFromBuilder;
import io.annot8.core.helpers.builders.WithIdBuilder;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;
import io.annot8.core.helpers.builders.WithSave;
import io.annot8.core.stores.AnnotationStore;

/**
 * Base content interface from which all content implementations extend.
 *
 * @type D the type of data held
 */
public interface Content<D> extends WithId, WithProperties {

  /**
   * The data associated with this content object
   *
   * @return the data
   */
  D getData();

  /**
   * The class of the data stored in this Content object
   *
   * @return data class
   */
  Class<D> getDataClass();

  /**
   * The top level content interface this object implements
   *
   * @return common content interface
   */
  Class<? extends Content<D>> getContentClass();

  /**
   * The annotation store for this content
   *
   * @return annotation store
   */
  AnnotationStore getAnnotations();

  /**
   * The name of this content
   *
   * @return name
   */
  String getName();

  /**
   * Builder interface to create (immutable) Content classes
   */
  interface Builder<A extends Content<D>, D> extends
      WithPropertiesBuilder<Builder<A, D>>,
      WithFromBuilder<Builder<A, D>, A>,
      WithIdBuilder<Builder<A, D>>,
      WithSave<A> {

    /**
     * Set the name of this content object
     *
     * @param name the content name
     * @return this builder for chaining
     */
    Content.Builder<A, D> withName(final String name);

    /**
     * Set the data for this content object
     *
     * @param data the data name
     * @return this builder for chaining
     */
    Content.Builder<A, D> withData(final D data);

  }
}
