package store.Domain;

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
    public static final String space = " ";
    public static final String seperater = "\n";

    public static final String AdditionalQuantity = "현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)";
    public static final String isMembership = "멤버십 할인을 받으시겠습니까? (Y/N)";

    public static final String firstRecipeLine = "==============W 편의점================";
    public static final String secondRecipeLine = "상품명\t\t수량\t금액";
    public static final String freeLine = "=============증\t정===============";
    public static final String Line = "====================================";
    public static final String total = "총구매액";
    public static final String eventDiscount = "행사할인";
    public static final String membershipDiscount = "멤버십할인";
    public static final String money = "내실 돈";
}
