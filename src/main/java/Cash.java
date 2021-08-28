public class Cash implements Money{
    float value;
    String currency;

    public boolean validate() {
        return true;
    }
    public String getCurrency() {
        return this.currency;
    }
    public float getValue() {
        return this.value;
    }
}
