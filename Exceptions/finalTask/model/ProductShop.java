package Exceptions.finalTask.model;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.exceptions.ProductNotFoundException;
import Exceptions.finalTask.exceptions.WrongNameException;
import Exceptions.finalTask.exceptions.ZeroPriceException;

import java.util.ArrayList;
import java.util.List;

public class ProductShop implements ProductShopUI {

    private String name;

    private final List<Product> products;


    public ProductShop(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price) throws WrongNameException, ZeroPriceException {
        if (name == null || name.isEmpty()) throw new WrongNameException("Введите верное наименование!");
        if (price == 0) throw new ZeroPriceException("Цена товара не может быть нулевой!");
        products.add(new Product(name, price));
    }

    public void deleteProduct(String name) throws EmptyStoreException, ProductNotFoundException, WrongNameException {
        if (products.size() == 0) throw new EmptyStoreException("Склад пуст!");
        if (name == null || name.isEmpty()) throw new WrongNameException("Введите верное наименование!");
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
            } else throw new ProductNotFoundException("Такого товара нет в наличии!");
        }


    }

    public String getProduct(String name) throws EmptyStoreException, ProductNotFoundException, WrongNameException {
        if (products.size() == 0) throw new EmptyStoreException("Склад пуст!");
        if (name == null || name.isEmpty()) throw new WrongNameException("Введите верное наименование!");
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product.toString();
            }
        }
        throw new ProductNotFoundException("Такого товара нет в наличии!");
    }

    public void getAllProducts() throws EmptyStoreException {
        if (products.size() == 0) throw new EmptyStoreException("Склад пуст!");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}