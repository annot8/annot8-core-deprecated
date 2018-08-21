/**
 * This package contains the core interface for capabilities.
 *
 * Components are required to declare their capabilities with a Capabilities object, which may be
 * configuration dependent.
 *
 * Capabilities may be set using annotations on the component, or by the component returning a
 * Capabilities object.
 *
 * Returning a Capabilities object is useful in cases where the exact function of the component is
 * determined by configuration.
 */
package io.annot8.core.capabilities;