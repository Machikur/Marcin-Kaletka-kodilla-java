package com.kodilla.good.patterns.challenges.thirdtask.company;

import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;

public interface Company {
    Integer process(ProductData productData);
    boolean isAvailable(ProductData productData);
}
