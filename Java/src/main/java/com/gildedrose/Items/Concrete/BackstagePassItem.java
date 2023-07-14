package com.gildedrose.Items.Concrete;

import com.gildedrose.Item;
import com.gildedrose.Items.GildedItem;

public class BackstagePassItem extends GildedItem {
    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        incrementItemQuality();
        if (getSellIn() < 11) {
            incrementItemQuality();
        }

        if (getSellIn() < 6) {
            incrementItemQuality();
        }

        decrementSellIn();

        if (isItemOutOfDate()) {
            zeroQuality();
        }
    }
}
