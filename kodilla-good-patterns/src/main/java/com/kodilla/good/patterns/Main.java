package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;
import com.kodilla.good.patterns.challenges.information.TextOrderInformationService;
import com.kodilla.good.patterns.challenges.orderresposytory.TextOrderlResposytory;
import com.kodilla.good.patterns.challenges.product.OrderRequest;
import com.kodilla.good.patterns.challenges.product.ProduckOrderService;
import com.kodilla.good.patterns.challenges.product.ProduktDto;
import com.kodilla.good.patterns.challenges.service.ProductOrderProcessor;

import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MovieStore movie = new MovieStore();
        String movieNames = movie.getMovies().values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));

        System.out.println(movieNames);


        ProduckOrderService produckOrderServic = new ProduckOrderService(
                new TextOrderInformationService(), new ProductOrderProcessor(), new TextOrderlResposytory());

        ProduktDto produktDto = produckOrderServic.process(new OrderRequest("Janek", "Kaszka"));
        System.out.println(produktDto.getStatus());
    }
}
