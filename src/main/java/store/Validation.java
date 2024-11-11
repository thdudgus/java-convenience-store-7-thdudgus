package store;

import static store.Domain.Constants.PurchaseFormat;
import static store.Domain.ErrorMessages.excessQuantity;
import static store.Domain.ErrorMessages.inputFormatError;
import static store.Domain.ErrorMessages.invalidInput;
import static store.Domain.ErrorMessages.nonExistentProduct;

import java.util.List;
import store.Exception.ExcessQuantity;
import store.Exception.InvalidInputFormatException;
import store.Exception.NonExistentProduct;
import store.Exception.NullInputException;
import store.Manager.Product;
import store.Manager.ProductPurchaseManager.ProductPurchase;

public class Validation {
    public void order(String input) throws InvalidInputFormatException, NullInputException {
        if (input == null || input.isEmpty()) {
            throw new NullInputException(invalidInput);
        }
        if (!input.matches(PurchaseFormat)) {
            throw new InvalidInputFormatException(inputFormatError);
        }
    }

    public void stock(List<ProductPurchase> productPurchases, List<Product> productList)
            throws NonExistentProduct, ExcessQuantity {
        for (ProductPurchase purchase : productPurchases) {
            nonExistent(purchase, productList);
        }
    }

    private void nonExistent(ProductPurchase purchase, List<Product> productList)
            throws NonExistentProduct, ExcessQuantity {
        int totalQuantity = 0;
        totalQuantity = productList.stream()
                .filter(product -> product.getName().equals(purchase.getName()))
                .mapToInt(Product::getQuantityInt)
                .sum();

        if (totalQuantity == 0) {
            throw new NonExistentProduct(nonExistentProduct);
        }
        excess(purchase, totalQuantity);
    }

    private void excess(ProductPurchase purchase, int totalQuantity)
            throws ExcessQuantity {
        if (purchase.getQuantity() > totalQuantity) {
            throw new ExcessQuantity(excessQuantity);
        }
    }
}
