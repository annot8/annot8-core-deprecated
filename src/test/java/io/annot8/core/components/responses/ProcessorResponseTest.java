package io.annot8.core.components.responses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import io.annot8.core.components.responses.ProcessorResponse.Status;

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
