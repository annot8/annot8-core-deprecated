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
  Stream<String> getRequiredAnnotations();

  /**
   * Return the type of any optional input annotations (i.e. annotations that should be present if
   * possible before a component can work)
   */
  Stream<String> getOptionalAnnotations();

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<String> getCreatedAnnotations();

  /**
   * Return the type of any required input annotations (i.e. annotations that must be present before
   * a component can work)
   */
  Stream<String> getRequiredGroups();
  
  /**
   * Return the type of any optional input annotations (i.e. annotations that should be present if
   * possible before a component can work)
   */
  Stream<String> getOptionalGroups();
  
  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<String> getCreatedGroups();

  /**
   * Return the content classes produced by this component, or an empty stream if no new content
   * will be produced
   */
  Stream<Class<? extends Content<?>>> getCreatedContent();

  /**
   * Return the type of any required content (i.e. content that must be present before
   * a component can work)
   */
  Stream<Class<? extends Content<?>>> getRequiredContent();

    /**
     * Return the resource classes required by this component
     */
  Stream<Class<? extends Resource>> getUsedResources();

  /**
   * Return the bounds classes output by this component
   */
  Stream<Class<? extends Bounds>> getCreatedBounds();


  interface Builder {

    Builder requiresAnnotation(String type);

    Builder optionalAnnotation(String type);

    Builder createsAnnotation(String type);

    Builder requiresGroup(String type);

    Builder optionalGroup(String type);

    Builder createsGroup(String type);

    Builder requiresContent(Class<? extends Content<?>> clazz);

    Builder createsContent(Class<? extends Content<?>> clazz);

    Builder usesResource(Class<? extends Resource> clazz);

    Builder createsBounds(Class<? extends Bounds> clazz);

    Capabilities save();

    default Builder merge(Capabilities capabilities) {

      if(capabilities != null) {
        applySafely(capabilities.getCreatedContent(), this::createsContent);
        applySafely(capabilities.getRequiredContent(), this::requiresContent);
        applySafely(capabilities.getCreatedAnnotations(), this::createsAnnotation);
        applySafely(capabilities.getCreatedBounds(), this::createsBounds);
        applySafely(capabilities.getCreatedGroups(), this::createsGroup);
        applySafely(capabilities.getOptionalAnnotations(), this::optionalAnnotation);
        applySafely(capabilities.getOptionalGroups(), this::optionalGroup);
        applySafely(capabilities.getRequiredAnnotations(), this::requiresAnnotation);
        applySafely(capabilities.getRequiredGroups(), this::requiresGroup);
        applySafely(capabilities.getUsedResources(), this::usesResource);
      }

      return this;
    }

    private <T> void applySafely(Stream<T> stream, Consumer<T> consumer) {
      if(stream == null) {
        return;
      }

      stream.filter(Objects::nonNull).forEach(consumer);
    }

  }
}
