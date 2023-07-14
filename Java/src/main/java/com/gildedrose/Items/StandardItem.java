package com.gildedrose.Items;

import com.gildedrose.Item;

public class StandardItem extends GildedItem {
    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        decrementItemQuality();
        item.sellIn--;
        if (item.sellIn < 0) {
            decrementItemQuality();
        }
    }
}
