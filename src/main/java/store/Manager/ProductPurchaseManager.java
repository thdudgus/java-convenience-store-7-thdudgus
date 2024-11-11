package store.Manager;

public class ProductPurchaseManager {
    public static class ProductPurchase {
        private String name;
        private int quantity;

        public ProductPurchase(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "[" + name + "-" + quantity + "]";
        }

        // Getter 메서드
        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public Object getProductName() {
            return name;
        }
    }
}
