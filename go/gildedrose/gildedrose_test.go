package gildedrose_test

import (
	"testing"

	"github.com/emilybache/gildedrose-refactoring-kata/gildedrose"
	"github.com/stretchr/testify/assert"
)

func Test_Foo(t *testing.T) {
	items := []*gildedrose.Item{
		{"foo", 0, 0},
	}

	gildedrose.UpdateQuality(items)

	assert.Equal(t, items[0].Name, "foo", "Name should remain the same after updating quality")
}

// Once the sell by date has passed, Quality degrades twice as fast
func Test_SellByDatePassed(t *testing.T) {
	const Q = 4
	items := []*gildedrose.Item{
		{Name: "Out of date item",
			SellIn:  0,
			Quality: Q},
	}

	gildedrose.UpdateQuality(items)

	assert.Equal(t, items[0].Quality, Q-2, "Quality should be havled when SellIn is 0")
}

// The Quality of an item is never negative
func Test_NegativeQualityOnTick(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Really rotten tomatoes",
			SellIn:  4,
			Quality: 0},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Items with zero quality should not tick down to negative values")
}

func Test_NegativeQualityOnDoubleTick(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Out of date item",
			SellIn:  0,
			Quality: 0},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Items with zero quality and no sell by date should still not tick down to negative values")
}

// "Aged Brie" actually increases in Quality the older it gets
func Test_BrieQualityGetsOlder(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Aged Brie",
			SellIn:  0,
			Quality: 0},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 2, items[0].Quality, "Aged Brie should get better as it gets older")
}

// The Quality of an item is never more than 50
func Test_BrieQualityCapsOutAt50(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Aged Brie",
			SellIn:  0,
			Quality: 50},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 50, items[0].Quality, "Aged Brie should get better as it gets older until it has 50 quality")
}

// "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
func Test_SulfuransQualityStaysAt80(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Sulfuras, Hand of Ragnaros",
			SellIn:  10,
			Quality: 80},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 80, items[0].Quality, "Sulfuras should have a quality of 80 always")
	assert.Equal(t, 10, items[0].SellIn, "sellin should not change for Sulfuras")
}

// "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
//	Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
//	Quality drops to 0 after the concert
func Test_BackstagePassQualityIncreasesFarOut(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  180,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 21, items[0].Quality, "Backstage passes that are over 10 days out should get older at rate 1")
	assert.Equal(t, 179, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases10Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  10,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 22, items[0].Quality, "Backstage passes that are 10 days out should get older at rate 2")
	assert.Equal(t, 9, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases9Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  9,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 22, items[0].Quality, "Backstage passes that are 9 days out should get older at rate 2")
	assert.Equal(t, 8, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases5Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  5,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 23, items[0].Quality, "Backstage passes that are 5 days out should get older at rate 3")
	assert.Equal(t, 4, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases4Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  4,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 23, items[0].Quality, "Backstage passes that are 4 days out should get older at rate 3")
	assert.Equal(t, 3, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases1Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  1,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 23, items[0].Quality, "Backstage passes that are 1 days out should get older at rate 3")
	assert.Equal(t, 0, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreases0Days(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  0,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Backstage passes should have no quality after the conert")
	assert.Equal(t, -1, items[0].SellIn, "Backstage should have their sellin decrease")
}

func Test_BackstagePassQualityIncreasesAfterConcertDays(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  -1,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Backstage passes should have no quality after the conert")
}

func Test_MultipleItems(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  -1,
			Quality: 20},
		{Name: "Sulfuras, Hand of Ragnaros",
			SellIn:  10,
			Quality: 80},
		{Name: "Aged Brie",
			SellIn:  1,
			Quality: 50},
		{Name: "Fresh Hashish",
			SellIn:  123,
			Quality: 123},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Backstage passes should have no quality after the conert")

	assert.Equal(t, 80, items[1].Quality, "Sulfuras should have a quality of 80 always")
	assert.Equal(t, 10, items[1].SellIn, "sellin should not change for Sulfuras")

	assert.Equal(t, 50, items[2].Quality, "Aged Brie should get better as it gets older until it has 50 quality")
	assert.Equal(t, 0, items[2].SellIn, "Aged Brie should have sellin tick down")

	assert.Equal(t, 122, items[3].Quality, "normal items should have quality tick down")
	assert.Equal(t, 122, items[3].SellIn, "normal items should have sellin tick down")
}

// We have recently signed a supplier of conjured items. This requires an update to our system:
// 	- "Conjured" items degrade in Quality twice as fast as normal items
func Test_ConjureItemDecay(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Conjured Anchovies",
			SellIn:  9,
			Quality: 20},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 18, items[0].Quality, "Conjured items should decay twice as fast")
	assert.Equal(t, 8, items[0].SellIn, "Conjure items should get older")
}

func Test_ConjureItemDecayCanDecayToZero(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Conjured Anchovies",
			SellIn:  9,
			Quality: 2},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Conjured items should note have negative quality")
	assert.Equal(t, 8, items[0].SellIn, "Conjure items should get older")
}

func Test_ConjureItemDecayCannotGoBelowZero(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Conjured Anchovies",
			SellIn:  9,
			Quality: 0},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Conjured items should note have negative quality")
	assert.Equal(t, 8, items[0].SellIn, "Conjure items should get older")
}

func Test_ConjureItemDecayCannotGoBelowZeroEdgeCase(t *testing.T) {
	items := []*gildedrose.Item{
		{Name: "Conjured Anchovies",
			SellIn:  9,
			Quality: 1},
	}

	gildedrose.UpdateQuality(items)
	assert.Equal(t, 0, items[0].Quality, "Conjured items should note have negative quality")
	assert.Equal(t, 8, items[0].SellIn, "Conjure items should get older")
}

func Test_ManyTicks(t *testing.T) {
	const BASE = 100
	items := []*gildedrose.Item{
		{Name: "Backstage passes to a TAFKAL80ETC concert",
			SellIn:  BASE,
			Quality: 20},
		{Name: "Sulfuras, Hand of Ragnaros",
			SellIn:  BASE,
			Quality: 80},
		{Name: "Aged Brie",
			SellIn:  BASE,
			Quality: 50},
		{Name: "Fresh Hashish",
			SellIn:  BASE,
			Quality: 123},
	}

	for i := 0; i < 12000; i++ {
		gildedrose.UpdateQuality(items)
		for _, item := range items {
			if item.Name != gildedrose.SULFURAS {
				assert.Equal(t, BASE-i-1, item.SellIn, "All items should have sellin decrement")
			} else {
				assert.Equal(t, BASE, item.SellIn, "Sulfuras should not have SellIn decrement")
			}
		}
	}

	assert.Equal(t, 0, items[0].Quality, "Backstage passes should have no quality after the conert")
	assert.Equal(t, 80, items[1].Quality, "Sulfuras should have a quality of 80 always")
	assert.Equal(t, 50, items[2].Quality, "Aged Brie should get better as it gets older until it has 50 quality")
	assert.Equal(t, 0, items[3].Quality, "normal items should have sellin tick down")
}
