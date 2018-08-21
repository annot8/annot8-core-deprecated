package io.annot8.core.annotations;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;
import io.annot8.core.helpers.builders.WithFrom;
import io.annot8.core.helpers.builders.WithNewIdBuilder;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;
import io.annot8.core.helpers.builders.WithSave;
import io.annot8.core.helpers.builders.WithTypeBuilder;
import io.annot8.core.references.AnnotationReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Base annotation interface from which all other annotations extend.
 */
public interface Group extends WithId, WithType, WithProperties {

  /**
   * Return a map of all roles with the associated annotations in this group
   */
  default Map<String, Stream<Annotation>> getAnnotations() {
    return getReferences().entrySet().stream().collect(Collectors.toMap(
        Entry::getKey,
        e -> AnnotationReference.toAnnotations(e.getValue())
    ));

  }

  /**
   * Return a map of all roles with the associated annotations in this group
   */
  Map<String, Stream<AnnotationReference>> getReferences();

  /**
   * Return all the annotations in this group with the specified role
   */
  default Stream<Annotation> getAnnotations(final String role) {
    return getAnnotations().get(role);
  }

  /**
   * Return all the roles currently associated with annotations in this group
   */
  default Stream<String> getRoles() {
    return getAnnotations().keySet().stream();
  }

  /**
   * Get the role of a specific annotation in this group
   */
  Optional<String> getRole(final Annotation annotation);

  /**
   * Return all the annotations in this group for the specified content.
   **/
  default Stream<Annotation> getAnnotationsForContent(String contentName) {
    return getAnnotations().values().stream()
        .flatMap(s -> s)
        .filter(a -> contentName.equals(a.getContentName()));
  }

  /**
   * Return all the annotations in this group for the specified content and role.
   **/
  default Stream<Annotation> getAnnotationsForContentAndRole(String contentName, String role) {
    return getAnnotations(role)
        .filter(a -> contentName.equals(a.getContentName()));
  }

  /**
   * Returns true if this group contains the specified annotation
   */
  boolean containsAnnotation(final Annotation annotation);

  /**
   * Returns true if this group contains at least one annotation with the specified role
   */
  default boolean containsRole(final String role) {
    return getRoles().anyMatch(role::equals);
  }

  /**
   * Do two instances represent the same underlying group?
   *
   * That is do they have the same id, even if they are different revisions.
   */
  default boolean sameGroup(Group other) {
    return other != null && getId().equals(other.getId());
  }

  /**
   * Builder interface to create (immutable) Group classes
   */
  interface Builder extends
      WithTypeBuilder<Builder>,
      WithPropertiesBuilder<Builder>,
      WithNewIdBuilder<Builder>,
      WithFrom<Builder, Group>,
      WithSave<Group> {

    /**
     * Add an annotation to this group with the specified role
     */
    Builder withAnnotation(final String role, final Annotation annotation);
  }
}
