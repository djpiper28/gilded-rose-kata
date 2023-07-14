package gildeditems

type AgedBrieItem struct {
	*Item
}

func (item *AgedBrieItem) Update() {
	item.incQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.incQuality()
	}
}
