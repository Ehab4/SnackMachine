public class Product {
    int id;
    int priceValue;
    int amount;
    String moneyCurrency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(int priceValue) {
        this.priceValue = priceValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMoneyCurrency() {
        return moneyCurrency;
    }

    public void setMoneyCurrency(String moneyCurrency) {
        this.moneyCurrency = moneyCurrency;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", priceValue=" + priceValue +
                ", amount=" + amount +
                ", moneyCurrency='" + moneyCurrency + '\'' +
                '}';
    }
}
