package com.gildedrose;

class GildedRose {

    private final static String AGED_BRIE = "Aged Brie";
    private final static String BACKSTAGE_PASSES = "Backstage passes";
    private final static String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.quality <= 50 && item.quality > 0) {
                if (AGED_BRIE.equalsIgnoreCase(item.name) || BACKSTAGE_PASSES.equalsIgnoreCase(item.name)) {
                    qualityUp(item);
                    if (BACKSTAGE_PASSES.equalsIgnoreCase(item.name)) {
                        if (item.sellIn < 0) {
                            item.quality = 0;
                        } else {
                            if (item.sellIn <= 10) {
                                qualityUp(item);
                            }
                            if (item.sellIn <= 5) {
                                qualityUp(item);
                            }
                        }
                    }
                } else {
                    qualityDown(item);
                    if (item.sellIn < 0) {
                        qualityDown(item);
                    }
                    if (CONJURED.equalsIgnoreCase(item.name)) {
                        qualityDown(item);
                        if (item.sellIn < 0) {
                            qualityDown(item);
                        }
                    }
                }
            }
            item.sellIn--;
        }

    }

    private void qualityUp(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void qualityDown(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

}
