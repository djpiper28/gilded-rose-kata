package gildedrose

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
