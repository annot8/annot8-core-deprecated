/* Annot8 (annot8.io) - Licensed under Apache-2.0. */
package io.annot8.core.data;

@FunctionalInterface
public interface BaseItemToItem {

  Item convert(BaseItem item);
}
