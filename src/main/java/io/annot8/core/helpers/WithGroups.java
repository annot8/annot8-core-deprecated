package io.annot8.core.helpers;

import io.annot8.core.annotations.Group;
import io.annot8.core.stores.GroupStore;

/**
 * Helper interface to indicate that a class supports GroupStore
 */
public interface WithGroups {

  /**
   * Return the groups contained within this object
   */
  GroupStore getGroups();
}
