package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public static class BigmacBulider {

        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigmacBulider setBun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBulider setBurgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBulider setSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBulider addIngredients(Ingredient... ingredient) {
            this.ingredients.addAll(Arrays.asList(ingredient));
            return this;
        }

        public Bigmac build() {
            if (bun == null || burgers == 0) {
                throw new IllegalArgumentException("No enough ingredients to make BigMac");
            } else {
                return new Bigmac(bun, burgers, sauce, ingredients);
            }
        }
    }
}
