package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.helpers.WithGroups;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithMutableProperties;

/**
 * Base item interface from which all item implementations extend.
 */
public interface Item extends WithId, WithMutableProperties, WithGroups {

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

  /**
   * Creates a new item, with the current item set as the parent.
   */
  Item createChildItem();

  /**
   * Stop processing this item any further.
   *
   * Note that it is up to the underlying implementation as to whether they delete existing output from this item or not.
   *
   */
  void discard();

  /**
   * If this item is to be discarded at the end of current processing
   *
   * @return true if discarded
   */
  boolean isDiscarded();
}
