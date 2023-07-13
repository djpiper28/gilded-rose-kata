package gildedrose

func updateItem(item *Item) {
	updateItemQualityPreSellInDec(item)

	if item.Name != SULFURAS {
		item.SellIn--
	}

	updateItemQualityPostSellInDec(item)
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		updateItem(items[i])
	}
}
