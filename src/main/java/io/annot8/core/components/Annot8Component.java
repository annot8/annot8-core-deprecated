package io.annot8.core.components;

import io.annot8.core.capabilities.AnnotationBasedCapabilities;
import io.annot8.core.capabilities.Capabilities;
import io.annot8.core.context.Context;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

/**
 * Base interface from which all other Annot8 components extend.
 */
public interface Annot8Component extends AutoCloseable {

  /**
   * Configure this component using information from the given context.
   *
   * This may be called at any time, and the component should re-configure as required.
   */
  default void configure(final Context context)
      throws BadConfigurationException, MissingResourceException {
    // Do nothing
  }

  @Override
  default void close()  {
    // Do nothing
  }

  /**
   * Return the capabilities of this component
   */
  default Capabilities getCapabilities() {
	  return new AnnotationBasedCapabilities(this.getClass());
  }
}
