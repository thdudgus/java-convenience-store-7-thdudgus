package store.Manager;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> purchasedItems = new ArrayList<>();  // 일반 구매 상품
    private List<ReceiptItem> giftItems = new ArrayList<>();       // 증정 상품
    private int totalAmount = 0;       // 총 구매액
    private int promotionDiscount = 0; // 행사 할인
    private int membershipDiscount = 0;// 멤버십 할인

    // 상품을 추가하는 메서드
    public void addItem(String name, int quantity, int price) {
        ReceiptItem item = new ReceiptItem(name, quantity, price);
        purchasedItems.add(item);
        totalAmount += item.getTotal();
    }

    // 증정 상품을 추가하는 메서드
    public void addGiftItem(String name, int quantity) {
        ReceiptItem item = new ReceiptItem(name, quantity, 0); // 증정상품은 가격 0으로 설정
        giftItems.add(item);
    }

    // 할인 추가 메서드
    public void applyPromotionDiscount(int discount) {
        promotionDiscount += discount;
    }

    public void applyMembershipDiscount(int discount) {
        membershipDiscount += discount;
    }

    // 최종 결제 금액 계산 메서드
    public int calculateFinalAmount() {
        return totalAmount - promotionDiscount - membershipDiscount;
    }

    // 영수증 출력
    public void printReceipt() {
        System.out.println("==============W 편의점================");
        System.out.println("상품명\t\t수량\t금액");

        for (ReceiptItem item : purchasedItems) {
            System.out.printf("%s\t\t%d\t%d\n", item.getName(), item.getQuantity(), item.getTotal());
        }

        System.out.println("=============증    정===============");
        for (ReceiptItem giftItem : giftItems) {
            System.out.printf("%s\t\t%d\n", giftItem.getName(), giftItem.getQuantity());
        }

        System.out.println("====================================");
        System.out.printf("총구매액\t\t\t%d\n", totalAmount);
        System.out.printf("행사할인\t\t\t-%d\n", promotionDiscount);
        System.out.printf("멤버십할인\t\t\t-%d\n", membershipDiscount);
        System.out.printf("내실돈\t\t\t%d\n", calculateFinalAmount());
    }
}
