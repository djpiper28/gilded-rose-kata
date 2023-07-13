package gildedrose

func updateBackStagePassQuality(item *Item) {
	if item.Name != BACKSTAGE_PASS {
		return
	}

	if item.SellIn < 11 {
		if item.Quality < 50 {
			item.Quality = item.Quality + 1
		}
	}
	if item.SellIn < 6 {
		if item.Quality < 50 {
			item.Quality = item.Quality + 1
		}
	}
}

func updateItemQualityPreSellInDec(item *Item) {
	if item.Name != AGED_BRIE && item.Name != BACKSTAGE_PASS {
		if item.Quality > 0 {
			if item.Name != SULFURAS {
				item.Quality = item.Quality - 1
			}
		}
	} else {
		if item.Quality < 50 {
			item.Quality = item.Quality + 1
			updateBackStagePassQuality(item)
		}
	}
}

func updateBrieQualityPostSellInDec(item *Item) {
	if item.Quality < 50 {
		item.Quality = item.Quality + 1
	}
}

func updateItemQualityPostSellInDec(item *Item) {
	if item.SellIn >= 0 {
		return
	}

	if item.Name != AGED_BRIE {
		if item.Name != BACKSTAGE_PASS {
			if item.Quality > 0 {
				if item.Name != SULFURAS {
					item.Quality = item.Quality - 1
				}
			}
		} else {
			item.Quality = item.Quality - item.Quality
		}
	} else {
		updateBrieQualityPostSellInDec(item)
	}
}

func updateItem(item *Item) {
	updateItemQualityPreSellInDec(item)

	if item.Name != SULFURAS {
		item.SellIn = item.SellIn - 1
	}

	updateItemQualityPostSellInDec(item)
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		updateItem(items[i])
	}
}
