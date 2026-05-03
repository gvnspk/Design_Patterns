package behavioral.strategy.ECommercePaymentSystem.payments.cardServices;

import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardNetwork;

public class BinLookupService {

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
