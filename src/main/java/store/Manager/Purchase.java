package store.Manager;
import store.Manager.ProductPurchaseManager.ProductPurchase;

public class Purchase {
    FileManagement fileManagement = new FileManagement();
    Receipt receipt = new Receipt();

    // 프로모션 수량이 충분함.
    public void payment(Product product, ProductPurchase productPurchase, PromotionDetails promotionName) {
        if (product.getPromotion() == promotionName.getName()){
            checkBuy(productPurchase, promotionName);
        }
    }

    private void checkBuy(ProductPurchase productPurchase, PromotionDetails promotionName) {
        int buy = promotionName.getPromotion().getBuy();
        int get = promotionName.getPromotion().getGet();
        int n = buy/get;
        if (productPurchase.getQuantity() == (buy+get)*n){ // 딱 맞게 가져왔을 때
            Integer newQuantity = productPurchase.getQuantity() - (productPurchase.getQuantity()/(buy+get));
            fileManagement.updateProduct(productPurchase.getName(), newQuantity); // 재고 감소
            // 영수증 작성
        }
    }
}
