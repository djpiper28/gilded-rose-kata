package com.gildedrose.Items;

import com.gildedrose.Item;

public abstract class GildedItem {
    protected Item item;

    public GildedItem(final Item item) {
        this.item = item;
    }

    public abstract void updateItemQuality();

    protected final void decrementItemQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected final void incrementItemQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
