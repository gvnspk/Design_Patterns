package utils.patternUtils;

import behavioral.strategy.ECommercePaymentSystem.payments.CardPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.CashOnDeliveryPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.NetBankingPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.UPIPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.cart.ShoppingCart;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardType;
import behavioral.strategy.ECommercePaymentSystem.payments.product.Product;
import utils.DemoUtils;

/**
 * ============================================================
 *  STRATEGY PATTERN — Self-Contained Demo Class
 * ============================================================
 *
 *  This class owns EVERYTHING related to demonstrating the
 *  Strategy Pattern. Main.java knows nothing about the details
 *  here — it only calls demo.run() via the PatternDemo interface.
 *
 *  To add more Strategy demos in the future, just add a new
 *  private method here and call it from run(). Main stays clean.
 * ============================================================
 */

public class StrategyPatternDemo implements PatternDemo {


    @Override
    public void run() {

        DemoUtils.printPatternBanner(patternName(), category(),
                "E-Commerce Payment Processing");

        ShoppingCart cart = buildCart();

        demoCreditCard(cart);
        demoUPI(cart);
        demoNetBanking(cart);
        demoCashOnDelivery(cart);
        demoNoStrategySet();
        demoInvalidUPI();

        printRecap();

    }


    @Override
    public String patternName() { return "Strategy Pattern"; }


    @Override
    public String category() { return "Behavioral"; }


    // ── Cart Setup ───────────────────────────────────────────

    private ShoppingCart buildCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Samsung Galaxy S24",  74999.00, 1));
        cart.addProduct(new Product("Wireless Earbuds",     3499.00, 1));
        cart.addProduct(new Product("Phone Case",            599.00, 2));
        return cart;
    }

    // ── Individual Demos ─────────────────────────────────────

    private void demoCreditCard(ShoppingCart cart) {
        DemoUtils.printDemoHeader("Demo 1 — Credit Card Payment");
        cart.setPaymentStrategy(
                new CardPayment(CardType.CREDIT, "4111 1111 1111 1234","Prasanna Kumar" ,"12/27", "456")
        );
        cart.checkout();
    }

    private void demoUPI(ShoppingCart cart) {
        DemoUtils.printDemoHeader("Demo 2 — UPI Payment  (Strategy swapped at runtime — zero cart changes!)");
        cart.setPaymentStrategy(new UPIPayment("prasanna@okicici", "GPay"));
        cart.checkout();
    }

    private void demoNetBanking(ShoppingCart cart) {
        DemoUtils.printDemoHeader("Demo 3 — Net Banking Payment");
        cart.setPaymentStrategy(
                new NetBankingPayment("HDFC Bank", "501001234567", "prasanna_k")
        );
        cart.checkout();
    }

    private void demoCashOnDelivery(ShoppingCart cart) {
        DemoUtils.printDemoHeader("Demo 4 — Cash On Delivery");
        cart.setPaymentStrategy(
                new CashOnDeliveryPayment("Prasanna Kumar",
                        "Flat 4B, Hitech City, Hyderabad - 500081")
        );
        cart.checkout();
    }

    private void demoNoStrategySet() {
        DemoUtils.printDemoHeader("Demo 5 — Edge Case: No Payment Strategy Set");
        ShoppingCart emptyStrategyCart = new ShoppingCart();
        emptyStrategyCart.addProduct(new Product("Laptop Stand", 1299.00, 1));
        emptyStrategyCart.checkout();   // Cart gracefully handles missing strategy
    }

    private void demoInvalidUPI() {
        DemoUtils.printDemoHeader("Demo 6 — Edge Case: Invalid UPI ID");
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop Stand", 1299.00, 1));
        cart.setPaymentStrategy(new UPIPayment("not-a-valid-upi", "PhonePe"));
        cart.checkout();               // UPI strategy handles its own validation
    }


    // ── Recap ────────────────────────────────────────────────

    private void printRecap() {
        DemoUtils.printPatternRecap(
                patternName(),
                "Define a family of algorithms, encapsulate each one, and make them interchangeable. " +
                        "Strategy lets the algorithm vary independently from the clients that use it.",
                new String[]{
                        "PaymentStrategy      → Strategy Interface",
                        "CreditCardPayment    → Concrete Strategy A",
                        "UPIPayment           → Concrete Strategy B",
                        "NetBankingPayment    → Concrete Strategy C",
                        "CashOnDeliveryPayment→ Concrete Strategy D",
                        "ShoppingCart         → Context (delegates to strategy)",
                        "Product              → Domain Model"
                },
                "ShoppingCart never changed across 4 payment methods. " +
                        "We only swapped the strategy — Open for extension, Closed for modification (OCP)!"
        );
    }
}
