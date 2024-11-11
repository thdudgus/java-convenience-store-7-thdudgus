package store.Exception;

public class NullInputException extends Throwable {
    public NullInputException(String inputNull) {
        super(inputNull);
    }
}
