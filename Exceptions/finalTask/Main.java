package Exceptions.finalTask;

import Exceptions.finalTask.exceptions.EmptyStoreException;
import Exceptions.finalTask.exceptions.ProductNotFoundException;
import Exceptions.finalTask.viewer.UserGUI;

public class Main {

    public static void main(String[] args) throws ProductNotFoundException, EmptyStoreException {
        UserGUI gui = new UserGUI();
        gui.show();
    }


}