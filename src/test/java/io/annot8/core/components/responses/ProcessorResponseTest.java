package io.annot8.core.components.responses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import io.annot8.core.components.responses.ProcessorResponse.ProcessorResponseBuilder;
import io.annot8.core.components.responses.ProcessorResponse.Status;
import io.annot8.core.data.Item;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class ProcessorResponseTest {

  @Test
  public void testOk() {
    ProcessorResponse sr = ProcessorResponse.ok();

    assertEquals(ProcessorResponse.Status.OK, sr.getStatus());
  }

  @Test
  public void testItemError() {
    ProcessorResponse sr = ProcessorResponse.itemError();

    assertEquals(ProcessorResponse.Status.ITEM_ERROR, sr.getStatus());
  }

  @Test
  public void testPipelineError() {
    ProcessorResponse sr = ProcessorResponse.processingError();

    assertEquals(Status.PROCESSOR_ERROR, sr.getStatus());
   }
}
