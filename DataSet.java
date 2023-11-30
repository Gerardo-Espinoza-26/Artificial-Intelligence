package Hands_on_10;

public class DataSet {
    
    private final double[][] dataSet;

    public DataSet(double[][] dataSet) {
        this.dataSet = dataSet;
    }
    
    public double[][] getDataSet() {
        return dataSet;
    }
    
    public void printDataSet(double[][] data) {

        int fila = data.length;

        System.out.println("========== Data Set ==========\t");
        System.out.println("==== Column X    Column Y ====");
        for (int i = 0; i < fila; i++) {
            System.out.println("     " + data[i][0] + "          " + data[i][1]);
        }
        System.out.println("");
    }
    
}
