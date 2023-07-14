package gildedrose

import "github.com/emilybache/gildedrose-refactoring-kata/gildedrose/gildeditems"

func updateItem(item *gildeditems.Item) {
	item.GetItemStrategy().DoItemUpdate()
}

func UpdateQuality(items []*gildeditems.Item) {
	for i := 0; i < len(items); i++ {
		updateItem(items[i])
	}
}
