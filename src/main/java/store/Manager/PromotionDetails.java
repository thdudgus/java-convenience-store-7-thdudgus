package store.Manager;

import java.time.LocalDate;

public class PromotionDetails {
    private Promotion promotion;
    private LocalDate startDate;
    private LocalDate endDate;

    public PromotionDetails(Promotion promotion, LocalDate startDate, LocalDate endDate) {
        this.promotion = promotion;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Object getName() {
        return promotion;
    }
}
