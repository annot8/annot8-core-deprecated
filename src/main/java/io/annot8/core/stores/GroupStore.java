package io.annot8.core.stores;

import io.annot8.core.annotations.Group;
import io.annot8.core.exceptions.IncompleteException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Base groups interface from which all other group stores extend.
 */
public interface GroupStore {

  /**
   * Return a builder object for the supported group
   */
  Group.Builder getBuilder();

  /**
   * Return a builder to create a new annotation
   */
  default Group.Builder create() {
    return getBuilder();
  }

  /**
   * Return a builder to based on the an existing group, but don't overwrite that group on save.
   */
  default Group.Builder copy(Group existing) {
    return getBuilder().newId().from(existing);
  }


  /**
   * Return a builder to edit an existing group
   */
  default Group.Builder edit(Group existing) {
    return getBuilder().from(existing);
  }


  /**
   * Save a group to the store from a group builder
   */
  Group save(final Group.Builder groupBuilder) throws IncompleteException;

  /**
   * Delete a group from the store
   */
  void delete(final Group annotation);

  /**
   * Delete a collection of groups from the store
   */
  default void delete(final Collection<Group> annotations) {
    annotations.forEach(this::delete);
  }

  /**
   * Delete all groups from the store
   */
  default void deleteAll() {
    delete(getAll().collect(Collectors.toList()));
  }

  /**
   * Get all groups currently held in this store
   */
  Stream<Group> getAll();

  /**
   * Get all groups of a given type currently held in this store
   */
  default Stream<Group> getByType(final String type) {
    return getAll().filter(a -> type.equals(a.getType()));
  }

  /**
   * Get the group with the given ID, if it is currently held in this store
   */
  Optional<Group> getById(final String groupId);

}
