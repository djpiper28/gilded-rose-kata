package com.gildedrose.Items;

import com.gildedrose.Item;

public class GildedItem extends Item {
    public GildedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItemQuality() {
        updateItemsPreSellInDecrement();
        sellIn--;
        updateitemsPostSellInDecrement();
    }

    protected void updateItemsPreSellInDecrement() {
        decrementItemQuality();
    }

    public boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isConjured() {
        return name.contains("Conjured");
    }

    public boolean isBackStagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    protected void updateitemsPostSellInDecrement() {
        if (sellIn >= 0) {
            return;
        }

        decrementItemQuality();
    }

    protected void decrementItemQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    protected void incrementItemQuality() {
        if (quality < 50) {
            quality++;
        }
    }
}
