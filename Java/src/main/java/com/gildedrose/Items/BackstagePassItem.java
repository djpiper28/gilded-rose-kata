package com.gildedrose.Items;

import com.gildedrose.Item;

public class BackstagePassItem extends GildedItem {
    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    protected void updateItemsPreSellInDecrement() {
        incrementItemQuality();
        if (item.sellIn < 11) {
            incrementItemQuality();
        }

        if (item.sellIn < 6) {
            incrementItemQuality();
        }
    }

    @Override
    protected void updateitemsPostSellInDecrement() {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
