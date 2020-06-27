package com.kodilla.good.patterns.challenges.secondtask.product;

import com.kodilla.good.patterns.challenges.secondtask.information.OrderInformationService;
import com.kodilla.good.patterns.challenges.secondtask.orderresposytory.ProductRepository;
import com.kodilla.good.patterns.challenges.secondtask.service.OrderProcessor;

public class ProductOrderService {

    private final OrderInformationService orderInformationService;
    private final OrderProcessor orderProcessor;
    private final ProductRepository productRepository;

    public ProductOrderService(final OrderInformationService orderInformationService,
                               final OrderProcessor orderProcessor,
                               final ProductRepository productRepository) {
        this.orderInformationService = orderInformationService;
        this.orderProcessor = orderProcessor;
        this.productRepository = productRepository;
    }

    public ProductOrderData process(final OrderProductRequest orderProductRequest) {
        boolean isAvailible = orderProcessor.buy(orderProductRequest.getUser(), orderProductRequest.getItem());

        if (isAvailible) {
            orderInformationService.inform(orderProductRequest.getUser(), orderProductRequest.getItem());
            productRepository.createSale(orderProductRequest.getUser(), orderProductRequest.getItem());
            return new ProductOrderData(orderProductRequest.getItem(), true);
        } else {
            return new ProductOrderData(orderProductRequest.getItem(), false);
        }
    }

}