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
        items[i].sellIn = items[i].sellIn - 1;
        updateitemsPostSellInDecrement(i);
    }

    private void updateItemsPreSellInDecrement(int i) {
        if (items[i].name.equals("Aged Brie")
            || items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    updateBackstagePassPreSellInDecrement(i);
                }
            }
        } else {
            if (items[i].quality > 0) {
                items[i].quality = items[i].quality - 1;
            }
        }
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
        if (items[i].sellIn < 0) {
            if (items[i].name.equals("Aged Brie")) {
                incrementItemQuality(i);
            } else {
                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].quality = 0;
                } else {
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            }
        }
    }

    private void incrementItemQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }
}
