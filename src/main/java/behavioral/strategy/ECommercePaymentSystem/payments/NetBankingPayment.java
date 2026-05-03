package behavioral.strategy.ECommercePaymentSystem.payments;

/**
 * ============================================================
 *  STRATEGY PATTERN — Step 2c: Concrete Strategy
 * ============================================================
 *
 *  NetBankingPayment is a concrete implementation of
 *  PaymentStrategy for Internet Banking.
 *
 *  It simulates redirecting the user to their bank's portal,
 *  validating credentials, and processing the transfer.
 *  Again — completely different algorithm, same interface.
 * ============================================================
 */


public class NetBankingPayment implements PaymentStrategy {

    private final String bankName;
    private final Long accountNumber;
    private final String username;

    public NetBankingPayment (String bankName , Long accountNumber, String username){

        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.username = username;

    }

    @Override
    public void pay(double amount) {

        if(validateAccountNumber(accountNumber)) {

            System.out.println("\n🏦 [Net Banking Payment]");
            System.out.println("   Bank         : " + bankName);
            System.out.println("   Account No   : " + maskAccountNumber(accountNumber));
            System.out.println("   User         : " + username);
            System.out.println("   → Redirecting to " + bankName + " secure portal...");
            System.out.println("   → Authenticating credentials...");

            double serviceFee = 10.00;   // Flat ₹10 net banking fee
            double total      = amount + serviceFee;

            System.out.printf( "   Amount       : ₹%.2f%n", amount);
            System.out.printf( "   Service Fee  : ₹%.2f%n", serviceFee);
            System.out.printf( "   Total Debited: ₹%.2f%n", total);
            System.out.println("   Status       : ✅ Fund Transfer Successful!");

        }
        else{
            throw new IllegalArgumentException("Invalid Account Number");

        }
    }

    @Override
    public String getPaymentMethodName() {
        return "Net Banking - " + bankName;
    }

    private String maskAccountNumber(Long acc){
        String accountValue = String.valueOf(acc);
        String lastFour = accountValue.substring(accountValue.length() - 4);
        return "XXXXXXXX" + lastFour;
    }

    private boolean validateAccountNumber(Long accountNumber){
        String accountValue = String.valueOf(accountNumber);
        return accountValue != null && accountValue.length() == 12;
    }


}