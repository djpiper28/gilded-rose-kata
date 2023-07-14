package com.gildedrose.Items;

import com.gildedrose.Item;

public class AgedBrie extends GildedItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        incrementItemQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            incrementItemQuality();
        }
    }
}
