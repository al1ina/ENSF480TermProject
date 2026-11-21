package src.business;

import java.time.LocalDate;

public class PromotionNews {
    private String title;
    private String details;
    private String month;

    public PromotionNews(String title, String details, String month) {
        this.title = title;
        this.details = details;
        this.month = month;
    }
    public boolean isFirstDayOfMonth() {
        return LocalDate.now().getDayOfMonth() == 1;
    }
}
