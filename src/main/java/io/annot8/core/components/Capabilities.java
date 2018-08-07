package io.annot8.core.components;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.Content;
import java.util.stream.Stream;

/**
 * Base capabilities interface used to describe the capabilities of a component
 */
public interface Capabilities {

  /**
   * Return the type of any required input annotations (i.e. annotations that must be present before
   * a component can work)
   */
  Stream<String> getRequiredInputAnnotations();

  /**
   * Return the type of any optional input annotations (i.e. annotations that should be present if
   * possible before a component can work)
   */
  Stream<String> getOptionalInputAnnotations();

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<String> getOutputAnnotations();

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
  Stream<Class<? extends Resource>> getRequiredResources();

  /**
   * Return the bounds classes output by this component
   */
  Stream<Class<? extends Bounds>> getOutputBounds();
}
