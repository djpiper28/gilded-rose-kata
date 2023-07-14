package gildeditems

type ConjuredItem struct {
	*Item
}

func (item *ConjuredItem) DoItemUpdate() {
	item.decQuality()
	item.decQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.decQuality()
		item.decQuality()
	}
}
