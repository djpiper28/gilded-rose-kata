package com.gildedrose.Items;

import com.gildedrose.Item;

public abstract class GildedItem {
    private Item item;

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

    protected final boolean isItemOutOfDate() {
        return item.sellIn < 0;
    }

    protected final int getSellIn() {
        return item.sellIn;
    }

    protected final void decrementSellIn() {
        item.sellIn--;
    }

    protected final void zeroQuality() {
        item.quality = 0;
    }
}
