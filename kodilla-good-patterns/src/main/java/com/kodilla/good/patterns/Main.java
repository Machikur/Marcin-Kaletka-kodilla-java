package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.firsttask.MovieStore;
import com.kodilla.good.patterns.challenges.secondtask.information.TextOrderInformationService;
import com.kodilla.good.patterns.challenges.secondtask.orderresposytory.TextOrderRespository;
import com.kodilla.good.patterns.challenges.secondtask.product.OrderProductRequest;
import com.kodilla.good.patterns.challenges.secondtask.product.ProductOrderData;
import com.kodilla.good.patterns.challenges.secondtask.product.ProductOrderService;
import com.kodilla.good.patterns.challenges.secondtask.service.ProductOrderProcessor;
import com.kodilla.good.patterns.challenges.thirdtask.company.Company;
import com.kodilla.good.patterns.challenges.thirdtask.company.ExtraFoodShopCompany;
import com.kodilla.good.patterns.challenges.thirdtask.company.GlutenFreeShopCompany;
import com.kodilla.good.patterns.challenges.thirdtask.info.TextTransactionInfo;
import com.kodilla.good.patterns.challenges.thirdtask.order.OrderMenager;
import com.kodilla.good.patterns.challenges.thirdtask.order.OrderRequest;
import com.kodilla.good.patterns.challenges.thirdtask.product.Product;
import com.kodilla.good.patterns.challenges.thirdtask.product.ProductData;
import com.kodilla.good.patterns.challenges.thirdtask.product.Quality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

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
        OrderMenager orderMenager=new OrderMenager(new TextTransactionInfo());
        Product product=new Product("Maliny",Quality.MEDIUM);
        OrderRequest orderRequest=new OrderRequest(new ProductData(product,30),"ul. Szkolna 17");
        Company company1=new ExtraFoodShopCompany();
        Company company2=new GlutenFreeShopCompany();

        orderMenager.buySometihing(company1,orderRequest);
        orderMenager.buySometihing(company1,orderRequest);
        orderMenager.buySometihing(company1,orderRequest);
        orderMenager.buySometihing(company2,orderRequest);
    }
}
