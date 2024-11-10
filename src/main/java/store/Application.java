package store;

import java.io.IOException;
import store.Contoller.ConvenienceStore;

public class Application {
    public static void main(String[] args) throws IOException {
        ConvenienceStore store = new ConvenienceStore();
        store.openFile();
    }
}
