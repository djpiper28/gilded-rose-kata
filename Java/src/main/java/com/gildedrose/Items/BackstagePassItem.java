package com.gildedrose.Items;

import com.gildedrose.Item;

public class BackstagePassItem extends GildedItem {
    public BackstagePassItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    protected void updateItemsPreSellInDecrement() {
        incrementItemQuality();
        if (sellIn < 11) {
            incrementItemQuality();
        }

        if (sellIn < 6) {
            incrementItemQuality();
        }
    }

    @Override
    protected void updateitemsPostSellInDecrement() {
        if (sellIn >= 0) {
            return;
        }

        quality = 0;
    }
}
