package store.View;

import camp.nextstep.edu.missionutils.Console;
import store.Exception.InvalidInputFormatException;
import store.Validation;

public class Input {
    Validation validation = new Validation();

    public String responsePurchase() throws InvalidInputFormatException {
        String input = Console.readLine();
        validation.order(input);
        return input;
    }
}
