package Hands_on_8;

public class SLR {

    private final DataSet dataSetInstance;

    public SLR(DataSet dataSet) {
        this.dataSetInstance = dataSet;
    }

    public DataSet getDataSetInstance() {
        return dataSetInstance;
    }

    public void analyzeData() {
        printDataSet();
        printBetas();
        printPredictions();
        printCorrelationAndDetermination();
    }

    private void printDataSet() {
        int[][] data = dataSetInstance.getDataSet();
        System.out.println("========== Data Set ==========\t");
        System.out.println("==== Column X    Column Y ====");
        for (int[] rowData : data) {
            System.out.println("     " + rowData[0] + "          " + rowData[1]);
        }
        System.out.println("");
    }
    
    private double meanX(){
        int columnLength = dataSetInstance.getColumnLength();
        double sumX = dataSetInstance.getColumnSum(0);
        return sumX / columnLength;
    }
    
    private double meanY(){
        int columnLength = dataSetInstance.getColumnLength();
        double sumY = dataSetInstance.getColumnSum(1);
        return sumY / columnLength;
    }

    private double calculateSumOfProducts() {
        int[][] data = dataSetInstance.getDataSet();

        double sop = 0;

        for (int[] row : data) {
            sop += (row[0] - meanX()) * (row[1] - meanY());
        }
        
        return sop;
    }

    private double calculateSumOfSquares() {
        int[][] data = dataSetInstance.getDataSet();
 
        double soq = 0;

        for (int[] row : data) {
            soq += Math.pow((row[0] - meanX()), 2);
        }
        
        return soq;
    }

    private double calculateBeta0() {
        return meanY() - calculateBeta1() * meanX();
    }

    private double calculateBeta1() {
        return calculateSumOfProducts() / calculateSumOfSquares();
    }

    private void printBetas() {
        System.out.println("β1: " + calculateBeta1());
        System.out.println("β0: " + calculateBeta0());
        System.out.println("");
    }

    private void printPredictions() {

        int columnLength = dataSetInstance.getColumnLength();

        System.out.println("ŷ = β1 " + calculateBeta1() + " + β0 " + calculateBeta0() + " Xi");

        for (int i = 0; i < columnLength; i++) {
            double yPredict = calculateBeta0() + calculateBeta1() * dataSetInstance.getValue(i, 0);
            System.out.println((i + 1) + ": " + yPredict);
        }
        
        System.out.println("");
    }

    private double calculateCorrelationCoefficient() {
        int[][] data = dataSetInstance.getDataSet();

        double soqX = 0;
        double soqY = 0;

        for (int[] row : data) {
            soqX += Math.pow((row[0] - meanX()), 2);
            soqY += Math.pow((row[1] - meanY()), 2);
        }

        return calculateSumOfProducts() / (Math.sqrt(soqX) * Math.sqrt(soqY));
    }
     
    private double calculateCoefficientOfDetermination() {
        double correlationCoefficient = calculateCorrelationCoefficient();
        return Math.pow(correlationCoefficient, 2);
    }

    private void printCorrelationAndDetermination() {
        System.out.println("Coefficients of Correlation and Determination");
        System.out.println("Correlation Coefficient (r): " + calculateCorrelationCoefficient());
        System.out.println("Coefficient of Determination (r^2): " + calculateCoefficientOfDetermination());
        System.out.println("");
    }

    //    Ignore
//        private void printMeans() {
//            int sumX = dataSetInstance.getColumnSum(0);
//            int sumY = dataSetInstance.getColumnSum(1);
//            int columnLength = dataSetInstance.getColumnLength();
//    
//            System.out.println("===== Total Column Length: " + columnLength);
//            System.out.println("");
//    
//            System.out.println("===== Sum Of Column");
//            System.out.println("Total Sum Of X: " + sumX);
//            System.out.println("Total Sum Of Y: " + sumY);
//            System.out.println("");
//    
//            System.out.println("========== Mean of X and Y");
//    
//            double meanX = sumX / columnLength;
//            double meanY = sumY / columnLength;
//    
//            int meanX2 = (int) Math.floor(meanX);
//            int meanY2 = (int) Math.floor(meanY);
//            
//            System.out.println("Mean Of X: " + meanX2);
//            System.out.println("Mean Of Y: " + meanY2);
//            System.out.println("");
//    
//        }
    
    //    Ignore
        private void printSquaresAndProducts() {
            System.out.println("===== Calculate Products and Square");
            System.out.println("Sum Of Products:  " + calculateSumOfProducts());
            System.out.println("Sum Of Squares:  " + calculateSumOfSquares());
            System.out.println("");
        }
    
}
