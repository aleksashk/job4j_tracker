package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStandard() - product.getActual() >= 0)
                .filter(product -> product.getStandard() - product.getActual() < 4)
                .map(product -> new Label(product.getName(), product.getPrice() / 2).toString())
                .toList();
    }
}
