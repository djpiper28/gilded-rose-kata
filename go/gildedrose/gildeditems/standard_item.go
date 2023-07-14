package gildeditems

type StandardItem struct {
	*Item
}

func (item *StandardItem) Update() {
	item.decQuality()
	item.SellIn--
	if item.SellIn < 0 {
		item.decQuality()
	}
}
