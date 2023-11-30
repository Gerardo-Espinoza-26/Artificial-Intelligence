package Hands_On_11;

public class DataSet {
    
    private final int[][][] gates;

    public DataSet(int[][][] gates) {
        this.gates = gates;
    }
    
    public int[][][] getGates() {
        return gates;
    }

    public int getSize() {
        return gates.length;
    }
}