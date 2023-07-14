package com.gildedrose.Items.Concrete;

import com.gildedrose.Item;
import com.gildedrose.Items.GildedItem;

public class AgedBrie extends GildedItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        incrementItemQuality();
        decrementSellIn();
        if (isItemOutOfDate()) {
            incrementItemQuality();
        }
    }
}
