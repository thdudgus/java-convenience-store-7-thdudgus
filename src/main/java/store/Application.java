package store;

import java.io.IOException;
import store.Contoller.ConvenienceStore;
import store.Exception.InvalidInputException;
import store.Exception.InvalidInputFormatException;
import store.Exception.NonExistentProduct;

public class Application {
    public static void main(String[] args)
            throws IOException, InvalidInputFormatException, NonExistentProduct, InvalidInputException {
        ConvenienceStore store = new ConvenienceStore();
        store.run();
    }
}
