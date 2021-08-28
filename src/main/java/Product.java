public class Product {
    private int id;
    private float priceValue;
    private int amount;
    private String moneyCurrency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(float priceValue) {
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
