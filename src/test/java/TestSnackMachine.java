import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSnackMachine {

    @Test
    public void testReadingProducts () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\DoneTest\\products.json", "D:\\snackmachine\\src\\main\\resources\\DoneTest\\MoneyInMachine.json");
        assert (sm.getProductList().size() == 25);
    }

    @Test
    public void DoneTest () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\DoneTest\\products.json", "D:\\snackmachine\\src\\main\\resources\\DoneTest\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\DoneTest\\customer.json");
        String res = sm.purchaseSnack();
        assert (res.equals("Done"));

    }

    @Test
    public void MoneyBackTest () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest\\products.json", "D:\\snackmachine\\src\\main\\resources\\MoneyBackTest\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest\\customer.json");
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

    @Test
    public void MoneyBackTest_2 () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest2\\products.json", "D:\\snackmachine\\src\\main\\resources\\MoneyBackTest2\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest2\\customer.json");
        String res = sm.purchaseSnack();
        HashMap<Float, Integer> expectedChange = new HashMap<Float, Integer>();
        expectedChange.put(20.0f, 2);
        expectedChange.put(1.0f, 4);
        expectedChange.put(0.2f, 2);
        assert (res.equals("Money Back"));

        HashMap<Float, Integer> returnedChange = sm.getReturnedChange();
        for (Map.Entry<Float, Integer> entry : expectedChange.entrySet()) {
            assert (returnedChange.get(entry.getKey()) != null);
            assert (returnedChange.get(entry.getKey()).equals(entry.getValue()));

        }
    }

    @Test
    public void MoneyBackTest_3 () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest3\\products.json", "D:\\snackmachine\\src\\main\\resources\\MoneyBackTest3\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\MoneyBackTest3\\customer.json");
        String res = sm.purchaseSnack();
        HashMap<Float, Integer> expectedChange = new HashMap<Float, Integer>();
        expectedChange.put(1.0f, 10);
        expectedChange.put(0.5f, 2);
        expectedChange.put(0.2f, 7);
        expectedChange.put(0.1f, 1);
        assert (res.equals("Money Back"));

        HashMap<Float, Integer> returnedChange = sm.getReturnedChange();
        for (Map.Entry<Float, Integer> entry : expectedChange.entrySet()) {
            assert (returnedChange.get(entry.getKey()) != null);
            assert (returnedChange.get(entry.getKey()).equals(entry.getValue()));

        }
    }

    @Test
    public void MoneyIsNotEnoughTest () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\MoneyIsNotEnoughTest\\products.json", "D:\\snackmachine\\src\\main\\resources\\MoneyIsNotEnoughTest\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\MoneyIsNotEnoughTest\\customer.json");
        String res = sm.purchaseSnack();
        assert (res.equals("Inserted Money is Not Enough"));

    }

    @Test
    public void NoEnoughChangeTest () {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\NoEnoughChangeTest\\products.json", "D:\\snackmachine\\src\\main\\resources\\NoEnoughChangeTest\\MoneyInMachine.json");
        sm.setCustomer("D:\\snackmachine\\src\\main\\resources\\NoEnoughChangeTest\\customer.json");
        String res = sm.purchaseSnack();
        assert (res.equals("No Enough Change"));

    }
}
