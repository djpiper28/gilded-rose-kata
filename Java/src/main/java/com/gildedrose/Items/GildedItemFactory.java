package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItemFactory {
    public static GildedItem from(Item item) {
        GildedItem temp = new GildedItem(item.name, item.sellIn, item.quality);

        if (temp.isSulfuras()) {
            return new SulfurasItem(item);
        }

        if (temp.isConjured()) {
            return new ConjuredItem(item);
        }

        if (temp.isBackStagePass()) {
            return new BackstagePassItem(item);
        }

        if (temp.isAgedBrie()) {
            return new AgedBrie(item);
        }

        return temp;
    }
}
