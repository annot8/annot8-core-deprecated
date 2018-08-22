package io.annot8.core.annotations;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.properties.ImmutableProperties;
import io.annot8.core.references.AnnotationReference;

public class TestGroup implements Group {

  private String id;
  private String type;
  private ImmutableProperties properties;
  private Map<String, Stream<AnnotationReference>> references;
  private String role;

  public TestGroup(String id, String type, ImmutableProperties properties,
      Map<String, Stream<AnnotationReference>> references, String role) {
    this.id = id;
    this.type = type;
    this.properties = properties;
    this.references = references;
    this.role = role;
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
  public Map<String, Stream<AnnotationReference>> getReferences() {
    return references;
  }

  @Override
  public Optional<String> getRole(Annotation annotation) {
    return Optional.of(role);
  }

  @Override
  public boolean containsAnnotation(Annotation annotation) {
    return false;
  }

}
