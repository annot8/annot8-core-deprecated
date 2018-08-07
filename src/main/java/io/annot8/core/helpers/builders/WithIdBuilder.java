package io.annot8.core.helpers.builders;

/**
 * Helper interface to indicate that a builder should assign a provided ID to an object
 *
 * @param <A> The builder class
 */
public interface WithIdBuilder<A> {

  /**
   * Return a builder with the given id
   */
  A withId(String id);

}
