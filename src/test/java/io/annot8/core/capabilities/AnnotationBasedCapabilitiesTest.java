package io.annot8.core.capabilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Resource;
import io.annot8.core.data.Content;
import io.annot8.core.properties.ImmutableProperties;
import io.annot8.core.stores.AnnotationStore;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnnotationBasedCapabilitiesTest {


  private AnnotationBasedCapabilities capabilities;

  @BeforeEach
  void beforeEach() {
    capabilities = new AnnotationBasedCapabilities(AnnotatedComponent.class);
  }

  @Test
  void getRequiredInputAnnotations() {
    assertThat(capabilities.getRequiredInputAnnotations()).containsExactlyInAnyOrder("ar1", "ar2");
  }

  @Test
  void getOptionalInputAnnotations() {
    assertThat(capabilities.getOptionalInputAnnotations()).containsExactlyInAnyOrder("ao1");

  }

  @Test
  void getOutputAnnotations() {
    assertThat(capabilities.getOutputAnnotations()).containsExactlyInAnyOrder("a1", "a2");

  }

  @Test
  void getRequiredInputGroups() {
    assertThat(capabilities.getRequiredInputGroups()).containsExactlyInAnyOrder("gr1", "gr2");

  }

  @Test
  void getOptionalInputGroups() {
    assertThat(capabilities.getOptionalInputGroups()).containsExactlyInAnyOrder("go1");

  }

  @Test
  void getOutputGroups() {
    assertThat(capabilities.getOutputGroups()).containsExactlyInAnyOrder("g");

  }

  @Test
  void getCreatedContent() {
    assertThat(capabilities.getCreatedContent()).containsExactlyInAnyOrder(FakeContent.class);

  }

  @Test
  void getRequiredContent() {
    assertThat(capabilities.getRequiredContent()).containsExactlyInAnyOrder(FakeContent.class);

  }

  @Test
  void getRequiredResources() {
    assertThat(capabilities.getRequiredResources()).containsExactlyInAnyOrder(Resource.class);
  }

  @Test
  void getOutputBounds() {
    assertThat(capabilities.getOutputBounds()).containsExactlyInAnyOrder(FakeBounds.class);

  }

  @Test
  void getOutputGroupsForChildComponent() {
    AnnotationBasedCapabilities child = new AnnotationBasedCapabilities(ChildAnnotatedComponent.class);
    assertThat(child.getOutputGroups()).containsExactlyInAnyOrder("sg");
  }


  @CreatesAnnotation(type="a1", bounds=FakeBounds.class)
  @CreatesAnnotation(type="a2", bounds=FakeBounds.class)
  @CreatesContent(FakeContent.class)
  @CreatesGroup("g")
  @ProcessesAnnotations(value = "ar1", required = "ar2", optional = "ao1")
  @ProcessesContent(FakeContent.class)
  @ProcessesGroups(value = "gr1", required = "gr2", optional = "go1")
  @UsesResource(Resource.class)
  public static class AnnotatedComponent implements Annot8Component {

  }

  @CreatesGroup("sg")
  public static class ChildAnnotatedComponent extends AnnotatedComponent {

  }

  public static class FakeContent implements Content<String> {

    @Override
    public String getData() {
      return null;
    }

    @Override
    public Class<String> getDataClass() {
      return null;
    }

    @Override
    public Class<? extends Content<String>> getContentClass() {
      return null;
    }

    @Override
    public AnnotationStore getAnnotations() {
      return null;
    }

    @Override
    public String getName() {
      return null;
    }

    @Override
    public String getId() {
      return null;
    }

    @Override
    public ImmutableProperties getProperties() {
      return null;
    }
  }

    public static class FakeBounds implements Bounds {

    @Override
    public <D, C extends Content<D>, R> Optional<R> getData(C content, Class<R> requiredClass) {
      return Optional.empty();
    }

    @Override
    public <D, C extends Content<D>> boolean isValid(C content) {
      return false;
    }
  }
}