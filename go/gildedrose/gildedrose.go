package gildedrose

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
