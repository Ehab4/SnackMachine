import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSnackMachine {

    @Test
    public void test () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\products.json");

        assert (sm.getProductList().size() == 1);

    }

    @Test
    public void test1 () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\products.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\Done.json");
        String res = sm.purchaseSnack();
        assert (res.equals("Done"));

    }

    @Test
    public void test2 () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\products.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\MoneyBack.json");
        String res = sm.purchaseSnack();
        System.out.println();
        HashMap<Float, Integer> expectedChange = new HashMap<Float, Integer>();
        expectedChange.put(20.0f, 1);
        expectedChange.put(1.0f, 10);
        expectedChange.put(0.5f, 10);
        expectedChange.put(0.2f, 10);
        expectedChange.put(0.1f, 10);
        assert (res.equals("Money Back"));

        HashMap<Float, Integer> returnedChange = sm.getReturnedChange();
        for (Map.Entry<Float, Integer> entry : expectedChange.entrySet()) {
            assert (returnedChange.get(entry.getKey()) != null);
            assert (returnedChange.get(entry.getKey()).equals(entry.getValue()));

        }

    }
}
