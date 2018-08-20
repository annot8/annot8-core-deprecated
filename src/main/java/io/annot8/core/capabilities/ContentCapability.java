package io.annot8.core.capabilities;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.Content;
import java.util.Objects;

public class ContentCapability {

  private final Class<? extends Content> type;

  private final boolean optional;

  public ContentCapability(CreatesContent annotation) {
    this(
        annotation.value(),
        true
    );
  }

  public ContentCapability(DeletesContent annotation) {
    this(
        annotation.value(),
        true
    );
  }

  public ContentCapability(ProcessesContent annotation) {
    this(
        annotation.value(),
        annotation.optional()
    );
  }

  public ContentCapability(
      Class<? extends Content> type, boolean optional) {
    this.type = type;
    this.optional = optional;
  }

  public Class<? extends Content> getType() {
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
    ContentCapability that = (ContentCapability) o;
    return optional == that.optional &&
        Objects.equals(type, that.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, optional);
  }
}
