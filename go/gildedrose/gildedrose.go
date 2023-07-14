package gildedrose

import "github.com/emilybache/gildedrose-refactoring-kata/gildedrose/gildeditems"

func updateItem(item *gildeditems.Item) {
	item.GetItemStrategy().DoItemUpdate()
}

func UpdateQuality(items []*gildeditems.Item) {
	for _, item := range items {
		updateItem(item)
	}
}
