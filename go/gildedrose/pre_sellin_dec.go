package gildedrose

import "strings"

func (item *Item) updateBackStagePassQualityPreSellInDec() {
	if item.Name != BACKSTAGE_PASS {
		return
	}

	if item.SellIn <= 10 {
		item.incQuality()
	}

	if item.SellIn <= 5 {
		item.incQuality()
	}
}

func (item *Item) updateStandardItemQualityPreSellInDec() {
	if item.Name == BACKSTAGE_PASS || item.Name == AGED_BRIE {
		return
	}

	item.decQuality()
	if strings.Contains(item.Name, CONJURED_PREFIX) {
		item.decQuality()
	}
}

func (item *Item) updateItemQualityPreSellInDec() {
	if item.Name == BACKSTAGE_PASS {
		item.updateBackStagePassQualityPreSellInDec()
	}

	if item.Name != AGED_BRIE && item.Name != BACKSTAGE_PASS {
		item.updateStandardItemQualityPreSellInDec()
	} else {
		item.incQuality()
	}
}
