package simulation.generator.shape;

/**
 * @author Shishir Bharathi
 */
public interface Shape {
    public static final String DIVIDE = "DIVIDE";
    public static final String CONQUER = "CONQUER";
    public static final String DIVIDE_AND_CONQUER = "DIVIDE_AND_CONQUER";
    public static final String HOURGLASS = "HOURGLASS";
    public static final String MIRROR_HOURGLASS = "MIRROR_HOURGLASS";
    public static final String CONSTANT = "CONSTANT";

    /*
     * Determines the number of jobs at each level.
     */
    public int[] setupWidths(int numJobs, int depth);
}
