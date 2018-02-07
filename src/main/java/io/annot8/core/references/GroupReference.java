package io.annot8.core.references;

import io.annot8.core.annotations.Group;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public interface GroupReference {

  static Stream<Group> toGroups(Stream<GroupReference> references) {
    return references.map(GroupReference::toGroup)
        .filter(Optional::isPresent)
        .map(Optional::get);
  }

  String getGroupId();

  Optional<Group> toGroup();

  default boolean sameReference(Object other) {
    if (this == other) {
      return true;
    }

    if (other == null) {
      return false;
    }

    if (!GroupReference.class.isAssignableFrom(other.getClass())) {
      return false;
    }

    GroupReference that = (GroupReference) other;
    return Objects.equals(getGroupId(), that.getGroupId());
  }
}
