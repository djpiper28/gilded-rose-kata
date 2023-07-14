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
        if (item.sellIn < 11) {
            incrementItemQuality();
        }

        if (item.sellIn < 6) {
            incrementItemQuality();
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
