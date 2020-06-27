package com.kodilla.good.patterns.challenges.thirdtask.company;

import com.kodilla.good.patterns.challenges.thirdtask.product.Product;
import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;

import java.util.HashMap;

public class HealthyShopCompany implements Company {

    private final HashMap<Product,Integer> productsMap =new HashMap<>();


    @Override
    public Integer process(ProductData productData) {
        Product tempProduct=productData.getProduct();
        int amountOfProductsLeft=productsMap.get(tempProduct);

        if (amountOfProductsLeft<productData.getAmount()){
            productsMap.put(tempProduct,0);
            callMagazine();
            return amountOfProductsLeft;

        }
        else{
            productsMap.put(tempProduct,amountOfProductsLeft-productData.getAmount());
            callMagazine();
            return productData.getAmount();
        }
    }

    @Override
    public boolean isAvailable(ProductData productData) {
        return productsMap.containsKey(productData.getProduct())&&productsMap.get(productData.getProduct())>0;
    }

    public void callMagazine(){
    }

}
