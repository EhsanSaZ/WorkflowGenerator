package simulation.generator;

import simulation.generator.app.*;
import simulation.generator.util.Distribution;


import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DatasetGenerator {

    public static void run(Application app, File outfile, String... args) throws Exception {
        app.generateWorkflow(args);
        app.printWorkflow(new FileOutputStream(outfile));
    }

    public static void generate_workload(int workload_size, String saved_path, Distribution random_type, Map size_map, Distribution random_size) throws Exception {
        int i;
        File directory = new File(saved_path);
        if (!directory.exists()) {
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        for (i = 0; i < workload_size; i++) {
            int type = random_type.getInt();
            String size = (String) size_map.get(random_size.getInt());
            try {
                switch (type) {
                    case DatasetStatics.CYBERSHAKE:
                        run(new CyberShake(), new File(saved_path.concat(String.format("%d_CyberShake_%s.xml", i, size))), "-n", size);
//                        System.out.println("CyberShake");
                        break;
                    case DatasetStatics.GENOME:
                        ;
                        run(new Genome(), new File(saved_path.concat(String.format("%d_Epigenomics_%s.xml", i, size))), "-n", size);
//                        System.out.println("Gnome");
                        break;
                    case DatasetStatics.LIGO:
                        run(new LIGO(), new File(saved_path.concat(String.format("%d_LIGO_%s.xml", i, size))), "-n", size);
//                        System.out.println("Ligo");
                        break;
                    case DatasetStatics.MONTAGE:
                        run(new Montage(), new File(saved_path.concat(String.format("%d_Montage_%s.xml", i, size))), "-n", size);
//                        System.out.println("Montage");
                        break;
                    case DatasetStatics.SIPHT:
                        run(new SIPHT(), new File(saved_path.concat(String.format("%d_SIPHT_%s.xml", i, size))), "-n", size);
//                        System.out.println("Sipht");
                        break;
                    default:
                }
            } catch (Exception e) {
                System.out.println(i);
                System.out.println(type);
                System.out.println(size);
                System.out.println(e);
                i--;
            }

        }
    }

    public static void main(String[] args) throws Exception {


        // (0,5) generate 1, 2, 3, 4, 5 base on uniform distribution
        Distribution random_type_dist = Distribution.getUniformDistribution(0, 5);

//        workflow_type_map.get(1);

        Map<Integer, String> workflow_size_map = new HashMap<Integer, String>();
        workflow_size_map.put(1, DatasetStatics.EXTRA_SMALL_WORKFLOW_SIZE);
        workflow_size_map.put(2, DatasetStatics.SMALL_WORKFLOW_SIZE);
        workflow_size_map.put(3, DatasetStatics.MEDIUM_WORKFLOW_SIZE);
        workflow_size_map.put(4, DatasetStatics.LARGE_WORKFLOW_SIZE);
        // (0,4) generate 1, 2, 3, 4 base on uniform distribution
        Distribution random_size_dist = Distribution.getUniformDistribution(0, 4);

        String small_saved_path = "small workload\\";
        generate_workload(DatasetStatics.SMALL_WORKLOAD_SIZE, small_saved_path,
                random_type_dist, workflow_size_map, random_size_dist);

//        String medium_saved_path = "medium workload\\";
//        generate_workload(DatasetStatics.MEDIUM_WORKLOAD_SIZE, medium_saved_path,
//                random_type_dist, workflow_size_map, random_size_dist);

//        String large_saved_path = "large workload\\";
//        generate_workload(DatasetStatics.LARGE_WORKLOAD_SIZE, large_saved_path,
//                random_type_dist, workflow_size_map, random_size_dist);
    }
}
