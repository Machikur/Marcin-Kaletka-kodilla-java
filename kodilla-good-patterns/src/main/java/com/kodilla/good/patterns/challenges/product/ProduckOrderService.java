package com.kodilla.good.patterns.challenges.product;

import com.kodilla.good.patterns.challenges.information.OrderInformationService;
import com.kodilla.good.patterns.challenges.orderresposytory.ProductRepository;
import com.kodilla.good.patterns.challenges.service.OrderProcessor;

public class ProduckOrderService {

    private final OrderInformationService orderInformationService;
    private final OrderProcessor orderProcessor;
    private final ProductRepository productRepository;

    public ProduckOrderService(final OrderInformationService orderInformationService,
                               final OrderProcessor orderProcessor,
                               final ProductRepository productRepository) {
        this.orderInformationService = orderInformationService;
        this.orderProcessor = orderProcessor;
        this.productRepository = productRepository;
    }

    public ProduktDto process(final OrderRequest orderRequest) {
        boolean isAvailible = orderProcessor.buy(orderRequest.getUser(), orderRequest.getItem());

        if (isAvailible) {
            orderInformationService.inform(orderRequest.getUser(), orderRequest.getItem());
            productRepository.createSale(orderRequest.getUser(), orderRequest.getItem());
            return new ProduktDto(orderRequest.getItem(), true);
        } else {
            return new ProduktDto(orderRequest.getItem(), false);
        }
    }

}