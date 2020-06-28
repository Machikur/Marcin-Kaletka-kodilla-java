package com.kodilla.good.patterns.challenges.thirdtask.order;

import com.kodilla.good.patterns.challenges.thirdtask.company.Company;
import com.kodilla.good.patterns.challenges.thirdtask.info.Information;
import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;

public class OrderMenager {

    private final Information information;

    public OrderMenager(Information information) {
        this.information = information;
    }

    public void buySometihing(Company company, OrderRequest orderRequest) {
        ProductData productData = orderRequest.getProductData();
        String localization = orderRequest.getDeliveryPoint();
        if (company.isAvailable(productData)) {
            int amount = company.process(orderRequest.getProductData());
            System.out.println(information.getTransactionInfo(orderRequest.getDeliveryPoint(), true, amount));
        } else {
            System.out.println(information.getTransactionInfo(localization, false, 0));
        }
    }

}
