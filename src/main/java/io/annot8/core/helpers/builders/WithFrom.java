package io.annot8.core.helpers.builders;

/**
 * Helper interface to indicate that a builder can create an object based off an existing object of
 * the same type
 *
 * @param <E> The builder class
 * @param <A> The class to derive from
 */
public interface WithFrom<E, A> {

  /**
   * Return a builder based on an existing object
   */
  E from(final A from);
}
