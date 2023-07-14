package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItemFactory {
    public static GildedItem from(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new SulfurasItem(item);
        }

        if (item.name.contains("Conjured")) {
            return new ConjuredItem(item);
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return new BackstagePassItem(item);
        }

        if (item.name.equals("Aged Brie")) {
            return new AgedBrie(item);
        }

        return new GildedItem(item);
    }
}
