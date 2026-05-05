package org;

import utils.patternUtils.PatternDemo;
import utils.patternUtils.StrategyPatternDemo;

import java.util.List;

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

    /**
     * Registry of all pattern demos.
     * Add new patterns here as you implement them.
     *
     * ✅ = Implemented    ⬜ = Coming Soon
     */
    private static final List<PatternDemo> DEMOS = List.of(

            // ── Behavioral ──────────────────────────────────────
            new StrategyPatternDemo()           // ✅ Strategy

            // new ObserverPatternDemo()         // ⬜ Observer
            // new CommandPatternDemo()          // ⬜ Command
            // new IteratorPatternDemo()         // ⬜ Iterator
            // new MediatorPatternDemo()         // ⬜ Mediator

            // ── Creational ──────────────────────────────────────
            // new SingletonPatternDemo()        // ⬜ Singleton
            // new FactoryMethodPatternDemo()    // ⬜ Factory Method
            // new AbstractFactoryPatternDemo()  // ⬜ Abstract Factory
            // new BuilderPatternDemo()          // ⬜ Builder

            // ── Structural ──────────────────────────────────────
            // new DecoratorPatternDemo()        // ⬜ Decorator
            // new AdapterPatternDemo()          // ⬜ Adapter
            // new ProxyPatternDemo()            // ⬜ Proxy
    );


    public static void main(String[] args) {

        printAppBanner();

        for (PatternDemo demo : DEMOS) {
            demo.run();
        }

        printCompletionSummary();
    }

    // ── App-level print helpers ───────────────────────────────

    private static void printAppBanner() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║         🧩  DESIGN PATTERNS — DEMO RUNNER           ║");
        System.out.println("║              github.com/gvnspk/Design_Patterns      ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║   Running %d pattern demo(s) %-24s║%n",
                DEMOS.size(), "");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    private static void printCompletionSummary() {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║             ✅  All Demos Completed!                ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        DEMOS.forEach(d ->
                System.out.printf("║   [%s] %-44s║%n", d.category().charAt(0), d.patternName())
        );
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }



}
