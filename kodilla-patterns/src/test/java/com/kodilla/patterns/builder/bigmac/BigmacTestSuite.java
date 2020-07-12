package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigmacBulider(){
        //given
        Bigmac bigmac= new Bigmac.BigmacBulider()
                .setBun(Bun.SESAME)
                .setBurgers(2)
                .setSauce(Sauce.BARBECUE_SAUCE)
                .addIngredients(Ingredient.BECON,Ingredient.CHEESE,Ingredient.MUSHROOMS)
                .build();
        //when&then
        Assert.assertEquals(Bun.SESAME,bigmac.getBun());
        Assert.assertEquals(2,bigmac.getBurgers());
        Assert.assertEquals(Sauce.BARBECUE_SAUCE,bigmac.getSauce());
        Assert.assertEquals(3,bigmac.getIngredients().size());
    }
    @Test
    public void noEnoughIngredientsTest(){
        Bigmac bigmac=null;
        //given
        try {
            bigmac = new Bigmac.BigmacBulider()
                    .setBun(Bun.SESAME)
                    .build();
        }
        catch (IllegalArgumentException s){
        }

        //when&&then
        Assert.assertNull(bigmac);

    }
}
