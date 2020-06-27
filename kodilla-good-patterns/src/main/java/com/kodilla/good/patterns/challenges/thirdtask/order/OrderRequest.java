package com.kodilla.good.patterns.challenges.thirdtask.order;

import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;

public class OrderRequest {
    private ProductData productData;
    private String deliveryPoint;

    public OrderRequest(ProductData productData, String deliveryPoint) {
        this.productData = productData;
        this.deliveryPoint = deliveryPoint;
    }

    public ProductData getProductData() {
        return productData;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }
}
