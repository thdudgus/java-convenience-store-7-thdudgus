package store.View;

import static store.Domain.ErrorMessages.invalidInput;

import camp.nextstep.edu.missionutils.Console;
import store.Exception.InvalidInputFormatException;
import store.Exception.InvalidInputException;
import store.Validation;

public class Input {
    Validation validation = new Validation();

    public String responsePurchase() throws InvalidInputFormatException, InvalidInputException {
        String input = Console.readLine();
        validation.order(input);
        return input;
    }

    public String getYesOrNo() throws InvalidInputException {
        String input = Console.readLine();
        validation.YN(input);
        return input;
    }

    public String additionalGet() throws InvalidInputException {
        String input = Console.readLine();
        validation.YN(input);
        return input;
    }

//    public boolean getYesOrNo() throws InvalidInputException {
//        String input = Console.readLine();
//        if (input.equals('Y')||input.equals('y')) {
//            return true;
//        } else if (input.equals('N')||input.equals('n')) {
//            return false;
//        }
//        throw new InvalidInputException(invalidInput);
//    }
}
