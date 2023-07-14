package gildeditems

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test_ItemIncBaseCase(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 5,
	}

	item.incQuality()
	assert.Equal(t, 6, item.Quality, "Inc should increase the quality")
}

func Test_ItemIncBoundryLower(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 49,
	}

	item.incQuality()
	assert.Equal(t, 50, item.Quality, "Inc should increase the quality to a max of 50")
}

func Test_ItemIncBoundryExact(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 50,
	}

	item.incQuality()
	assert.Equal(t, 50, item.Quality, "Inc should increase the quality to a max of 50")
}

func Test_ItemDecBaseCase(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 49,
	}

	item.decQuality()
	assert.Equal(t, 48, item.Quality, "Dec should decrease the quality")
}

func Test_TemDecBoundryUpper(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 1,
	}

	item.decQuality()
	assert.Equal(t, 0, item.Quality, "Dec should decrease the quality to a minimum of 0")
}

func Test_TemDecBoundryExact(t *testing.T) {
	item := Item{
		Name:    "Cheese",
		SellIn:  5,
		Quality: 0,
	}

	item.decQuality()
	assert.Equal(t, 0, item.Quality, "Dec should decrease the quality to a minimum of 0")
}
