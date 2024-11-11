package store.Contoller;

import java.io.IOException;
import java.util.List;
import store.Exception.ExcessQuantity;
import store.Exception.InvalidInputException;
import store.Exception.InvalidInputFormatException;
import store.Exception.NonExistentProduct;
import store.Manager.FileManagement;
import store.Manager.Membership;
import store.Manager.Product;
import store.Manager.ProductPurchaseManager.ProductPurchase;
import store.Manager.PromotionDetails;
import store.Manager.PromotionManager;
import store.Manager.Purchase;
import store.Validation;
import store.View.Input;
import store.View.Output;

public class ConvenienceStore {
    FileManagement fileManagement = new FileManagement();
    Purchase purchase = new Purchase();
   Membership membership = new Membership();
    Output output = new Output();
    Input input = new Input();
    ParsingPurchase parsingPurchase = new ParsingPurchase();
    Validation validation = new Validation();
    PromotionManager promotionManager = new PromotionManager();

    public void run() throws IOException, InvalidInputFormatException, NonExistentProduct, InvalidInputException {
        List<Product> products = fileManagement.productOpen();
        List<PromotionDetails> promotions = fileManagement.promotionOpen();
        openForSale(products);

        String inputPurchase;
        List<ProductPurchase> productPurchases = List.of();
        while (true) {
            try{
                output.askPurchase();
                inputPurchase = input.responsePurchase();
                productPurchases = parsingPurchase.parse(inputPurchase);  // 구매 목록.
                validation.stock(productPurchases, products);
                break;
            }catch (InvalidInputFormatException | InvalidInputException | NonExistentProduct | ExcessQuantity e) {
                productPurchases.clear();
                System.out.println(e.getMessage());
            }
        }

        promotionManager.isPromotion(productPurchases, promotions, products);

        String inputMember;
        while(true) {
            try{
                output.membership();
                inputMember = input.getYesOrNo();
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }






//        // 사려는 상품의 프로모션 적용 여부 확인
//        boolean applyPromotion = promotionManager.applyPromotions(productPurchases, promotions);
//        // 적용되면
//        promotionManager.realPromotion(productPurchases, promotions, products, applyPromotion);

//
//        // 영수증 출력
//        output.printReceipt(productPurchases, products);
//
//        // 추가 구매
//        askForAdditionalPurchase(products);
    }

    private void askForAdditionalPurchase(List<Product> products) {

    }

    private void openForSale(List<Product> products) {
        output.welcome();
        output.stock(products);
    }

}
