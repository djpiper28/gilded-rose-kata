package com.gildedrose;

public class ConjuredItem extends GildedItem {
    public ConjuredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }
}
