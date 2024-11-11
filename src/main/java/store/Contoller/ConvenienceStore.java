package store.Contoller;

import java.io.IOException;
import java.util.List;
import store.Manager.FileManagement;
import store.Manager.Membership;
import store.Manager.Product;
import store.Manager.PromotionDetails;
import store.Manager.Purchase;
import store.View.Output;

public class ConvenienceStore {
    FileManagement fileManagement = new FileManagement();
    Purchase purchase = new Purchase();
    Membership membership = new Membership();
    Output output = new Output();

    public void openFile() throws IOException {
        List<Product> products = fileManagement.productOpen();
        List<PromotionDetails> promotions = fileManagement.promotionOpen();
        openForSale(products);
    }

    private void openForSale(List<Product> products) {
        output.welcome();
        output.stock(products);
    }

}
