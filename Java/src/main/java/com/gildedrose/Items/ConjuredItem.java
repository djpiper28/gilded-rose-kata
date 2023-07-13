package com.gildedrose.Items;

import com.gildedrose.Item;

public class ConjuredItem extends GildedItem {
    public ConjuredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }
}
