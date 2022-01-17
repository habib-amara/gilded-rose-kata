package com.gildedrose;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("Habib!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir", 5, 7), //
                new Item("Sulfuras", 0, 80), //
                new Item("Sulfuras", -1, 80),
                new Item("Backstage passes", 15, 20),
                new Item("Backstage passes", 10, 49),
                new Item("Backstage passes", 5, 49),
                new Item("Conjured", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
