package Exceptions.finalTask.presenter;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.exceptions.ProductNotFoundException;
import Exceptions.finalTask.exceptions.WrongNameException;
import Exceptions.finalTask.exceptions.ZeroPriceException;
import Exceptions.finalTask.model.Model;

public class Presenter {

    private Model model;

    public Presenter() {
        model = new Model();
    }

    public void addProduct(String name, double price) {
        try {
            model.addProduct(name, price);
        } catch (WrongNameException | ZeroPriceException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(String name) {
        try {
            model.deleteProduct(name);
        } catch (WrongNameException | ProductNotFoundException | EmptyStoreException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getProduct(String name) {
        try {
            return model.getProduct(name);
        } catch (ProductNotFoundException | WrongNameException | EmptyStoreException e) {
            return e.getMessage();
        }

    }

    public void getAllProducts() {
        try {
            model.getAllProducts();
        } catch (EmptyStoreException e) {
            System.out.println(e.getMessage());
        }
    }
}