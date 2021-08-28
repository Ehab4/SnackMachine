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
        System.out.print("Enter Way of Payment (CASH/CARD): ");
        String wayOfPayment = sc.nextLine();
        String currency = "";
        List<Float> moneyInserted = new ArrayList<Float>();
        if (wayOfPayment.equals("CASH")) {
            System.out.print("Enter Currency: ");
            currency = sc.next();
            sc.nextLine();
            System.out.print("Enter Money: ");
            String[] moneyInsertedStr = sc.nextLine().split(" ");

            for (String x: moneyInsertedStr) {
                try {
                    float res = Float.parseFloat(x);
                    moneyInserted.add(res);
                } catch (NumberFormatException ex){
                    System.out.println(ex.getMessage());
                    return;
                }
            }
        } else if (wayOfPayment.equals("CARD")){
            System.out.println("Enter Card Info: ");
            System.out.print("Enter Card Name: ");
            String cardName = sc.nextLine();
            System.out.print("Enter Card Currency: ");
            currency = sc.nextLine();
            System.out.print("Enter Card Avilable Balance: ");
            float cardAvilableBalance = sc.nextFloat();

            Card card = new Card(sm.getProductPrice(productID), currency, cardName, cardAvilableBalance);
            if (card.validate()) {
                if (card.getValue() != -1) {
                    moneyInserted = new ArrayList<Float>();
                    moneyInserted.add(sm.getProductPrice(productID));
                } else {
                    System.out.println("No Enough Balance in Card");
                }
            } else {
                System.out.println("Card Not Valid");
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
