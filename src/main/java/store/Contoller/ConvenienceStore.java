package store.Contoller;

import static store.Constants.askPurchase;

import java.io.IOException;
import java.util.List;
import store.Exception.InvalidInputFormatException;
import store.Manager.FileManagement;
import store.Manager.Membership;
import store.Manager.Product;
import store.Manager.PromotionDetails;
import store.Manager.Purchase;
import store.View.Input;
import store.View.Output;

public class ConvenienceStore {
    FileManagement fileManagement = new FileManagement();
    Purchase purchase = new Purchase();
    Membership membership = new Membership();
    Output output = new Output();
    Input input = new Input();

    public void run() throws IOException, InvalidInputFormatException {
        List<Product> products = fileManagement.productOpen();
        List<PromotionDetails> promotions = fileManagement.promotionOpen();
        openForSale(products);
        while (true) {
            try{
                output.askPurchase();
                String inputPurchase = input.responsePurchase();
                break;
            }catch (InvalidInputFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void openForSale(List<Product> products) {
        output.welcome();
        output.stock(products);
    }

}
