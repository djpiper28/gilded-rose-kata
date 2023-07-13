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

func upateItemQuality(item *Item) {
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

	if item.Name != SULFURAS {
		item.SellIn = item.SellIn - 1
	}

	if item.SellIn < 0 {
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
			if item.Quality < 50 {
				item.Quality = item.Quality + 1
			}
		}
	}
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		upateItemQuality(items[i])
	}
}
