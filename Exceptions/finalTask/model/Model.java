package Exceptions.finalTask.model;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.exceptions.ProductNotFoundException;
import Exceptions.finalTask.exceptions.WrongNameException;
import Exceptions.finalTask.exceptions.ZeroPriceException;

public class Model {

    private final ProductShop shop;

    public Model() {
        this.shop = new ProductShop("7/11");
    }

    public void addProduct(String name, double price) throws WrongNameException, ZeroPriceException {
        shop.addProduct(name, price);
    }

    public void deleteProduct(String name) throws ProductNotFoundException, WrongNameException, EmptyStoreException {
        shop.deleteProduct(name);

    }

    public String getProduct(String name) throws WrongNameException, ProductNotFoundException, EmptyStoreException {
        return shop.getProduct(name);
    }

    public void getAllProducts() throws EmptyStoreException {
        shop.getAllProducts();
    }
}