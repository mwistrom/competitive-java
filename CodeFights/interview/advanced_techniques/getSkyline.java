package interview.advanced_techniques;

import java.util.*;

public class getSkyline {

    static class Pit {
        Double height;
        Double time;
        boolean start;

        Pit(Double h, Double t, boolean s) {
            height = h;
            time = t;
            start = s;
        }
    }

    static double[][] getSkyline(double[][] buildings) {
        ArrayList<Double[]> ans = new ArrayList<>();
        PriorityQueue<Pit> event = new PriorityQueue<>(10, new Comparator<Pit>() {
            public int compare(Pit p1, Pit p2) {
                return p1.time.compareTo(p2.time);
            }
        });
        TreeMap<Double, Integer> bound = new TreeMap<>();

        for (double[] b : buildings) {
            event.add(new Pit(b[2], b[0], true));
            event.add(new Pit(b[2], (b[0] + b[1]), false));
        }
        //event.add(new Pit(0.0, 0.0, true));
        //event.add(new Pit(0.0, 2000000010.0, false));

        Double height = 0.0;
        int count = 0;

        final double SMALL = 0.000001;

        while (event.size() > 0) {
            //cout << "event size:  " << event.size() << " counter: " << count++ <<  endl;
            Pit e = event.remove();
            boolean cont = bound.containsKey(e.height);
            if (e.start) {
                //System.out.println("Add Height: " + e.height);
                if (cont) {
                    bound.put(e.height, bound.get(e.height) + 1);
                } else {
                    bound.put(e.height, 1);
                }
            } else {
                //System.out.println("Remove Height: " + e.height);
                if (cont && bound.get(e.height) == 1) {
                    bound.remove(e.height);
                } else {
                    bound.put(e.height, bound.get(e.height) - 1);
                }
            }
            if (event.size() > 0 && Math.abs(event.peek().time - e.time) < SMALL)
                continue;
//            else
//                System.out.println(event.peek().time - e.time);
            if (bound.size() == 0) {
                height = 0.0;
                Double[] ansLine = new Double[2];
                ansLine[0] = 0.0;
                ansLine[1] = e.time;
                ans.add(ansLine);
                //System.out.println("  0.0 Add: " + ansLine[0]+"  \t"+ansLine[1]);
                continue;
            }
            Map.Entry<Double, Integer> max = bound.lastEntry();
            if ( Math.abs(max.getKey() - height) > SMALL) {
                height = max.getKey();
                Double[] ansLine = new Double[2];
                ansLine[0] = height;
                ansLine[1] = e.time;
                ans.add(ansLine);
                //System.out.println("  Add: " + ansLine[0] + "  \t" + ansLine[1]);
            }
        }

        double[][] ret = new double[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i)[1] == 2000000010.0)
                continue;
            ret[i][1] = ans.get(i)[0];
            ret[i][0] = ans.get(i)[1];
        }

        return ret;
    }

    public static void main(String[] args) {
//        double[][] buildings = {{0., 10., 4.},
//                {1., 9., 5.},
//                {2., 8., 3.},
//                {3., 7., 2.},
//                {5., 10., 2.}};

//    vector<vector<double>> buildings = {{2, 3, 6},
//                                        {3, 4, 6}};


        //buildings = inRand();

        double[][]  buildings = {{2.0, 5.0, 8.0},
                {5.0, 5.0, 7.0},
                {7.0, 3.0, 8.0},
                {10.0, 12.0, 9.0},
                {11.0, 14.0, 5.0},
                {13.0, 9.0, 9.0},
                {18.0, 9.0, 7.0},
                {23.0, 2.0, 6.0},
                {25.0, 5.0, 9.0},
                {30.0, 1.0, 8.0}};


        for (int i = 0; i < buildings.length - 1; i++) {
            if (buildings[i][0] < buildings[i + 1][0])
                continue;
            System.exit(0);
        }

        double[][] ret = getSkyline(buildings);

        int[][] buildings_int = new int[buildings.length][3];
        for (int i = 0; i < buildings.length; i++) {
            buildings_int[i][0] = (int) (buildings[i][0] + 0.1);
            buildings_int[i][1] = (int) (buildings[i][1] + 0.1);
            buildings_int[i][2] = (int) (buildings[i][2] + 0.1);
            //System.out.println(i + "  " + buildings[i][0] + "   " + buildings[i][1] + "   " + buildings[i][2]);
        }
        // List<int[]> ret2 = getSkyline2(buildings_int);

        for (int i = 0; i < ret.length; i++) {
//            if (i < ret.length - 1) {
//                if (ret[i][0] >= ret[i + 1][0]) {
//                    System.out.println("*********");
//                }
//            }
            System.out.println(ret[i][0] + "  \t" + ret[i][1]);

        }

//        for (int[] r : ret2) {
//            System.out.println(r[0] + "  \t" + r[1]);
//        }
    }

    private static double[][] inRand() {
        Random rand = new Random(System.currentTimeMillis());

        int N = 10;

        double[][] ret = new double[N][3];
        double x = 0.0;

        for (int b = 0; b < N; b++) {
            x = x + (double) (rand.nextInt(5) + 1);
            ret[b][0] = x;
            ret[b][1] = (double) (rand.nextInt(20) + 1);
            ret[b][2] = (double) (rand.nextInt(5) + 5);
        }
        return ret;
    }
}
