package Exceptions.finalTask.viewer;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.presenter.Presenter;

import java.util.Scanner;

public class UserGUI {


    private Presenter presenter;

    private Scanner scanner;


    public UserGUI() {
        presenter = new Presenter();
        scanner = new Scanner(System.in);
    }

    public void show() throws EmptyStoreException {
        while (true) {
            System.out.println(Menu.MENU);
            System.out.print(Messages.CHOICE);
            String choice = scanner.next();
            switch (choice) {
                case "1" -> {
                    System.out.print(Messages.NAMEPRODUCT);
                    presenter.getProduct(scanner.next());
                }
                case "2" -> {
                    System.out.print(Messages.NAMEPRODUCT);
                    String product = scanner.next();
                    System.out.print(Messages.PRICEPRODUCT);
                    double price = scanner.nextDouble();
                    presenter.addProduct(product, price);
                    System.out.println(Messages.SUCCESS);
                }
                case "3" -> {
                    System.out.print(Messages.NAMEPRODUCT);
                    presenter.deleteProduct(scanner.next());
                }
                case "4" -> presenter.getAllProducts();
                case "5" -> {
                    System.out.print(Messages.NAMEPRODUCT);
                    System.out.print(presenter.getProduct(scanner.next()));
                }
                case "6" -> {
                    scanner.close();
                    return;
                }
            }
        }
    }
}