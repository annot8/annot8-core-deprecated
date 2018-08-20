package io.annot8.core.capabilities;

import io.annot8.core.components.Resource;
import io.annot8.core.data.Content;
import java.util.Objects;

public class ResourceCapability {

  private final Class<? extends Resource> type;

  private final boolean optional;

  public ResourceCapability(
      Class<? extends Resource> type, boolean optional) {
    this.type = type;
    this.optional = optional;
  }

  public ResourceCapability(UsesResource annotation) {
    this(
        annotation.value(),
        annotation.optional()
    );
  }

  public Class<? extends Resource> getType() {
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
    ResourceCapability that = (ResourceCapability) o;
    return optional == that.optional &&
        Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, optional);
  }
}
