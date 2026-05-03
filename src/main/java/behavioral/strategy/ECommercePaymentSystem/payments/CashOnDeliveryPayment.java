package behavioral.strategy.ECommercePaymentSystem.payments;

/**
 * ============================================================
 *  STRATEGY PATTERN — Step 2d: Concrete Strategy
 * ============================================================
 *
 *  CashOnDeliveryPayment shows that a Strategy doesn't have
 *  to involve complex logic — COD is just a confirmation that
 *  the payment will happen offline. It still implements the
 *  same PaymentStrategy interface, proving the pattern works
 *  for any "family of algorithms", even simple ones.
 * ============================================================
 */

public class CashOnDeliveryPayment implements PaymentStrategy{

    private final String deliveryAddress;
    private final String customerName;

    public CashOnDeliveryPayment(String customerName, String deliveryAddress) {
        this.customerName    = customerName;
        this.deliveryAddress = deliveryAddress;
    }


    @Override
    public void pay(double amount) {

        System.out.println("\n🚚 [Cash On Delivery]");
        System.out.println("   Customer     : " + customerName);
        System.out.println("   Address      : " + deliveryAddress);

        double serviceFee = 50.00;   // Flat ₹10 net banking fee
        double total      = amount + serviceFee;

        System.out.printf( "   Amount Due   : ₹%.2f (Pay at delivery)%n", amount);
        System.out.println("   Note         : Please keep exact change ready.");
        System.out.println("   Status       : ✅ Order Confirmed! Pay when it arrives.");

    }

    @Override
    public String getPaymentMethodName() {
        return "Cash on Delivery";
    }
}