package store.Manager;

public class ReceiptItem {
    private String name;
    private int quantity;
    private int price;  // 단가
    private int total;  // 금액

    public ReceiptItem(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    // 금액을 다시 계산하는 메서드
    public void updateTotal() {
        this.total = this.quantity * this.price;
    }

    // Getter와 Setter
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getPrice() { return price; }
    public int getTotal() { return total; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotal();
    }
}

