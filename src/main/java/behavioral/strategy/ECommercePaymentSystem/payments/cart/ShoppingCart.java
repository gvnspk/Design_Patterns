package behavioral.strategy.ECommercePaymentSystem.payments.cart;


import behavioral.strategy.ECommercePaymentSystem.payments.PaymentStrategy;
import behavioral.strategy.ECommercePaymentSystem.payments.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 *  STRATEGY PATTERN — Step 3: The CONTEXT class
 * ============================================================
 *
 *  ShoppingCart is the CONTEXT in the Strategy Pattern.
 *
 *  WHAT IS A CONTEXT?
 *  The Context is the class that USES a strategy. It holds
 *  a reference to the Strategy interface — NOT to any
 *  specific implementation. This is the "program to an
 *  interface, not an implementation" principle in action.
 *
 *  KEY RESPONSIBILITIES:
 *  1. Maintain a list of products (cart management)
 *  2. Hold a reference to a PaymentStrategy
 *  3. Allow swapping the strategy at runtime (setPaymentStrategy)
 *  4. Delegate the actual payment work to the strategy object
 *
 *  WHAT THE CONTEXT DOESN'T KNOW (and shouldn't know):
 *  - HOW credit card processing works internally
 *  - HOW UPI transfers money
 *  - HOW net banking redirects users
 *  It just calls strategy.pay(totalAmount) and trusts the
 *  strategy to handle the rest.
 *
 *  ┌──────────────────────────────────────────────────────┐
 *  │                  ShoppingCart (Context)              │
 *  │                                                      │
 *  │  - products: List<Product>                           │
 *  │  - paymentStrategy: PaymentStrategy  ◄── Interface   │
 *  │                                                      │
 *  │  + setPaymentStrategy(strategy)   ◄── Swap at runtime│
 *  │  + checkout()  ──► strategy.pay(total) (delegates)   │
 *  └──────────────────────────────────────────────────────┘
 *          │ uses
 *          ▼
 *  ┌────────────────────┐
 *  │  <<interface>>     │
 *  │  PaymentStrategy   │
 *  │  + pay(amount)     │
 *  └────────────────────┘
 *       ▲        ▲        ▲        ▲
 *  CreditCard   UPI   NetBanking  COD
 * ===================================
 */

public class ShoppingCart {

    private final List<Product> products;

    private PaymentStrategy paymentStrategy;

    public ShoppingCart(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println("🛒 Added: " + product.getName()
                + " (₹" + product.getPrice() + " x " + product.getQuantity() + ")");
    }

    public void removeProduct(String  productName){
        products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
        System.out.println("🗑️  Removed: " + productName);
    }

    public double calculateTotal(){
        return products.stream()
                       .mapToDouble(Product :: getTotal)
                       .sum();
    }

    // ── Strategy Management ──────────────────────────────────

    /**
     * Sets (or SWAPS) the payment strategy at runtime.
     *
     * This is the heart of the Strategy Pattern.
     * The client can change the payment method on-the-fly —
     * the cart doesn't need to be recreated or modified.
     *
     * @param paymentStrategy Any object implementing PaymentStrategy
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("\n🔄 Payment method set to: " + paymentStrategy.getPaymentMethodName());
    }

    // ── Core Action: Checkout ────────────────────────────────

    /**
     * Processes the checkout.
     *
     * DELEGATION: The ShoppingCart doesn't know HOW to pay.
     * It simply DELEGATES that responsibility to whatever
     * PaymentStrategy is currently set.
     *
     * This means:
     *  - Adding a new payment method = Add a new Strategy class
     *  - ZERO changes needed to ShoppingCart
     *  - This is the Open/Closed Principle (SOLID) in action!
     */

    public void checkout(){

        if (paymentStrategy == null) {
            System.out.println("❌ No payment method selected! Please set a payment strategy.");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("❌ Your cart is empty! Add some products first.");
            return;
        }

        printCartSummary();

        double total = calculateTotal();

        paymentStrategy.pay(total);

        printReceipt(total);
    }

    // ── Display Helpers ──────────────────────────────────────

    /**
     * Prints a formatted cart summary before checkout.
     */
    public void printCartSummary() {
        System.out.println("\n" + "═".repeat(55));
        System.out.println("           🛍️  YOUR SHOPPING CART");
        System.out.println("═".repeat(55));
        System.out.println(String.format("   %-25s %8s %3s %10s", "Product", "Price", "Qty", "Subtotal"));
        System.out.println("─".repeat(55));
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("─".repeat(55));
        System.out.printf("   %-25s %20s%n", "CART TOTAL", String.format("₹%.2f", calculateTotal()));
        System.out.println("═".repeat(55));
    }

    /**
     * Prints a receipt after a successful payment attempt.
     */
    private void printReceipt(double total) {
        System.out.println("\n" + "─".repeat(55));
        System.out.println("   📄 RECEIPT");
        System.out.println("─".repeat(55));
        System.out.printf("   Payment Method : %s%n", paymentStrategy.getPaymentMethodName());
        System.out.printf("   Cart Amount    : ₹%.2f%n", total);
        System.out.println("   Thank you for shopping! 🎉");
        System.out.println("─".repeat(55) + "\n");
    }


}
