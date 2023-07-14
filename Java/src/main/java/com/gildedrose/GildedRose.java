package com.gildedrose;

import com.gildedrose.Items.GildedItem;
import com.gildedrose.Items.GildedItemFactory;
import java.util.List;
import java.util.Arrays;

class GildedRose {
    private final List<GildedItem> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items).map(GildedItemFactory::from).toList();
    }

    public void updateQuality() {
        items.forEach(GildedItem::updateItemQuality);
    }
}
