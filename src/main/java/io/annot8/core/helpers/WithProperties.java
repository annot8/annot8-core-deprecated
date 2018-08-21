package io.annot8.core.helpers;

import io.annot8.core.properties.ImmutableProperties;

/**
 * Helper interface to indicate that a class supports ImmutableProperties
 */
public interface WithProperties {

  /**
   * Get the properties
   *
   * @return  the immutable properties associated with this object
   */
  ImmutableProperties getProperties();
}
