package gildedrose

func (item *Item) updateItem() {
	if item.Name == SULFURAS {
		return
	}

	item.updateItemQualityPreSellInDec()
	item.SellIn--
	item.updateItemQualityPostSellInDec()
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		items[i].updateItem()
	}
}
