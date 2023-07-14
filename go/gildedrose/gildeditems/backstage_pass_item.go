package gildeditems

type BackstagePass struct {
	*Item
}

func (item *BackstagePass) DoItemUpdate() {
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
