package gildedrose

func updateBrieQualityPostSellInDec(item *Item) {
	if item.Quality < 50 {
		item.Quality++
	}
}

func updateItemQualityPostSellInDec(item *Item) {
	if item.SellIn >= 0 {
		return
	}

	if item.Name == SULFURAS {
		return
	}

	if item.Name == AGED_BRIE {
		updateBrieQualityPostSellInDec(item)
	} else if item.Name == BACKSTAGE_PASS {
		item.Quality = 0
	} else if item.Quality > 0 {
		item.Quality--
	}
}
