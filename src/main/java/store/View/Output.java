package store.View;

import static store.Domain.Constants.AdditionalQuantity;
import static store.Domain.Constants.isMembership;
import static store.Domain.Constants.Welcome;
import static store.Domain.Constants.askPurchase;
import static store.Domain.ErrorMessages.invalidInput;

import java.util.List;
import store.Manager.Product;

public class Output {
    public void welcome(){
        System.out.println(Welcome);
    }

    public void stock(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getPromotion());
        }
        System.out.println();
    }

    public void askPurchase() {
        System.out.println(askPurchase);
    }


    private int findProductPrice(String name, List<Product> products) {
        // 제품 가격 반환 로직
        return 0;
    }

//    public void printReceipt(List<ProductPurchase> productPurchases, List<Product> products) {
//        printReceiptHeader();
//        int totalAmount = 0;
//        int totalQuantity = 0;
//
//        for (ProductPurchase purchase : productPurchases) {
//            int price = findProductPrice(purchase.getName(), products);
//            totalAmount += price * purchase.getQuantity();
//            totalQuantity += purchase.getQuantity();
//            printPurchaseDetail(purchase, price);
//        }
//
//        printTotal(totalAmount, totalQuantity);
//    }

    public void askAdditionalQuantity(String name, int requiredQuantity) {
        System.out.println(String.format(AdditionalQuantity, name, requiredQuantity));
    }

    public void insufficientPromotionStockMessage() {

    }

    public void showError() {
        System.out.println(invalidInput);
    }

    public void additionalGet(int buyCount, String name) {
        System.out.printf((AdditionalQuantity) + "%n", name, buyCount);
    }

    public void membership() {
        System.out.println(isMembership);
    }
}
