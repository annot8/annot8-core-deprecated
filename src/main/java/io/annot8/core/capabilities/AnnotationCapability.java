package io.annot8.core.capabilities;

import io.annot8.core.bounds.Bounds;
import java.util.Objects;

public class AnnotationCapability {

  private final String type;

  private final Class<? extends Bounds> bounds;

  private final boolean optional;

  public AnnotationCapability(CreatesAnnotation annotation) {
    this(
        annotation.value(),
        annotation.bounds(),
        true
    );
  }

  public AnnotationCapability(DeletesAnnotation annotation) {
    this(
        annotation.value(),
        annotation.bounds(),
        true
    );
  }

  public AnnotationCapability(ProcessesAnnotation annotation) {
    this(
        annotation.value(),
        annotation.bounds(),
        annotation.optional()
    );
  }

  public AnnotationCapability(String type,
      Class<? extends Bounds> bounds, boolean optional) {
    this.type = type;
    this.bounds = bounds;
    this.optional = optional;
  }

  public String getType() {
    return type;
  }

  public Class<? extends Bounds> getBounds() {
    return bounds;
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
    AnnotationCapability that = (AnnotationCapability) o;
    return optional == that.optional &&
        Objects.equals(type, that.type) &&
        Objects.equals(bounds, that.bounds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, bounds, optional);
  }
}
