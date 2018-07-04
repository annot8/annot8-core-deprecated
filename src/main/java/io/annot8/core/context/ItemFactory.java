package io.annot8.core.context;

import io.annot8.core.data.Item;

/**
 * Factory to create new items
 */
public interface ItemFactory {

  /**
   * Create a new item
   *
   * @return non-null
   */
  Item create();

  /**
   * Creates a new item, with the current item set as the parent.
   *
   * Some implementation will maintain a connection between items, otherwise may not.
   */
  default Item create(Item parent) {
    return create();
  }

}
