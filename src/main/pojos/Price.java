package main.pojos;

public class Price {
    private float cost;
    private float discount;
    private String currency;

    public Price(float cost, float discount, String currency) {
        this.cost = cost;
        this.discount = discount;
        this.currency = currency;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
