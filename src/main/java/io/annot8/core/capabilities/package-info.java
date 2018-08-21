/**
 * This package contains the core interface for capabilities.
 *
 * Capabilities may be set using annotations on the component, or by the component returning a
 * Capabilities object.
 *
 * In the case the components' capabilities are configuration dependent, the capabilities should be returned using buildCapabilities on {@link io.annot8.core.capabilities.AnnotationCapability}. This is typically the case where say the type of an annotation created is a configuration option.
 *
 * The annotations can be used, but these fixed at development time so can not take into runtime configuration.
 *
 * You can mix and match the annotation and capabiltiies, they will be fused together by Annot8. It is recommended that the annotation are used where possible as these are clearer to other developers and to the framework.
 *
 * For clarity capabilities are used as an optimisation (eg for pipeline ordering). Your component should not assume that it will have the resource it has declared a requirement for - it should not crash if requirements are not the case.
 */
package io.annot8.core.capabilities;