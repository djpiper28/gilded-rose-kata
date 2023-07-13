package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) updateItemQuality(i);
    }

    private void updateItemQuality(int i) {
        if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) return;

        updateItemsPreSellInDecrement(i);
        items[i].sellIn--;
        updateitemsPostSellInDecrement(i);
    }

    private void updateItemsPreSellInDecrement(int i) {
        if (isAgedBrie(i)
            || isBackStagePass(i)) {
            incrementItemQuality(i);

            if (isBackStagePass(i)) {
                updateBackstagePassPreSellInDecrement(i);
            }
        } else {
            if (items[i].name.contains("Conjured")) {
                decrementItemQuality(i);
            }
            decrementItemQuality(i);
        }
    }

    private boolean isBackStagePass(int i) {
        return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(int i) {
        return items[i].name.equals("Aged Brie");
    }

    private void updateBackstagePassPreSellInDecrement(int i) {
        if (items[i].sellIn < 11) {
            incrementItemQuality(i);
        }

        if (items[i].sellIn < 6) {
            incrementItemQuality(i);
        }
    }

    private void updateitemsPostSellInDecrement(int i) {
        if (items[i].sellIn >= 0) {
            return;
        }

        if (isAgedBrie(i)) {
            incrementItemQuality(i);
        } else {
            if (isBackStagePass(i)) {
                items[i].quality = 0;
            } else {
                decrementItemQuality(i);
            }
        }
    }

    private void decrementItemQuality(int i) {
        if (items[i].quality > 0) {
            items[i].quality--;
        }
    }

    private void incrementItemQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality++;
        }
    }
}
