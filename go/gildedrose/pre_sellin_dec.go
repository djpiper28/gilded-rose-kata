package gildedrose

import "strings"

func (item *Item) updateBackStagePassQualityPreSellInDec() {
	if item.Name != BACKSTAGE_PASS {
		return
	}

	if item.Quality >= 50 {
		return
	}

	if item.SellIn <= 10 {
		item.Quality++
	}

	if item.SellIn <= 5 {
		item.Quality++
	}
}

func (item *Item) updateStandardItemQualityPreSellInDec() {
	if item.Name == BACKSTAGE_PASS || item.Name == AGED_BRIE {
		return
	}

	if item.Quality <= 0 {
		return
	}

	item.Quality--
	if strings.Contains(item.Name, CONJURED_PREFIX) && item.Quality > 0 {
		item.Quality--
	}
}

func (item *Item) updateItemQualityPreSellInDec() {
	if item.Name == BACKSTAGE_PASS {
		item.updateBackStagePassQualityPreSellInDec()
	}

	if item.Name != AGED_BRIE && item.Name != BACKSTAGE_PASS {
		item.updateStandardItemQualityPreSellInDec()
	} else if item.Quality < 50 {
		item.Quality++
	}
}
