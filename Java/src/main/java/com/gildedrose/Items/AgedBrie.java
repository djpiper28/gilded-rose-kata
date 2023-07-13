package com.gildedrose.Items;

import com.gildedrose.Item;

public class AgedBrie extends GildedItem {
    public AgedBrie(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    protected void updateItemsPreSellInDecrement() {
        incrementItemQuality();
    }

    @Override
    protected void updateitemsPostSellInDecrement() {
        if (sellIn >= 0) {
            return;
        }

        incrementItemQuality();
    }
}
