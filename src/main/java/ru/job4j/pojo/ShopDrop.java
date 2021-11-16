package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i <products.length - 1; i++) {
            Product tmp = products[i];
            products[i] = products[i + 1];
            products[i + 1] = tmp;
        }
        return products;
    }
}
