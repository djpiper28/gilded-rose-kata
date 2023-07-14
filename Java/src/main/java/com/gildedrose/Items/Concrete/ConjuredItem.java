package com.gildedrose.Items.Concrete;

import com.gildedrose.Item;
import com.gildedrose.Items.GildedItem;

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