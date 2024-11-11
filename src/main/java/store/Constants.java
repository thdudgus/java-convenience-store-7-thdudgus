package store;

public class Constants {
    public static final String Welcome = "안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n";
    public static final String productFile = "src/main/resources/products.md";
    public static final String promotionFile = "src/main/resources/promotions.md";

    public static final String monetaryUnit = "원";
    public static final String thing = "개";
    public static final String noStock = "재고 없음";
    public static final String noStockNumber = "0";

    public static final String PurchaseFormat = "(\\[[\\w가-힣]+-\\d+])(,\\[[\\w가-힣]+-\\d+])*";
    public static final String askPurchase = "구매하실 상품명과 수량을 입력해주세요. (예: [사이다-2],[감자칩-1])";

    public static final String comma = ",";
    public static final String hyphen = "-";
}
