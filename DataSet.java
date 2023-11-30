package Hands_on_8;

public class DataSet {
    
    private final int[][] dataSet;

    public DataSet(int[][] data) {
        this.dataSet = data;
    }

    public int getColumnLength() {
        return dataSet.length;
    }

    public int getColumnSum(int columnIndex) {
        int sum = 0;
        for (int[] row : dataSet) {
            sum += row[columnIndex];
        }
        return sum;
    }

    public int getValue(int row, int column) {
        return dataSet[row][column];
    }
    
    public int[][] getDataSet() {
        return dataSet;
    }
    
}
