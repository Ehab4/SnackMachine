import java.util.List;

public class Customer {

    private int productID;
    private List<Float> moneyInserted;
    private String moneyCurrency;

    public Customer(int productID, List<Float> moneyInserted, String moneyCurrency) {
        this.productID = productID;
        this.moneyInserted = moneyInserted;
        this.moneyCurrency = moneyCurrency;
    }
    public Customer() {

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public List<Float> getMoneyInserted() {
        return moneyInserted;
    }

    public void setMoneyInserted(List<Float> moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    public String getMoneyCurrency() {
        return moneyCurrency;
    }

    public void setMoneyCurrency(String moneyCurrency) {
        this.moneyCurrency = moneyCurrency;
    }

    float getSumInsertedMoney () {
        float sum = 0;
        for (float x: moneyInserted){
            sum += x;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "productID=" + productID +
                ", moneyInserted=" + moneyInserted +
                ", moneyCurrency='" + moneyCurrency + '\'' +
                '}';
    }
}
