package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private String bun;
    private int burgers;
    private String sauce;
    private List<String> ingredients;




    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String toString(){
        String s;
        s="Bun: "+bun+"; with "+ burgers +" burgers; with sauce: "+ sauce+" and:";

        for(String tempIngredient: ingredients){
            s=s+"\n"+tempIngredient;
        }


        return s;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder{
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients=new ArrayList<>();
        private List<String> bunsList=new ArrayList<>();
        private List<String> saucesList=new ArrayList<>();
        private List<String> ingredientsList=new ArrayList<>();

        public final static String WITH_SESAME="with sesame";
        public final static String WITHOUT_SESAME="without sesame";

        public final static String STANDARD="standard";
        public final static String ISLANDS="1000 islands";
        public final static String BBQ="BBQ";

        public final static String LETTUCE="lettuce";
        public final static String ONION="onion";
        public final static String BECON="becon";
        public final static String CUCUMBER="cucumber";
        public final static String PEPPERS="peppers";
        public final static String CHILLI="chilli";
        public final static String MUSHROOMS="mushrooms";
        public final static String PRAWNS="prawns";
        public final static String CHEESE="cheese";


        public BigmacBuilder(){
            bunsList.add(WITH_SESAME);
            bunsList.add(WITHOUT_SESAME);

            saucesList.add(STANDARD);
            saucesList.add(ISLANDS);
            saucesList.add(BBQ);

            ingredientsList.add(LETTUCE);
            ingredientsList.add(ONION);
            ingredientsList.add(BECON);
            ingredientsList.add(CUCUMBER);
            ingredientsList.add(PEPPERS);
            ingredientsList.add(CHILLI);
            ingredientsList.add(MUSHROOMS);
            ingredientsList.add(PRAWNS);
            ingredientsList.add(CHEESE);
        }

        public BigmacBuilder bun(String bun) {
            if(bunsList.contains(bun)){
                this.bun = bun;
            }else{
                System.out.println("No "+bun+" in menu");
            }

            return this;
        }



        public List<String> getIngredients() {
            return ingredients;
        }

        public BigmacBuilder burgers(int burgers) {
            if((burgers>=0) && (burgers<=4)) {
                this.burgers = burgers;
            }else {
                System.out.println("you can choose from 0 to 4 burgers");
            }

            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if(saucesList.contains(sauce)){
                this.sauce = sauce;
            }else{
                System.out.println("No "+sauce+" in menu");
            }
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if(ingredientsList.contains(ingredient)) {
                ingredients.add(ingredient);
            }else{
                System.out.println("No "+ingredient+" in menu");
            }
            return this;
        }

        public Bigmac build(){
            return new Bigmac(bun,burgers,sauce,ingredients);
        }
    }

}
