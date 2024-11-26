package store.Contoller;

import static store.Domain.Constants.comma;
import static store.Domain.Constants.hyphen;

import java.util.ArrayList;
import java.util.List;
import store.Manager.ProductPurchaseManager.ProductPurchase;
import store.Validation;

public class ParsingPurchase {
    List<ProductPurchase> purchases = new ArrayList<>();

    public List<ProductPurchase> parse(String inputPurchase) {
        String[] items = inputPurchase.split(comma);
        for (String item : items) {
            item = item.substring(1, item.length() - 1);
            parseDetail(item);
        }
        return purchases;
    }

    private void parseDetail(String item) {
        String[] parts = item.split(hyphen);
        String name = parts[0];
        int quantity = Integer.parseInt(parts[1]);
        purchases.add(new ProductPurchase(name, quantity));
    }
}
