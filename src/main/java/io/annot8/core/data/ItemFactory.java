package io.annot8.core.data;

import io.annot8.core.data.Item;
import java.util.function.Supplier;

/**
 * Factory to create new items.
 *
 * The implementation must always be able to create a new item, but it doesn't not need to support linking with child items.
 */
@FunctionalInterface
public interface ItemFactory {

  /**
   * Create a new item
   *
   * @return non-null
   */
  Item create();

  /**
   * Create a new item, linked to parent
   *
   * @param parent parent item
   * @return
   */
  default Item create(Item parent) {
    return create();
  }


}
