package store;

import java.io.IOException;
import store.Contoller.ConvenienceStore;
import store.Exception.InvalidInputFormatException;

public class Application {
    public static void main(String[] args) throws IOException, InvalidInputFormatException {
        ConvenienceStore store = new ConvenienceStore();
        store.run();
    }
}
