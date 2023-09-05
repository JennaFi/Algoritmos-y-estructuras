package Exceptions.finalTask.model;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.exceptions.ProductNotFoundException;
import Exceptions.finalTask.exceptions.WrongNameException;
import Exceptions.finalTask.exceptions.ZeroPriceException;

public interface ProductShopUI {

    void addProduct(String product, double price) throws WrongNameException, ZeroPriceException;

    void deleteProduct(String name) throws ProductNotFoundException, WrongNameException, EmptyStoreException;

    String getProduct(String name) throws ProductNotFoundException, WrongNameException, EmptyStoreException;

    void getAllProducts() throws EmptyStoreException;

}