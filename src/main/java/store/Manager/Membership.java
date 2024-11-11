package store.Manager;

import store.Exception.InvalidInputException;
import store.Manager.ProductPurchaseManager.ProductPurchase;
import store.View.Input;
import store.View.Output;

public class Membership {
    Input input = new Input();
    Output output = new Output();

    public boolean isMembership(String inputMember) {
        if (inputMember.equalsIgnoreCase("Y") || inputMember.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public void discount(ProductPurchase productPurchase) throws InvalidInputException {
        output.membership();
        String YN = input.getYesOrNo();
        boolean isMember = isMembership(YN);
        discountMembership(isMember, productPurchase);
    }

    private void discountMembership(boolean isMember, ProductPurchase productPurchase) {
        // 영수증 가격 인하, 재고 감소.
        if (isMember){

        }
    }
}
