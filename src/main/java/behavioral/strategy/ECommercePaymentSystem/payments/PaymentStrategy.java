package behavioral.strategy.ECommercePaymentSystem.payments;

/**
 * ============================================================
 *  STRATEGY PATTERN — Step 1: The Strategy Interface
 * ============================================================
 *
 *  This is the CORE of the Strategy Pattern.
 *  It declares a common interface (contract) that every
 *  concrete payment algorithm must follow.
 *
 *  WHY?
 *  The Context (ShoppingCart) programs to this interface,
 *  not to any concrete class — making it easy to swap
 *  strategies at runtime without changing the context.
 */

public interface PaymentStrategy{

    /**
     * Each concrete strategy must implement its own version
     * of how a payment is processed.
     *
     * @param amount The total amount to be paid (in INR ₹)
     */
    void pay (double amount);

    /**
     * Returns a friendly name for the payment method.
     * Useful for receipts and display purposes.
     *
     * @return Name of the payment strategy
     */

    String getPaymentMethodName();
}