package store.Manager;

public enum Promotion {
    TANSAN_2_PLUS_1("탄산2+1", 2, 1),
    MD_RECOMMENDED("MD추천상품", 1, 1),
    FLASH_DISCOUNT("반짝할인", 1, 1);

    private final String name;
    private final int buy;
    private final int get;

    Promotion(String name, int buy, int get) {
        this.name = name;
        this.buy = buy;
        this.get = get;
    }

    public String getName() {
        return name;
    }

    public int getBuy() {
        return buy;
    }

    public int getGet() {
        return get;
    }

    public static Promotion fromName(String name) {
        for (Promotion promo : Promotion.values()) {
            if (promo.getName().equals(name)) {
                return promo;
            }
        }
        throw new IllegalArgumentException("Unknown promotion: " + name);
    }
}

