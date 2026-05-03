package behavioral.strategy.ECommercePaymentSystem.payments.cards;

import behavioral.strategy.ECommercePaymentSystem.payments.PaymentStrategy;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardNetwork;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardType;


/**
 * ============================================================
 *  STRATEGY PATTERN — Step 2a: Concrete Strategy
 * ============================================================
 *
 *  cardPayment is one concrete implementation of the
 *  PaymentStrategy interface.
 *
 *  It contains the specific algorithm/logic for processing
 *  a payment via Credit Card — masking the card number,
 *  applying a transaction fee, and simulating bank approval.
 * ============================================================
 */

public class CardPayment implements PaymentStrategy {


    private final CardType cardType;
    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;


    public CardPayment(CardType cardType, String cardNumber, String cardHolderName, String expiryDate, String cvv){
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {

        CardNetwork cardServiceType = BinLookupService.getCardNetwork(cardNumber);

        switch (cardType){
            case CREDIT :
                processCredit(amount, cardServiceType);
                break;

            case DEBIT :
                processDebit(amount, cardServiceType);
                break;

            default:
                throw new IllegalArgumentException("Invalid card type");
        }

    }

    @Override
    public String getPaymentMethodName() {
        return cardType.name() + " CARD";
    }

    private void processCredit(double amount, CardNetwork network){
        System.out.println("Processing " + network + " Credit Card payment");

        double fee = amount * 0.02;
        double total = amount + fee;

        System.out.println("Total Charged: " + total);
        System.out.println("Card: " + maskCardNumber(cardNumber));

    }

    private void processDebit(double amount, CardNetwork network){
        System.out.println("Processing " + network + " Debit Card payment");

        double fee = amount * 0.01;
        double total = amount + fee;

        System.out.println("Total Charged: " + total);
        System.out.println("Card: " + maskCardNumber(cardNumber));

    }


    private String maskCardNumber(String Number) {
        String cleaned = Number.replaceAll("\\s","");
        String lastFour = cleaned.substring(cleaned.length()-4);
        return "**** **** **** "+lastFour;
    }
}
