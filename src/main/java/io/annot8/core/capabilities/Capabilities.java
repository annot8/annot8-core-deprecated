package io.annot8.core.capabilities;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Resource;
import io.annot8.core.data.Content;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Base capabilities interface used to describe the capabilities of a component
 */
public interface Capabilities {

  /**
   * Return the type of any required input annotations (i.e. annotations that must be present before
   * a component can work)
   */
  Stream<AnnotationCapability> getProcessedAnnotations();


  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<AnnotationCapability> getCreatedAnnotations();

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<AnnotationCapability> getDeletedAnnotations();

  /**
   * Return the type of any required input annotations (i.e. annotations that must be present before
   * a component can work)
   */
  Stream<GroupCapability> getProcessedGroups();

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<GroupCapability> getCreatedGroups();


  /**
   * Return the type of any output annotations deleted by this component
   */
  Stream<GroupCapability> getDeletedGroups();

  /**
   * Return the content classes produced by this component, or an empty stream if no new content
   * will be produced
   */
  Stream<ContentCapability> getCreatedContent();


  /**
   * Return the type of any deleted content
   */
  Stream<ContentCapability> getDeletedContent();

  /**
   * Return the type of any required content (i.e. content that must be present before a component
   * can work)
   */
  Stream<ContentCapability> getProcessedContent();

  /**
   * Return the resource classes required by this component
   */
  Stream<ResourceCapability> getUsedResources();


  interface Builder {

    default Builder processesAnnotation(String type, Class<? extends Bounds> clazz,
        boolean optional) {
      return processesAnnotation(new AnnotationCapability(type, clazz, optional));
    }

    default Builder createsAnnotation(String type, Class<? extends Bounds> clazz) {
      return createsAnnotation(new AnnotationCapability(type, clazz, true));
    }

    default Builder deletesAnnotation(String type, Class<? extends Bounds> clazz) {
      return deletesAnnotation(new AnnotationCapability(type, clazz, true));
    }

    default Builder processesGroup(String type, boolean optional) {
      return processesGroup(new GroupCapability(type, true));
    }

    default Builder createsGroup(String type) {
      return createsGroup(new GroupCapability(type, true));
    }

    default Builder deletesGroup(String type) {
      return deletesGroup(new GroupCapability(type, true));
    }

    default Builder processesContent(Class<? extends Content<?>> clazz, boolean optional) {
      return processesContent(new ContentCapability(clazz, optional));
    }

    default Builder createsContent(Class<? extends Content<?>> clazz) {
      return createsContent(new ContentCapability(clazz, true));
    }

    default Builder deletesContent(Class<? extends Content<?>> clazz) {
      return deletesContent(new ContentCapability(clazz, true));
    }

    default Builder usesResource(Class<? extends Resource> clazz, boolean optional) {
      return usesResource(new ResourceCapability(clazz, true));
    }

    Builder processesAnnotation(AnnotationCapability capability);

    Builder createsAnnotation(AnnotationCapability capability);

    Builder deletesAnnotation(AnnotationCapability capability);

    Builder processesGroup(GroupCapability capability);

    Builder createsGroup(GroupCapability capability);

    Builder deletesGroup(GroupCapability capability);

    Builder processesContent(ContentCapability capability);

    Builder createsContent(ContentCapability capability);

    Builder deletesContent(ContentCapability capability);

    Builder usesResource(ResourceCapability capability);

    Capabilities save();

    default Builder merge(Capabilities capabilities) {

      if (capabilities != null) {
        applySafely(capabilities.getCreatedContent(), this::createsContent);
        applySafely(capabilities.getCreatedAnnotations(), this::createsAnnotation);
        applySafely(capabilities.getCreatedGroups(), this::createsGroup);

        applySafely(capabilities.getProcessedAnnotations(), this::processesAnnotation);
        applySafely(capabilities.getProcessedContent(), this::processesContent);
        applySafely(capabilities.getProcessedGroups(), this::processesGroup);

        applySafely(capabilities.getUsedResources(), this::usesResource);

        applySafely(capabilities.getDeletedAnnotations(), this::deletesAnnotation);
        applySafely(capabilities.getDeletedGroups(), this::deletesGroup);
        applySafely(capabilities.getDeletedContent(), this::deletesContent);
      }

      return this;
    }

    private <T> void applySafely(Stream<T> stream, Consumer<T> consumer) {
      if (stream == null) {
        return;
      }

      stream.filter(Objects::nonNull).forEach(consumer);
    }

  }
}
