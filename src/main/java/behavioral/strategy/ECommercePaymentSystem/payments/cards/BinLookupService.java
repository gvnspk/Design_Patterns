package behavioral.strategy.ECommercePaymentSystem.payments.cards;

import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardNetwork;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardType;

public class BinLookupService {

    public static CardType getCardType(String cardNumber) {

        if (cardNumber == null || cardNumber.length() < 6) {
            return CardType.UNKNOWN;
        }

        String bin = cardNumber.substring(0,6);

        if(bin.startsWith("4")){
            return CardType.CREDIT;
        }
        else if (bin.startsWith("5")){
            return CardType.DEBIT;
        }

        return CardType.UNKNOWN;
    }

    public static CardNetwork getCardNetwork(String cardNumber){

        if (cardNumber == null || cardNumber.length() < 6) {
            return CardNetwork.UNKNOWN;
        }

        if(cardNumber.startsWith("4")){
            return CardNetwork.VISA;
        }
        else if(cardNumber.startsWith("5")){
            return CardNetwork.MASTERCARD;
        }
        return CardNetwork.UNKNOWN;
    }
}
