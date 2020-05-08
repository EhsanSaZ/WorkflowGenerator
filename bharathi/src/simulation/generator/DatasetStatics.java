package simulation.generator;

import simulation.generator.shape.Shape;

import java.util.HashMap;
import java.util.Map;

public interface DatasetStatics {
    public static final int SMALL_WORKLOAD_SIZE = 1000;
    public static final int MEDIUM_WORKLOAD_SIZE = 2000;
    public static final int LARGE_WORKLOAD_SIZE = 4000;
    public static final int EXTRA_LARGE_WORKLOAD_SIZE = 8000;

    public static final String EXTRA_SMALL_WORKFLOW_SIZE = "30";
    public static final String SMALL_WORKFLOW_SIZE = "50";
    public static final String MEDIUM_WORKFLOW_SIZE = "100";
    public static final String LARGE_WORKFLOW_SIZE = "1000";

    public static final int CYBERSHAKE = 1;
    public static final int GENOME = 2;
    public static final int LIGO = 3;
    public static final int MONTAGE = 4;
    public static final int SIPHT = 5;
}