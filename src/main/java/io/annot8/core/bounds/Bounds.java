package io.annot8.core.bounds;

import java.util.Optional;

/**
 * Base bounds interface from which all other bounds extend.
 */
public interface Bounds {


  /**
   * Get the subset of data which is covered by these bounds.
   *
   * Most bounds will likely support only one (or very few) required class and data class.
   *
   * Return optional empty if their is nothing covered, or if the combinations are not supported.
   */
  <D, R> Optional<R> getData(D data, Class<R> requiredClass);
}
