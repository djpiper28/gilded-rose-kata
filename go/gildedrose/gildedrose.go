package gildedrose

func (item *Item) updateItem() {
	item.getItemStrategy().itemUpdateStrategy()
}

func UpdateQuality(items []*Item) {
	for i := 0; i < len(items); i++ {
		items[i].updateItem()
	}
}
