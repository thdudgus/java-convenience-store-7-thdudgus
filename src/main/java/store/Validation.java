package store;

import static store.Constants.PurchaseFormat;
import static store.ErrorMessages.inputFormatError;
import static store.ErrorMessages.inputNull;

import store.Exception.InvalidInputFormatException;
import store.Exception.NullInputException;

public class Validation {
    public void order(String input) throws InvalidInputFormatException, NullInputException {
        if (input == null || input.isEmpty()) {
            throw new NullInputException(inputNull);
        }
        if (!input.matches(PurchaseFormat)) {
            throw new InvalidInputFormatException(inputFormatError);
        }
    }
}
