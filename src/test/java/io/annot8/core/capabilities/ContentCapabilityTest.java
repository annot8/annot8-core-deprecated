package io.annot8.core.capabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import io.annot8.core.data.Content;

@ExtendWith(MockitoExtension.class)
public class ContentCapabilityTest {

  @Mock
  private CreatesContent createsContent;

  @Mock
  private DeletesContent deletesContent;

  @Mock
  private ProcessesContent processesContent;

  @Test
  public void testCreatesContentConstructor() {
    doReturn(TestContent.class).when(createsContent).value();
    ContentCapability capability = new ContentCapability(createsContent);
    assertEquals(TestContent.class, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testDeletesContentConstructor() {
    doReturn(TestContent.class).when(deletesContent).value();
    ContentCapability capability = new ContentCapability(deletesContent);
    assertEquals(TestContent.class, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testProcessesContentConstructor() {
    doReturn(TestContent.class).when(processesContent).value();
    doReturn(true).when(processesContent).optional();
    ContentCapability capability = new ContentCapability(processesContent);
    assertEquals(TestContent.class, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testEquals() {
    doReturn(TestContent.class).when(createsContent).value();
    ContentCapability capability = new ContentCapability(createsContent);
    ContentCapability capability2 = new ContentCapability(createsContent);
    assertTrue(capability.equals(capability2));
    assertTrue(capability.equals(capability));
  }

  @Test
  public void testNotEquals() {
    doReturn(TestContent.class).when(createsContent).value();
    ContentCapability capability = new ContentCapability(createsContent);
    ContentCapability capability2 = new ContentCapability(Mockito.mock(CreatesContent.class));
    assertFalse(capability.equals(capability2));
    assertFalse(capability.equals(null));
  }

  private abstract class TestContent implements Content<String> {
  }

}
