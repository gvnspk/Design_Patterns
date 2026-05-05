package utils;

/**
 * ============================================================
 *  DEMO RUNNER — DemoUtils
 * ============================================================
 *
 *  A shared utility class for all pattern demo print helpers.
 *  Centralising these here means:
 *   - Every demo has consistent, uniform formatting
 *   - No duplicated print code across demo classes
 *   - Easy to restyle all output from one place
 * ============================================================
 */

public class DemoUtils {

    private DemoUtils() {
        // Utility class — no instantiation needed
    }

    /**
     * Prints the header banner when a pattern demo starts.
     *
     * Example output:
     * ┌──────────────────────────────────────────────────────┐
     * │  📌 STRATEGY PATTERN                                 │
     * │     Category : Behavioral                            │
     * │     Domain   : Payment Processing System             │
     * └──────────────────────────────────────────────────────┘
     */
    public static void printPatternBanner(String patternName,
                                          String category,
                                          String domain) {
        System.out.println("\n┌─────────────────────────────────────────────────────┐");
        System.out.printf( "│  📌 %-50s│%n", patternName);
        System.out.printf( "│     Category : %-38s│%n", category);
        System.out.printf( "│     Domain   : %-38s│%n", domain);
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    /**
     * Prints a numbered demo sub-section header.
     *
     * Example output:
     * ▶  Demo 1 — Credit Card Payment
     *    ··················································
     */
    public static void printDemoHeader(String title) {
        System.out.println("\n▶  " + title);
        System.out.println("   " + "·".repeat(50));
    }

    /**
     * Prints a recap box at the end of a pattern demo.
     * Pass in the roles array as: { "RoleName → Role description", ... }
     *
     * Example output:
     * ╔══════════════════════════════════════════════════════╗
     * ║        📘  STRATEGY PATTERN — RECAP                 ║
     * ...
     * ╚══════════════════════════════════════════════════════╝
     */
    public static void printPatternRecap(String patternName,
                                         String intent,
                                         String[] roles,
                                         String keyTakeaway) {
        String title = "📘  " + patternName + " — RECAP";
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.printf( "║  %-53s║%n", title);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Intent:                                             ║");
        // Word-wrap intent to 51 chars
        wrapPrint(intent, 51);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Roles in this demo:                                 ║");
        for (String role : roles) {
            System.out.printf("║   • %-50s║%n", role);
        }
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Key Takeaway:                                       ║");
        wrapPrint(keyTakeaway, 51);
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
    }

    /**
     * Prints a divider line — useful between major demo sections.
     */
    public static void printDivider() {
        System.out.println("\n" + "═".repeat(55) + "\n");
    }

    // ── Private helpers ──────────────────────────────────────

    private static void wrapPrint(String text, int maxWidth) {
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder("║   ");
        for (String word : words) {
            if (line.length() + word.length() + 1 > maxWidth + 4) {
                System.out.printf("%-56s║%n", line.toString());
                line = new StringBuilder("║   ").append(word).append(" ");
            } else {
                line.append(word).append(" ");
            }
        }
        if (line.length() > 4) {
            System.out.printf("%-56s║%n", line.toString());
        }
    }
}
