package gildedrose

import "strings"

func updateBackStagePassQualityPreSellInDec(item *Item) {
	if item.Name != BACKSTAGE_PASS {
		return
	}

	if item.Quality >= 50 {
		return
	}

	if item.SellIn < 11 {
		item.Quality++
	}
	if item.SellIn < 6 {
		item.Quality++
	}
}

func updateStandardItemQualityPreSellInDec(item *Item) {
	if item.Quality <= 0 {
		return
	}

	if item.Name != SULFURAS {
		item.Quality--
	}

	if strings.Contains(item.Name, CONJURED_PREFIX) && item.Quality > 0 {
		item.Quality--
	}
}

func updateItemQualityPreSellInDec(item *Item) {
	if item.Name != AGED_BRIE && item.Name != BACKSTAGE_PASS {
		updateStandardItemQualityPreSellInDec(item)
		return
	}

	if item.Quality < 50 {
		item.Quality++
		updateBackStagePassQualityPreSellInDec(item)
	}
}
