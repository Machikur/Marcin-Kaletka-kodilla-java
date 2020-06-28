package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.fourthtask.airport.FlyMenager;
import com.kodilla.good.patterns.challenges.fourthtask.data.FliesData;
import com.kodilla.good.patterns.challenges.fourthtask.information.TextInformation;

public class Main {
    public static void main(String[] args) {
        //1
//        MovieStore movie = new MovieStore();
//        String movieNames = movie.getMovies().values().stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.joining("!"));
//
//        System.out.println(movieNames);
//
//        //2
//        ProductOrderService produckOrderServic = new ProductOrderService(
//                new TextOrderInformationService(), new ProductOrderProcessor(), new TextOrderRespository());
//
//        ProductOrderData productOrderData = produckOrderServic.process(new OrderProductRequest("Janek", "Kaszka"));
//        System.out.println(productOrderData.getStatus());

        //3
//        OrderMenager orderMenager=new OrderMenager(new TextTransactionInfo());
//        Product product=new Product("Maliny",Quality.MEDIUM);
//        OrderRequest orderRequest=new OrderRequest(new ProductData(product,30),"ul. Szkolna 17");
//        Company company1=new ExtraFoodShopCompany();
//        Company company2=new GlutenFreeShopCompany();
//
//        orderMenager.buySometihing(company1,orderRequest);
//        orderMenager.buySometihing(company1,orderRequest);
//        orderMenager.buySometihing(company1,orderRequest);
//        orderMenager.buySometihing(company2,orderRequest);

        FlyMenager flyMenager = new FlyMenager(new FliesData(), new TextInformation());
        flyMenager.getConnecting("Londyn", "Warszawa");
        System.out.println();
        flyMenager.getFliesFrom("Warszawa");
        System.out.println();
        flyMenager.getFliesTo("Warszawa");
    }
}
