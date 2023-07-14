package com.gildedrose.Items;

import com.gildedrose.Item;

public class ConjuredItem extends GildedItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        decrementItemQuality();
        decrementItemQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            decrementItemQuality();
            decrementItemQuality();
        }
    }
}
