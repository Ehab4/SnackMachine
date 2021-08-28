import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnacksMachine {
    private List<Product> productsList;
    private Customer customer;
    private HashMap<Float, Integer> returnedChange = new HashMap<Float, Integer>();
    private MachineMoneyState moneyState;

    public SnacksMachine(String productListJSONPath, String moneyInMachineJSONPath) {
        this.initProductList(productListJSONPath);
        this.initMachineMoneyState(moneyInMachineJSONPath);

    }

    void initProductList(String productListJSONPath){
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.productsList = mapper.readValue(new File(productListJSONPath),  new TypeReference<List<Product>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initMachineMoneyState(String moneyInMachineJSONPath){
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.moneyState = mapper.readValue(new File(moneyInMachineJSONPath),  MachineMoneyState.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Product> getProductList() {
        return this.productsList;
    }

    void setCustomer(String customerJSONPath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.customer = mapper.readValue(new File(customerJSONPath), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Product findProduct(int productID) {
        if (productID > 0 && productID <= 25){
            return this.productsList.get(productID - 1);
        }
        return  null;
    }

    int getProductAmount(int productID) {
        Product res = findProduct(productID);
        if (res == null){
            return 0;
        }
        return  res.getAmount();
    }

    HashMap<Float, Integer> computeChange(float reminder) {
        float temp = reminder;
        for (int i = 0; i < moneyState.getMoneyCounts().size(); i++) {
            for (int j =0; j < moneyState.getMoneyCounts().get(i); j++) {
                if (reminder >= moneyState.getMoneyValues().get(i)) {
                    if (returnedChange.get(moneyState.getMoneyValues().get(i)) == null){
                        returnedChange.put(moneyState.getMoneyValues().get(i), 1);
                    } else {
                        returnedChange.put(moneyState.getMoneyValues().get(i), returnedChange.get(moneyState.getMoneyValues().get(i)) + 1);
                    }

                    reminder = reminder*10 -moneyState.getMoneyValues().get(i)*10;
                    reminder /= 10.0f;

                    if (reminder == 0){
                        break;
                    }
                } else {
                    break;
                }
            }
            if (reminder == 0){
                break;
            }
        }

        float totalChange = 0;
        for (Map.Entry<Float, Integer> entry : this.returnedChange.entrySet()) {
            totalChange += entry.getKey() * entry.getValue();
        }
        if (totalChange != temp) {
            return null;
        }
        return this.returnedChange;
    }


    String purchaseSnack() {
        String res = "";
        Product p = findProduct(customer.getProductID());
        if (p != null) {
            if (p.getAmount() > 0) {
                if (this.customer.getMoneyCurrency().equals("USD")) {
                    float totalInsertedMoney = this.customer.getSumInsertedMoney();
                    if (totalInsertedMoney == p.getPriceValue()){
                        res = "Done";
                    } else if (totalInsertedMoney < p.getPriceValue()){
                        res = "Inserted Money is Not Enough";
                    } else if (totalInsertedMoney > p.getPriceValue()){
                        float reminder = totalInsertedMoney - p.getPriceValue();
                        HashMap<Float, Integer> rem = computeChange(reminder);
                        if (rem == null) {
                            res = "No Enough Change";
                        } else {
                            res = "Money Back";
                        }
                    }
                } else {
                    res = "Unknown Currency";
                }
            } else {
                res = "Product is Finished";
            }
        }else {
            res = "Product Not Found";
        }


        return res;
    }

    public HashMap<Float, Integer> getReturnedChange() {
        return returnedChange;
    }
}
