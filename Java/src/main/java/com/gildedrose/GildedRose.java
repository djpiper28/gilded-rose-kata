package com.gildedrose;

import com.gildedrose.Items.GildedItem;
import com.gildedrose.Items.GildedItemFactory;

import java.util.LinkedList;
import java.util.List;

class GildedRose {
    final private List<GildedItem> items = new LinkedList<>();

    public GildedRose(Item[] items) {
        for (final Item item : items) {
            this.items.add(GildedItemFactory.from(item));
        }
    }

    public void updateQuality() {
        for (final GildedItem item : items) item.updateItemQuality();
    }

}
