import java.util.List;

public class MachineMoneyState {
    private List<Integer> moneyCounts;
    private List<Float> moneyValues;

    public List<Integer> getMoneyCounts() {
        return moneyCounts;
    }

    public void setMoneyCounts(List<Integer> moneyCounts) {
        this.moneyCounts = moneyCounts;
    }

    public List<Float> getMoneyValues() {
        return moneyValues;
    }

    public void setMoneyValues(List<Float> moneyValues) {
        this.moneyValues = moneyValues;
    }
}
