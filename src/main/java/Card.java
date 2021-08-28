public class Card implements Money{
    static String AcceptedCards[] = {"VISA", "PALPAY", "MasterCard"};
    float value;
    String currency;
    String CardName;
    float availableBalance;

    public Card(float value, String currency, String cardName, float availableBalance) {
        this.value = value;
        this.currency = currency;
        CardName = cardName;
        this.availableBalance = availableBalance;
    }

    public boolean validate() {
        for (int i =0; i < AcceptedCards.length; i++){
            if(AcceptedCards[i].equals(this.CardName)){
                return true;
            }
        }
        return false;
    }

    public float getValue() {
        if (availableBalance >= value){
            return value;
        }
        return -1;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public float getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(float availableBalance) {
        this.availableBalance = availableBalance;
    }
}
