package gildeditems

type AgedBrie struct {
	*Item
}

func (item *AgedBrie) Update() {
	item.incQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.incQuality()
	}
}
