package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void itemQualityShouldDegradeOverTime() {
        Item[] items = new Item[] { new Item("Shittake", 5, 5) };
        GildedRose app = new GildedRose(items);

        for (int i = 4; i >= 0; i--) {
            app.updateQuality();
            assertEquals(i, app.items[0].quality, "The item should have one less quality");
            assertEquals(i, app.items[0].sellIn, "The Item should have one less day on its date");
        }
    }

    @Test
    void itemQualityShouldDegradeAtDoubleSpeedAfterSellby() {
        Item[] items = new Item[] { new Item("Shittake", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(4, app.items[0].quality, "The item should have one less quality");
        assertEquals(-1, app.items[0].sellIn, "The Item should have one less day on its date");
    }

    @Test
    void itemsShouldNotGetNegativeQuality() {
        Item[] items = new Item[] { new Item("Shittake", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(0, app.items[0].quality, "The quality should always be zero or greater");
        assertEquals(4, app.items[0].sellIn, "Even with no quality left to remove the sellIn should decrement");
    }

    @Test
    void itemsShouldBeGetNegativeSellInValues() {
        Item[] items = new Item[] { new Item("Shittake", 0, 0) };
        GildedRose app = new GildedRose(items);

        for (int i = 1; i <= 10; i++) {
            app.updateQuality();
            assertEquals(0, app.items[0].quality, "(sanity check) Items should only have 0 quality here");
            assertEquals(-i, app.items[0].sellIn, "The Item should have one less day on its date");
        }
    }

    @Test
    void agedBrieShouldGetBetterBeforeAndAfterItsSellByPasses() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(2, app.items[0].quality, "The brie should not be getting any worse");
        assertEquals(1, app.items[0].sellIn, "(sanity check) time should have passed");

        app.updateQuality();
        assertEquals(0, app.items[0].sellIn, "The brie should now be at the sell by date now");
        assertEquals(3, app.items[0].quality, "The brie should have started to improve in quality");
    }

    @Test
    void agedBrieShouldImproveTwiceAsFastAfterItsSellBy() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn, "The brie should now be at the sell by date now");
        assertEquals(3, app.items[0].quality, "The brie should have started to improve in quality twice as fast now");
    }

    @Test
    void agedBrieShouldImproveTwiceAsFastAfterItsSellByToAMaxOf50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn, "The brie should now be at the sell by date now");
        assertEquals(50, app.items[0].quality, "The brie should have started to improve in quality twice as fast now");
    }

    @Test
    void agedBrieShouldGetBetterBeforeAndAfterItsSellByPassesButNotOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(1, app.items[0].sellIn, "(sanity check) time should have passed");
        assertEquals(50, app.items[0].quality, "The brie should not be getting any worse");

        app.updateQuality();
        assertEquals(0, app.items[0].sellIn, "The brie should now be at the sell by date now");
        assertEquals(50, app.items[0].quality, "The brie should have started to improve in quality");
    }

    @Test
    void sulfurasShouldBeLegendaryAndStayLegendary() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(80, app.items[0].quality, "Sulfuras should have a high and unchanging quality");
        assertEquals(2, app.items[0].sellIn, "Sulfuras should not get older");
    }

    @Test
    void backstagePassesOver11DaysOutShouldGetMoreQualityBy1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(2, app.items[0].quality, "The quality should have impproved by 1");
        assertEquals(10, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesOver11DaysOutShouldGetMoreQualityBy1ButNotMoreThan50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(50, app.items[0].quality, "The quality should have impproved by 1");
        assertEquals(10, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre10DaysOutShouldGetMoreQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(3, app.items[0].quality, "The quality should have impproved by 2");
        assertEquals(9, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre6DaysOutShouldGetMoreQualityBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(3, app.items[0].quality, "The quality should have impproved by 2");
        assertEquals(5, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre6DaysOutShouldGetMoreQualityBy2ButNotMoreThan50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(50, app.items[0].quality, "The quality should have impproved by 2");
        assertEquals(5, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre5DaysOutShouldGetMoreQualityBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(4, app.items[0].quality, "The quality should have impproved by 3");
        assertEquals(4, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre5DaysOutShouldGetMoreQualityBy3ButNotMoreThan50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(50, app.items[0].quality, "The quality should have impproved by 3");
        assertEquals(4, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatAre0DaysOutShouldHaveNoQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 32) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(0, app.items[0].quality, "The quality should have become zero");
        assertEquals(-1, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void backstagePassesThatHaveNegativeSellInDaysOutShouldHaveNoQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 32) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(0, app.items[0].quality, "The quality should have become zero");
        assertEquals(-2, app.items[0].sellIn, "(sanity check) the pass should be older");
    }

    @Test
    void conjuredItemsShouldDecayTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured dogbanana", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(3, app.items[0].quality, "The quality should have decreased by 2");
        assertEquals(9, app.items[0].sellIn, "(sanity check) time should have elapsed");
    }
}
