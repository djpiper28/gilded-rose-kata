package gildedrose

import "github.com/emilybache/gildedrose-refactoring-kata/gildedrose/gildeditems"

func UpdateQuality(items []*gildeditems.Item) {
	for _, item := range items {
		item.GetItemStrategy().Update()
	}
}
