package store.Exception;

public class NonExistentProduct extends Throwable {
    public NonExistentProduct(String nonExistentProduct) {
        super(nonExistentProduct);
    }
}
