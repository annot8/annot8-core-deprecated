package io.annot8.core.helpers.builders;

/**
 * Helper interface to indicate that a builder should assign a provided ID to an object
 *
 * @param <A> The builder class
 */
public interface WithIdBuilder<A> {

  /**
   * Set the id
   *
   * @param id  the id to set
   * @return  a builder with the given id
   */
  A withId(String id);

}
