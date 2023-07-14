package com.gildedrose.Items;

import com.gildedrose.Item;

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
