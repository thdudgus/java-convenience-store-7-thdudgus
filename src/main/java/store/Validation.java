package store;

import static store.Constants.PurchaseFormat;
import static store.ErrorMessages.inputFormatEror;

import store.Exception.InvalidInputFormatException;

public class Validation{
    public void order(String input) throws InvalidInputFormatException {
        if (!input.matches(PurchaseFormat)) {
            throw new InvalidInputFormatException(inputFormatEror);
        }
    }
}
