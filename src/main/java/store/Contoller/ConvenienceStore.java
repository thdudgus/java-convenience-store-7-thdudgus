package store.Contoller;

import java.io.IOException;
import java.util.List;
import store.Exception.ExcessQuantity;
import store.Exception.InvalidInputFormatException;
import store.Exception.NonExistentProduct;
import store.Exception.NullInputException;
import store.Manager.FileManagement;
import store.Manager.Membership;
import store.Manager.Product;
import store.Manager.ProductPurchaseManager.ProductPurchase;
import store.Manager.PromotionDetails;
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

    public void run() throws IOException, InvalidInputFormatException, NonExistentProduct {
        List<Product> products = fileManagement.productOpen();
        List<PromotionDetails> promotions = fileManagement.promotionOpen();
        openForSale(products);

        String inputPurchase;
        List<ProductPurchase> productPurchases = List.of();
        while (true) {
            try{
                output.askPurchase();
                inputPurchase = input.responsePurchase();
                productPurchases = parsingPurchase.parse(inputPurchase);
                System.out.println("Parsed product purchases: " + productPurchases);
                validation.stock(productPurchases, products);

                break;
            }catch (InvalidInputFormatException | NullInputException | NonExistentProduct | ExcessQuantity e) {
                productPurchases.clear();
                System.out.println(e.getMessage());
            }
        }

    }

    private void openForSale(List<Product> products) {
        output.welcome();
        output.stock(products);
    }

}
