package gildedrose

type ConjuredItem struct {
	*Item
}

func (item *ConjuredItem) itemUpdateStrategy() {
	item.decQuality()
	item.decQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.decQuality()
		item.decQuality()
	}
}
