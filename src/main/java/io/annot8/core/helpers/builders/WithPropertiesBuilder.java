package io.annot8.core.helpers.builders;

import io.annot8.core.properties.Properties;

/**
 * Helper interface to indicate that a builder should support adding properties to an object
 *
 * @param <A> The builder class
 */
public interface WithPropertiesBuilder<A> {

  /**
   * Add a property
   * @param key the key
   * @param value the value
   * @return  a builder with the key-value property pair added to it
   */
  A withProperty(final String key, final Object value);

  /**
   * Remove a property with matching key and value
   *
   * @param key the key to remove
   * @param value the value to remove
   * @return  a builder with the key-value property pair removed from it
   */
  A withoutProperty(final String key, final Object value);

  /**
   * Remove a property
   *
   * @param key the key to remove
   * @return  a builder with the key removed from it
   */
  A withoutProperty(final String key);

  /**
   * Add in existing properties
   *
   * @param properties to add
   * @return  a builder with the specified properties
   */
  A withProperties(final Properties properties);
}
