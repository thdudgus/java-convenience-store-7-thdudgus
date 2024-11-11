package store.Exception;

public class InvalidInputException extends Throwable {
    public InvalidInputException(String inputNull) {
        super(inputNull);
    }
}
