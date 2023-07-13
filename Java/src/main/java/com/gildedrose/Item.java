package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateItemQuality() {
        if (name.equals("Sulfuras, Hand of Ragnaros")) return;

        updateItemsPreSellInDecrement();
        sellIn--;
        updateitemsPostSellInDecrement();
    }

    private void updateItemsPreSellInDecrement() {
        if (isAgedBrie()
            || isBackStagePass()) {
            incrementItemQuality();

            if (isBackStagePass()) {
                updateBackstagePassPreSellInDecrement();
            }
        } else {
            if (name.contains("Conjured")) {
                decrementItemQuality();
            }
            decrementItemQuality();
        }
    }

    private boolean isBackStagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
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

    private void updateitemsPostSellInDecrement() {
        if (sellIn >= 0) {
            return;
        }

        if (isAgedBrie()) {
            incrementItemQuality();
        } else {
            if (isBackStagePass()) {
                quality = 0;
            } else {
                decrementItemQuality();
            }
        }
    }

    private void decrementItemQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    private void incrementItemQuality() {
        if (quality < 50) {
            quality++;
        }
    }
}
