package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItemFactory {
    public static GildedItem from(Item item) {
        GildedItem temp = new GildedItem(item.name, item.sellIn, item.quality);

        if (isSulfuras(item.name)) {
            return new SulfurasItem(item);
        }

        if (isConjured(item.name)) {
            return new ConjuredItem(item);
        }

        if (isBackStagePass(item.name)) {
            return new BackstagePassItem(item);
        }

        if (isAgedBrie(item.name)) {
            return new AgedBrie(item);
        }

        return temp;
    }

    private static boolean isSulfuras(final String name) {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isConjured(final String name) {
        return name.contains("Conjured");
    }

    private static boolean isBackStagePass(final String name) {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(final String name) {
        return name.equals("Aged Brie");
    }
}
