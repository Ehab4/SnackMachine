import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SnacksMachine sm = new SnacksMachine("D:\\snackmachine\\src\\main\\resources\\Main\\products.json", "D:\\snackmachine\\src\\main\\resources\\Main\\MoneyInMachine.json");


        System.out.println("Available Products:");
        System.out.println(sm.getProductList());

        System.out.print("Select Product ID: ");
        Scanner sc = new Scanner(System.in);
        int productID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Currency: ");
        String currency = sc.nextLine().replace(" ", "");
        System.out.print("Enter Money: ");
        String[] moneyInsertedStr = sc.nextLine().split(" ");
        List<Float> moneyInserted = new ArrayList<Float>();
        for (String x: moneyInsertedStr) {
            try {
                float res = Float.parseFloat(x);
                moneyInserted.add(res);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        sm.setCustomer(new Customer(productID, moneyInserted, currency));

        String res = sm.purchaseSnack();

        System.out.println(res);
        if (res.equals("Money Back")) {
            System.out.print("Change: ");
            System.out.println(sm.getReturnedChange());
        }
        System.out.println("Thanks");
    }
}
