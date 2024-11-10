package store.Contoller;

import java.io.IOException;
import store.Manager.FileManagement;
import store.Manager.Membership;
import store.Manager.Purchase;
import store.View.Output;

public class ConvenienceStore {
    FileManagement fileManagement = new FileManagement();
    Purchase purchase = new Purchase();
    Membership membership = new Membership();
    Output output = new Output();

    public void openFile() throws IOException {
        fileManagement.productOpen();
        fileManagement.promotionOpen();
    }

    private void openForSale() {
        output.welcome();
    }

}
