package com.gildedrose.Items;

import com.gildedrose.Item;

public class AgedBrie extends GildedItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateItemsPreSellInDecrement() {
        incrementItemQuality();
    }

    @Override
    protected void updateitemsPostSellInDecrement() {
        if (item.sellIn < 0) {
            incrementItemQuality();
        }
    }
}
