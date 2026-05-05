package behavioral.strategy.ECommercePaymentSystem.payments;

/**
 * ============================================================
 *  STRATEGY PATTERN — Step 2b: Concrete Strategy
 * ============================================================
 *
 *  UPIPayment is a concrete implementation of PaymentStrategy
 *  specific to India's Unified Payment Interface (UPI).
 *
 *  This strategy has its own algorithm — validating the UPI ID
 *  format, generating a transaction reference ID, and simulating
 *  an instant bank transfer — completely different from
 *  credit card logic, but hidden behind the same interface.
 * ============================================================
 */

public class UPIPayment implements PaymentStrategy {

    private final String upiID;
    private final String upiApp;

    public UPIPayment (String upiID, String upiApp){
        this.upiID = upiID;
        this.upiApp = upiApp;
    }


    @Override
    public void pay(double amount) {

        if(!isValidUpiId(upiID)){
            System.out.printf("   Status       : ❌ Invalid UPI ID format! Payment Failed.");
            return;
        }

        String transactionRef = generateTransactionRef();
        System.out.printf( "   Amount       : ₹%.2f%n", amount);
        System.out.println("   Fee          : ₹0.00 (UPI is FREE! 🎉)");
        System.out.println("   Txn Ref ID   : " + transactionRef);
        System.out.println("   Status       : ✅ Payment Successful via " + upiApp + "!");


    }

    @Override
    public String getPaymentMethodName() {
        return "UPI - " + upiApp + " (" + upiID + ")";
    }


    private boolean isValidUpiId(String id){
        return id != null && id.contains("@") && id.indexOf("@")>0;
    }

    private String generateTransactionRef(){
        return "UPI" + System.currentTimeMillis();
    }
}