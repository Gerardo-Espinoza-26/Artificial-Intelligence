package Hands_On_11;

public class Main {

    public static void main(String[] args) {
        
        int[][][] andGate2Data = {
            {{0, 0}, {0}},
            {{0, 1}, {0}},
            {{1, 0}, {0}},
            {{1, 1}, {1}}
        };

//        int[][][] orGate3Data = {
//            {{0, 0, 0}, {0}},
//            {{0, 0, 1}, {1}},
//            {{0, 1, 0}, {1}},
//            {{0, 1, 1}, {1}},
//            {{1, 0, 0}, {1}},
//            {{1, 0, 1}, {1}},
//            {{1, 1, 0}, {1}},
//            {{1, 1, 1}, {1}}
//        };

        DataSet andGate2DataSet = new DataSet(andGate2Data);
        Gate2 gate2 = new Gate2(andGate2DataSet);
        gate2.Gates2();
        
//        DataSet dataSet = new DataSet(orGate3Data);
//        Gate3 gate3 = new Gate3(dataSet);
//        gate3.Gate3();

    }

}
