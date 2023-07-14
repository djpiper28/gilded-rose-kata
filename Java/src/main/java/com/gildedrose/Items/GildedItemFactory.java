package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItemFactory {
    public static GildedItem from(Item item) {
        GildedItem temp = new GildedItem(item.name, item.sellIn, item.quality);

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

        return temp;
    }
}
