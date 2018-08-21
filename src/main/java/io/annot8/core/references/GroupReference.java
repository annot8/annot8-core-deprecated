package io.annot8.core.references;

import io.annot8.core.annotations.Group;
import java.util.Optional;
import java.util.stream.Stream;

public interface GroupReference {

  /**
   * Convert a stream of group references to groups
   */
  static Stream<Group> toGroups(Stream<GroupReference> references) {
    return references.map(GroupReference::toGroup)
        .filter(Optional::isPresent)
        .map(Optional::get);
  }

  /**
   * Get the id of the group which is referenced
   */
  String getGroupId();

  /**
   * Convert a reference to a group instance.
   *
   * Since the group may have been deleted, this returns an optional.
   */
  Optional<Group> toGroup();

}
