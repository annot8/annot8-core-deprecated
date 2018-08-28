package io.annot8.core.capabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import io.annot8.core.bounds.Bounds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnnotationCapabilityTest {

  private static final String TEST_VALUE = "TEST_VALUE";

  @Mock
  private CreatesAnnotation createsAnnotation;

  @Mock
  private DeletesAnnotation deletesAnnotation;

  @Mock
  private ProcessesAnnotation processesAnnotation;

  @Mock
  private CreatesAnnotation empty;

  @Test
  public void testCreatesAnnotationConstructor() {
    doReturn(TestBounds.class).when(createsAnnotation).bounds();
    doReturn(TEST_VALUE).when(createsAnnotation).value();
    AnnotationCapability capability = new AnnotationCapability(createsAnnotation);
    assertEquals(TEST_VALUE, capability.getType());
    assertEquals(TestBounds.class, capability.getBounds());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testDeletesAnnotationConstructor() {
    doReturn(TestBounds.class).when(deletesAnnotation).bounds();
    doReturn(TEST_VALUE).when(deletesAnnotation).value();
    AnnotationCapability capability = new AnnotationCapability(deletesAnnotation);
    assertEquals(TestBounds.class, capability.getBounds());
    assertEquals(TEST_VALUE, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testProcessAnnotationConstructor() {
    doReturn(TestBounds.class).when(processesAnnotation).bounds();
    doReturn(TEST_VALUE).when(processesAnnotation).value();
    doReturn(true).when(processesAnnotation).optional();
    AnnotationCapability capability = new AnnotationCapability(processesAnnotation);
    assertEquals(TestBounds.class, capability.getBounds());
    assertEquals(TEST_VALUE, capability.getType());
    assertTrue(capability.isOptional());
  }

  @Test
  public void testEquals() {
    doReturn(TestBounds.class).when(createsAnnotation).bounds();
    doReturn(TEST_VALUE).when(createsAnnotation).value();

    AnnotationCapability cap1 = new AnnotationCapability(createsAnnotation);
    AnnotationCapability cap2 = new AnnotationCapability(createsAnnotation);
    assertTrue(cap1.equals(cap2));
    assertTrue(cap1.equals(cap1));
  }

  @Test
  public void testNotEquals() {
    doReturn(TestBounds.class).when(createsAnnotation).bounds();
    doReturn(TEST_VALUE).when(createsAnnotation).value();

    AnnotationCapability cap1 = new AnnotationCapability(createsAnnotation);
    AnnotationCapability cap2 = new AnnotationCapability(empty);

    assertFalse(cap1.equals(cap2));
    assertFalse(cap1.equals(null));
  }

  private abstract class TestBounds implements Bounds {
  }

}
