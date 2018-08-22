package io.annot8.core.capabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import io.annot8.core.components.Resource;

@ExtendWith(MockitoExtension.class)
public class ResourceCapabilityTest {

  @Mock
  private UsesResource usesResource;

  @Mock
  private UsesResource empty;

  @Test
  public void testUsesResourceConstructor() {
    doReturn(TestResource.class).when(usesResource).value();
    doReturn(true).when(usesResource).optional();

    ResourceCapability capability = new ResourceCapability(usesResource);
    assertEquals(TestResource.class, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testEquals() {
    doReturn(TestResource.class).when(usesResource).value();
    doReturn(true).when(usesResource).optional();
    ResourceCapability capability = new ResourceCapability(usesResource);
    ResourceCapability capability2 = new ResourceCapability(usesResource);

    assertTrue(capability.equals(capability2));
    assertTrue(capability.equals(capability));
  }

  @Test
  public void testNotEquals() {
    doReturn(TestResource.class).when(usesResource).value();
    doReturn(true).when(usesResource).optional();
    ResourceCapability capability = new ResourceCapability(usesResource);
    ResourceCapability capability2 = new ResourceCapability(empty);
    assertFalse(capability.equals(capability2));
    assertFalse(capability.equals(null));
  }

  private abstract class TestResource implements Resource {
  };

}
