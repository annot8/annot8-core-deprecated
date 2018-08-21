package io.annot8.core.capabilities;

import java.util.Objects;

public class GroupCapability {

  private final String type;

  private final boolean optional;

  public GroupCapability(String type, boolean optional) {
    this.type = type;
    this.optional = optional;
  }

  public GroupCapability(CreatesGroup annotation) {
    this(
        annotation.value(),
        true
    );
  }

  public GroupCapability(DeletesGroup annotation) {
    this(
        annotation.value(),
        true
    );
  }

  public GroupCapability(ProcessesGroup annotation) {
    this(
        annotation.value(),
        annotation.optional()
    );
  }

  public String getType() {
    return type;
  }

  public boolean isOptional() {
    return optional;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupCapability that = (GroupCapability) o;
    return optional == that.optional &&
        Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, optional);
  }
}
