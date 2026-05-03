package org.example;


import behavioral.strategy.ECommercePaymentSystem.payments.CardPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.NetBankingPayment;
import behavioral.strategy.ECommercePaymentSystem.payments.cart.ShoppingCart;
import behavioral.strategy.ECommercePaymentSystem.payments.enums.CardType;
import behavioral.strategy.ECommercePaymentSystem.payments.product.Product;

/**
 * ============================================================
 *  Design Patterns — Central Demo Runner
 * ============================================================
 *
 *  This is the single entry point for ALL design pattern demos
 *  in this repository.
 *
 *  Convention:
 *  ───────────
 *  As new patterns are implemented, add a new runXxxPatternDemo()
 *  method below and call it from main(). This keeps demonstrations
 *  isolated, readable, and easy to toggle on/off.
 *
 *  Current Demos:
 *  ──────────────
 *  ✅ Behavioral → Strategy Pattern  (Payment Processing)
 *  🔜 More patterns coming...
 */

public class Main {
    public static void main(String[] args) {


        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║         🧩  DESIGN PATTERNS — DEMO RUNNER           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ── Behavioral Patterns ──────────────────────────────
        runStrategyPatternDemo();

        // ── Structural Patterns (coming soon) ────────────────
        // runAdapterPatternDemo();
        // runDecoratorPatternDemo();

        // ── Creational Patterns (coming soon) ────────────────
        // runSingletonPatternDemo();
        // runBuilderPatternDemo();



    }

    // ════════════════════════════════════════════════════════
    //  BEHAVIORAL → STRATEGY PATTERN DEMO
    // ════════════════════════════════════════════════════════

    /**
     * Demonstrates the Strategy Pattern using a Shopping Cart
     * that supports multiple interchangeable payment methods.
     *
     * What this shows:
     * ────────────────
     * 1. Same cart, different payment strategies plugged in.
     * 2. Runtime strategy swap (user changes payment method).
     * 3. Adding items and checking out with each method.
     */
    private static void runStrategyPatternDemo() {

        printPatternBanner("STRATEGY PATTERN", "Behavioral",
                "Payment Processing System");

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Samsung Galaxy S24",  74999.00, 1));
        cart.addProduct(new Product("Wireless Earbuds",    3499.00,  1));

        // ─────────────────────────────────────────────────────
        //  DEMO 1: Pay with Credit Card
        //  Strategy gets injected → cart delegates to it
        // ─────────────────────────────────────────────────────
        printDemoHeader("Demo 1 — Credit Card Payment");
        cart.setPaymentStrategy(
                new CardPayment(
                        CardType.CREDIT,
                        "4111 1111 1111 1234",
                        "Prasanna Kumar",
                        "12/27",
                        "456"
                )
        );
        cart.checkout();

        // ─────────────────────────────────────────────────────
        //  DEMO 3: Swap to Net Banking
        // ─────────────────────────────────────────────────────
        printDemoHeader("Demo 3 — Net Banking Payment");
        cart.setPaymentStrategy(
                new NetBankingPayment("HDFC Bank", 142801542833L, "prasanna_k")
        );
        cart.checkout();

        printPatternSummary();

    }

    // ══════════════════════════════════════════════════════════
    //  UTILITY — Print helpers for clean console output
    // ══════════════════════════════════════════════════════════

    private static void printPatternBanner(String patternName,
                                           String category,
                                           String domain) {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.printf( "│  📌 %-50s│%n", patternName);
        System.out.printf( "│     Category : %-38s│%n", category);
        System.out.printf( "│     Domain   : %-38s│%n", domain);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    private static void printDemoHeader(String title) {
        System.out.println("\n▶  " + title);
        System.out.println("   " + "·".repeat(50));
    }

    private static void printPatternSummary() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║              📘 STRATEGY PATTERN — RECAP            ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Intent  : Define a family of algorithms, encapsulate║");
        System.out.println("║            each one, make them interchangeable.      ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Roles in this demo:                                 ║");
        System.out.println("║   • PaymentStrategy     → Strategy Interface         ║");
        System.out.println("║   • CreditCardPayment   → Concrete Strategy A        ║");
        System.out.println("║   • UPIPayment          → Concrete Strategy B        ║");
        System.out.println("║   • NetBankingPayment   → Concrete Strategy C        ║");
        System.out.println("║   • CashOnDelivery      → Concrete Strategy D        ║");
        System.out.println("║   • ShoppingCart        → Context (uses strategy)    ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Key Takeaway:                                       ║");
        System.out.println("║   ShoppingCart never changed — we just swapped the   ║");
        System.out.println("║   strategy. Open for extension, closed for change!   ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
    }

}
