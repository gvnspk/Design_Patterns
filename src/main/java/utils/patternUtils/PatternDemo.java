package utils.patternUtils;

/**
 * ============================================================
 *  DEMO RUNNER — PatternDemo Interface
 * ============================================================
 *
 *  Every design pattern demo in this repository implements
 *  this interface. It gives Main.java a single, uniform way
 *  to invoke any pattern demo without knowing its internals.
 *
 *  Adding a new pattern demo = create a new class that
 *  implements this interface and register it in Main.
 *  Main.java itself NEVER needs to change its core logic.
 *
 *  Interestingly, this is also an application of the
 *  Strategy / Command pattern principle — each demo is a
 *  self-contained, interchangeable unit of behaviour.
 * ============================================================
 */

public interface PatternDemo {

    /**
     * Executes the pattern demonstration.
     * Each implementing class owns its own full demo flow.
     */
    void run ();

    /**
     * Short display name of the pattern.
     * e.g., "Strategy Pattern"
     */
    String patternName();

    /**
     * Category of the pattern.
     * e.g., "Behavioral", "Creational", "Structural"
     */
    String category();
}
