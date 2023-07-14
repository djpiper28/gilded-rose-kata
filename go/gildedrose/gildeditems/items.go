package gildeditems

import "strings"

type Item struct {
	Name            string
	SellIn, Quality int
}

const (
	SULFURAS        = "SulfurasItem, Hand of Ragnaros"
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
	Update()
}

func (item *Item) GetUpdateStrategy() ItemStrategy {
	if item.Name == SULFURAS {
		return &SulfurasItem{item}
	}

	if item.Name == BACKSTAGE_PASS {
		return &BackstagePassItem{item}
	}

	if item.Name == AGED_BRIE {
		return &AgedBrieItem{item}
	}

	if strings.Contains(item.Name, CONJURED_PREFIX) {
		return &ConjuredItem{item}
	}
	return &StandardItem{item}
}
