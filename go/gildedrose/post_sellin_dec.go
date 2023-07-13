package gildedrose

func (item *Item) updateBrieQualityPostSellInDec() {
	if item.Name != AGED_BRIE {
		return
	}

	item.incQuality()
}

func (item *Item) updateItemQualityPostSellInDec() {
	if item.SellIn >= 0 {
		return
	}

	if item.Name == AGED_BRIE {
		item.updateBrieQualityPostSellInDec()
	} else if item.Name == BACKSTAGE_PASS {
		item.Quality = 0
	} else {
		item.decQuality()
	}
}
