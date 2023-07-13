package gildedrose

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
