package gildedrose

import "strings"

type Item struct {
	Name            string
	SellIn, Quality int
}

const (
	SULFURAS        = "Sulfuras, Hand of Ragnaros"
	AGED_BRIE       = "Aged Brie"
	BACKSTAGE_PASS  = "Backstage passes to a TAFKAL80ETC concert"
	CONJURED_PREFIX = "Conjured"
)

func (item *Item) incQuality() {
	if item.Quality < 50 {
		item.Quality++
	}
}

func (item *Item) decQuality() {
	if item.Quality > 0 {
		item.Quality--
	}
}

type ItemStrategy interface {
	itemUpdateStrategy()
}

func (item *Item) itemUpdateStrategy() {
	item.decQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.decQuality()
	}
}

type Sulfuras struct {
	*Item
}

func (item *Sulfuras) itemUpdateStrategy() {
	// Do nothing
}

type AgedBrie struct {
	*Item
}

func (item *AgedBrie) itemUpdateStrategy() {
	item.incQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.incQuality()
	}
}

type BackstagePass struct {
	*Item
}

func (item *BackstagePass) itemUpdateStrategy() {
	item.incQuality()
	if item.SellIn <= 10 {
		item.incQuality()
	}

	if item.SellIn <= 5 {
		item.incQuality()
	}
	item.SellIn--
	if item.SellIn < 0 {
		item.Quality = 0
	}
}

type ConjuredItem struct {
	*Item
}

func (item *ConjuredItem) itemUpdateStrategy() {
	item.decQuality()
	item.decQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.decQuality()
	}
}

func (item *Item) getItemStrategy() ItemStrategy {
	if item.Name == SULFURAS {
		return &Sulfuras{item}
	} else if item.Name == BACKSTAGE_PASS {
		return &BackstagePass{item}
	} else if item.Name == AGED_BRIE {
		return &AgedBrie{item}
	} else if strings.Contains(item.Name, CONJURED_PREFIX) {
		return &ConjuredItem{item}
	}
	return item
}
