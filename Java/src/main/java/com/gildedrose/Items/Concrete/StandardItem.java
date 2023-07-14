package com.gildedrose.Items.Concrete;

import com.gildedrose.Item;
import com.gildedrose.Items.GildedItem;

public class StandardItem extends GildedItem {
    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        decrementItemQuality();
        item.sellIn--;
        if (isItemOutOfDate()) {
            decrementItemQuality();
        }
    }
}
