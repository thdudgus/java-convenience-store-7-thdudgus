package store.Manager;

import java.util.List;
import store.Exception.InvalidInputException;
import store.Manager.ProductPurchaseManager.ProductPurchase;
import store.View.Input;
import store.View.Output;

public class PromotionManager {
    private final Output output = new Output();
    private final Input input = new Input();
    FileManagement fileManagement = new FileManagement();
    Membership membership = new Membership();
    Purchase purchase = new Purchase();

    public void isPromotion(List<ProductPurchase> productPurchases, List<PromotionDetails> promotions, List<Product> products)
            throws InvalidInputException {
        for (ProductPurchase productPurchase : productPurchases) {
            PromotionDetails PromotionName = promptionPerProduct(productPurchase, promotions);
            if (PromotionName != null) {  // 프로모션이 있는 경우
                stockCheck(productPurchase, products, PromotionName);
            }
            membership.discount(productPurchase);// 미완
        }
    }

    private void stockCheck(ProductPurchase productPurchase, List<Product> products, PromotionDetails promotionName) {
        for (Product product : products) {
            if (product.getName().equals(productPurchase.getName())) {
                stockCheckperProduct(product, productPurchase, promotionName);
            }
        }
    }

    private void stockCheckperProduct(Product product, ProductPurchase productPurchase, PromotionDetails promotionName) {
        if (product.getQuantityInt() < productPurchase.getQuantity()){
            return; // 프로모션 수량이 모자름
        }
        // 프로모션 수량이 충분함
        purchase.payment(product, productPurchase, promotionName);
        return;
    }


    private PromotionDetails promptionPerProduct(ProductPurchase productPurchase, List<PromotionDetails> promotions) {
        for (PromotionDetails promotion : promotions) {
            if (promotion.getName() == productPurchase.getName()) { //
                return promotion;
            }
            return null;
        }
        return null;
    }
}
