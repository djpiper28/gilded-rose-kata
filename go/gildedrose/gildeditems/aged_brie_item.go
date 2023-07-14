package gildeditems

type AgedBrie struct {
	*Item
}

func (item *AgedBrie) DoItemUpdate() {
	item.incQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.incQuality()
	}
}
