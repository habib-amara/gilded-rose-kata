package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalProductWithQualityEqualToZero() {
        Item[] items = new Item[] { new Item("P1", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalProductWithQualityGreaterThanZero() {
        Item[] items = new Item[] { new Item("P1", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void normalProductWithSelInLessThanZero() {
        Item[] items = new Item[] { new Item("P1", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void normalProductWithSelInLessThanZeroAndQualityShouldNotBeNegative() {
        Item[] items = new Item[] { new Item("P1", -1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrieProduct() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void agedBrieProductWithQualityGreaterThanFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfurasProduct() {
        Item[] items = new Item[] { new Item("Sulfuras", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInGreaterThanTen() {
        Item[] items = new Item[] { new Item("Backstage passes", 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInEqualToTen() {
        Item[] items = new Item[] { new Item("Backstage passes", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInLessThanTenAndGreaterThanFive() {
        Item[] items = new Item[] { new Item("Backstage passes", 8, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInEqualToFive() {
        Item[] items = new Item[] { new Item("Backstage passes", 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInLessThanFiveAndGreaterThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes", 4, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void backstagePassesProductWithSelInLessThanZero() {
        Item[] items = new Item[] { new Item("Backstage passes", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredProductWithQualityEqualToZero() {
        Item[] items = new Item[] { new Item("Conjured", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredProductWithQualityGreaterThanZero() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void conjuredProductWithQualityGreaterThanFifty() {
        Item[] items = new Item[] { new Item("Conjured", 5, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(55, app.items[0].quality);
    }
}
