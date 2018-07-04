package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.helpers.WithGroups;
import io.annot8.core.helpers.WithMutableProperties;

/**
 * Base item interface from which all item implementations extend.
 */
public interface Item extends WithMutableProperties, WithGroups {

  /**
   * Return true if this item has a content object with the specified name
   */
  default boolean hasContent(final String name) {
    return listContents().anyMatch(name::equals);
  }

  /**
   * Return the names of the content objects currently held within this item
   */
  Stream<String> listContents();

  /**
   * Return the content object for the specified name
   */
  Optional<Content<?>> getContent(final String name);

  /**
   * Return all content objects contained within this item
   */
  Stream<Content<?>> getContents();

  /**
   * Return all content objects of the specified class contained within this item
   */
  <T extends Content<?>> Stream<T> getContents(final Class<T> clazz);

  /**
   * Create a new content builder to generate content.
   */
  <C extends Content<D>, D> Content.Builder<C, D> create(Class<C> clazz)
      throws UnsupportedContentException;

  /**
   * Remove the specified content object from this item
   */
  void removeContent(final String name);

}
