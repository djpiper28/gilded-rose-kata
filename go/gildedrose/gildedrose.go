package gildedrose

func updateItem(item *Item) {
	if item.Name == SULFURAS {
		return
	}

	updateItemQualityPreSellInDec(item)
	item.SellIn--
	updateItemQualityPostSellInDec(item)
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		updateItem(items[i])
	}
}
