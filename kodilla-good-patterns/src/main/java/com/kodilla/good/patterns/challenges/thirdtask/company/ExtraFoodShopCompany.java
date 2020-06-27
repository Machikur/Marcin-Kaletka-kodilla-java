package com.kodilla.good.patterns.challenges.thirdtask.company;

import com.kodilla.good.patterns.challenges.thirdtask.product.Product;
import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;
import com.kodilla.good.patterns.challenges.thirdtask.product.Quality;

import java.util.HashMap;

public class ExtraFoodShopCompany implements Company {

    private final HashMap<Product,Integer> productsMap =new HashMap<>();

    public ExtraFoodShopCompany() {
        productsMap.put(new Product("Maliny", Quality.MEDIUM),50);
    }

    @Override
    public Integer process(ProductData productData) {
        Product tempProduct=productData.getProduct();
        int amountOfProductsLeft=productsMap.get(tempProduct);

        if (amountOfProductsLeft<productData.getAmount()){
            productsMap.put(tempProduct,0);
            sendCarToCustomer();
            return amountOfProductsLeft;

        }
        else{
            productsMap.put(tempProduct,amountOfProductsLeft-productData.getAmount());
            sendCarToCustomer();
            return productData.getAmount();
        }

    }

    @Override
    public boolean isAvailable(ProductData productData) {
        return productsMap.containsKey(productData.getProduct())&&productsMap.get(productData.getProduct())>0;
    }

    private void sendCarToCustomer(){
    }


}
