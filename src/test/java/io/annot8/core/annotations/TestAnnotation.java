package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.properties.ImmutableProperties;

public class TestAnnotation implements Annotation {

  private String id;
  private String type;
  private ImmutableProperties properties;
  private Bounds bounds;
  private String contentName;

  public TestAnnotation(String id, String type, ImmutableProperties properties, Bounds bounds,
      String contentName) {
    this.id = id;
    this.type = type;
    this.properties = properties;
    this.bounds = bounds;
    this.contentName = contentName;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public ImmutableProperties getProperties() {
    return properties;
  }

  @Override
  public Bounds getBounds() {
    return bounds;
  }

  @Override
  public String getContentName() {
    return contentName;
  }

}
