package io.annot8.core.components.responses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import io.annot8.core.data.Item;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class SourceResponseTest {

  @Test
  public void testOk() {
    SourceResponse sr = SourceResponse.ok();

    assertEquals(SourceResponse.Status.OK, sr.getStatus());
  }

  @Test
  public void testDone() {
    SourceResponse sr = SourceResponse.done();

    assertEquals(SourceResponse.Status.DONE, sr.getStatus());
  }

  @Test
  public void testSourceError() {
    SourceResponse sr = SourceResponse.sourceError();

    assertEquals(SourceResponse.Status.SOURCE_ERROR, sr.getStatus());
  }

  @Test
  public void testEmpty() {
    SourceResponse sr = SourceResponse.empty();

    assertEquals(SourceResponse.Status.EMPTY, sr.getStatus());
  }
}
