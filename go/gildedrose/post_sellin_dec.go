package gildedrose

func (item *Item) updateItemQualityPostSellInDec() {
	if item.SellIn >= 0 {
		return
	}

	if item.Name == AGED_BRIE {
		item.incQuality()
	} else if item.Name == BACKSTAGE_PASS {
		item.Quality = 0
	} else {
		item.decQuality()
	}
}
