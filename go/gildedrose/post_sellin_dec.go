package gildedrose

func updateBrieQualityPostSellInDec(item *Item) {
	if item.Quality < 50 {
		item.Quality += 1
	}
}

func updateItemQualityPostSellInDec(item *Item) {
	if item.SellIn >= 0 {
		return
	}

	if item.Name == AGED_BRIE {
		updateBrieQualityPostSellInDec(item)
		return
	}

	if item.Name == BACKSTAGE_PASS {
		item.Quality = 0
		return
	}

	if item.Quality > 0 {
		if item.Name != SULFURAS {
			item.Quality -= 1
		}
	}
}
