package com.gildedrose;

import com.gildedrose.Items.GildedItem;
import com.gildedrose.Items.GildedItemFactory;

class GildedRose {
    GildedItem[] items;

    public GildedRose(Item[] items) {
        this.items = new GildedItem[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = GildedItemFactory.from(items[i]);
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) items[i].updateItemQuality();
    }

}
