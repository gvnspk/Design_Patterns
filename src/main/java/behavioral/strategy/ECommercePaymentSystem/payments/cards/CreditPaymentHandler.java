package behavioral.strategy.ECommercePaymentSystem.payments.cards;

import behavioral.strategy.ECommercePaymentSystem.payments.PaymentStrategy;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardNetwork;

public class CreditPaymentHandler implements PaymentStrategy {

    private String cardNumber;

    public void process(String cardNumber, String expiryDate, String cvv, String cardName , CardNetwork cardServiceType){
        this.cardNumber = cardNumber;
        System.out.println("Processing " + cardServiceType + " Credit Card payment");
    }

    @Override
    public void pay(double amount) {

        double transactionFee = amount * 0.02;   // 2% transaction fee
        double totalCharged   = amount + transactionFee;

        System.out.println("Total Charged: " + totalCharged);


    }

    @Override
    public String getPaymentMethodName() {
        return  "Credit Card (" + maskCardNumber(cardNumber) + ")";
    }

    private String maskCardNumber(String Number) {
        String cleaned = Number.replaceAll("\\s","");
        String lastFour = cleaned.substring(cleaned.length()-4);
        return "**** **** **** "+lastFour;
    }
}
