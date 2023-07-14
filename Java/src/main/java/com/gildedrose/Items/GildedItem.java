package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItem {
    protected Item item;

    public GildedItem(final Item item) {
        this.item = item;
    }

    public void updateItemQuality() {
        updateItemsPreSellInDecrement();
        item.sellIn--;
        updateitemsPostSellInDecrement();
    }

    protected void updateItemsPreSellInDecrement() {
        decrementItemQuality();
    }

    protected void updateitemsPostSellInDecrement() {
        if (item.sellIn < 0) {
            decrementItemQuality();
        }
    }

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
