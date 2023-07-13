package com.gildedrose;

public class SulfurasItem extends GildedItem {
    public SulfurasItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void updateItemQuality() {

    }
}
