package com.gildedrose;

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
        if (isBackStagePass()) {
            incrementItemQuality();

            if (isBackStagePass()) {
                updateBackstagePassPreSellInDecrement();
            }
        } else {
            if (isConjured()) {
                decrementItemQuality();
            }
            decrementItemQuality();
        }
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

    private void updateBackstagePassPreSellInDecrement() {
        if (sellIn < 11) {
            incrementItemQuality();
        }

        if (sellIn < 6) {
            incrementItemQuality();
        }
    }

    protected void updateitemsPostSellInDecrement() {
        if (sellIn >= 0) {
            return;
        }

        if (isBackStagePass()) {
            quality = 0;
        } else {
            decrementItemQuality();
        }
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
