package io.annot8.core.components.responses;

import io.annot8.core.data.Item;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Class to hold the response from a processor.
 *
 * The response consists of a status, and optionally any new items which should be processed by the
 * pipeline.
 */
public interface ProcessorResponse {

  /**
   * Create an OK response with no new items
   */
  static ProcessorResponseBuilder ok() {
    return new ProcessorResponseBuilder(Status.OK);
  }

  /**
   * Create an ITEM_ERROR response
   */
  static ProcessorResponseBuilder itemError() {
    return new ProcessorResponseBuilder(Status.ITEM_ERROR);
  }

  /**
   * Create a PIPELINE_ERROR response
   */
  static ProcessorResponseBuilder processingError() {
    return new ProcessorResponseBuilder(Status.PROCESSOR_ERROR);
  }

  /**
   * Return the status associated with this response
   */
  Status getStatus();

  /**
   * Response status returned by the processor
   */
  enum Status {
    /**
     * Indicates that the processor has worked successfully
     */
    OK,

    /**
     * Indicates that an error happened whilst processing this item, but that it should be possible
     * to process other items.
     */
    ITEM_ERROR,

    /**
     * Indicates that an error happened whilst processing this item, and that it will prevent other
     * items from being processed.
     */
    PROCESSOR_ERROR
  }

  class ProcessorResponseBuilder implements ProcessorResponse {

    private final Status status;

    protected ProcessorResponseBuilder(Status status) {
      this.status = status;
    }

    @Override
    public Status getStatus() {
      return status;
    }

  }
}
