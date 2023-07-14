package gildeditems

type BackstagePassItem struct {
	*Item
}

func (item *BackstagePassItem) Update() {
	item.incQuality()
	if item.SellIn <= 10 {
		item.incQuality()
	}

	if item.SellIn <= 5 {
		item.incQuality()
	}
	item.SellIn--
	if item.SellIn < 0 {
		item.Quality = 0
	}
}
