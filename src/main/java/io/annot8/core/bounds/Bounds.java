package io.annot8.core.bounds;

import io.annot8.core.data.Content;
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
  <D, C extends Content<D>, R> Optional<R> getData(C content, Class<R> requiredClass);


  /**
   * Are these bounds valid for the provided content?
   *
   * This means that for example the type of bounds are applicable for the data (ie bounds designed
   * for text are not applicable to image data) and that specifically this bounds is within the
   * content. (ie in the of text the bounds don't lie outside the range of the text).
   *
   * Note that returning true here does not imply that getData will not be empty. The bounds may
   * apply to the content but they may still cover no data.
   */
  <D, C extends Content<D>> boolean isValid(C content);
}
