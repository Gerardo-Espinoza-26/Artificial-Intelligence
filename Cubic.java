package Hands_on_10;

public class Cubic {
    
    private final DataSet dataSetInstance;
    private final double[] yPredict;

    Cubic(DataSet dataSet) {
        this.dataSetInstance = dataSet;
        this.yPredict = new double[dataSet.getDataSet().length];
    }
    
    public DataSet getDataSetInstance() {
        return dataSetInstance;
    }
    
    public void analyzeData() {
        System.out.println("==================================================");
        System.out.println("Cubic predictive model");
        System.out.println("");
        printBetas(dataSetInstance.getDataSet());
        predict(dataSetInstance.getDataSet());
        printR2(dataSetInstance.getDataSet());
    }
    
    private double sumX(double[][] data){
        int n = data.length;
        double sumX = 0;
        for (int i = 0; i < n; i++) {
            double x = data[i][0];
            sumX += x;
        }
        return sumX;
    }
    
    private double sumY(double[][] data){
        int n = data.length;
        double sumY = 0;
        for (int i = 0; i < n; i++) {
            double y = data[i][1];
            sumY += y;
        }
        return sumY;
    }
    
    private double sumX2(double[][] data){
        int n = data.length;
        double sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX2 += Math.pow(data[i][0], 2);
        }
        return sumX2;
    }
    
    private double sumX3(double[][] data){
        int n = data.length;
        double sumX3 = 0;
        for (int i = 0; i < n; i++) {
            sumX3 += Math.pow(data[i][0], 3);
        }
        return sumX3;
    }
    
    private double sumX4(double[][] data){
        int n = data.length;
        double sumX4 = 0;
        for (int i = 0; i < n; i++) {
            sumX4 += Math.pow(data[i][0], 4);
        }
        return sumX4;
    }
    
    private double sumX5(double[][] data){
        int n = data.length;
        double sumX5 = 0;
        for (int i = 0; i < n; i++) {
            sumX5 += Math.pow(data[i][0], 5);
        }
        return sumX5;
    }
    
    private double sumX6(double[][] data){
        int n = data.length;
        double sumX6 = 0;
        for (int i = 0; i < n; i++) {
            sumX6 += Math.pow(data[i][0], 6);
        }
        return sumX6;
    }
    
    private double sumXY(double[][] data){
        int n = data.length;
        double sumXY = 0;
        for (int i = 0; i < n; i++) {
            sumXY += data[i][0] * data[i][1];
        }
        return sumXY;
    }
    
    private double sumX2Y(double[][] data){
        int n = data.length;
        double sumX2Y = 0;
        for (int i = 0; i < n; i++) {
            sumX2Y += Math.pow(data[i][0], 2) * data[i][1];
        }
        return sumX2Y;
    }
    
    private double sumX3Y(double[][] data){
        int n = data.length;
        double sumX3Y = 0;
        for (int i = 0; i < n; i++) {
            sumX3Y += Math.pow(data[i][0], 3) * data[i][1];
        }
        return sumX3Y;
    }
    
    private double meanY(double[][] data){
        int n = data.length;
        double meany = 0;
        
        for (int i = 0; i < n; i++) {
            meany += data[i][1];
        }

        return meany / n;
    }
    
    private double determinant(double[][] data){
        int n = data.length;
        
        return (sumX3(data) * sumX3(data) * sumX3(data) * sumX3(data))
                - (sumX3(data) * sumX3(data) * sumX2(data) * sumX4(data))
                - (sumX3(data) * sumX2(data) * sumX4(data) * sumX3(data))
                + (sumX3(data) * sumX2(data) * sumX2(data) * sumX5(data))
                + (sumX3(data) * sumX(data) * sumX4(data) * sumX4(data))
                - (sumX3(data) * sumX(data) * sumX3(data) * sumX5(data))
                - (sumX2(data) * sumX4(data) * sumX3(data) * sumX3(data))
                + (sumX2(data) * sumX4(data) * sumX2(data) * sumX4(data))
                + (sumX2(data) * sumX2(data) * sumX5(data) * sumX3(data))
                - (sumX2(data) * sumX2(data) * sumX2(data) * sumX6(data))
                - (sumX2(data) * sumX(data) * sumX5(data) * sumX4(data))
                + (sumX2(data) * sumX(data) * sumX3(data) * sumX6(data))
                + (sumX(data) * sumX4(data) * sumX4(data) * sumX3(data))
                - (sumX(data) * sumX4(data) * sumX2(data) * sumX5(data))
                - (sumX(data) * sumX3(data) * sumX5(data) * sumX3(data))
                + (sumX(data) * sumX3(data) * sumX2(data) * sumX6(data))
                + (sumX(data) * sumX(data) * sumX5(data) * sumX5(data))
                - (sumX(data) * sumX(data) * sumX4(data) * sumX6(data))
                - (n * sumX4(data) * sumX4(data) * sumX4(data))
                + (n * sumX4(data) * sumX3(data) * sumX5(data))
                + (n * sumX3(data) * sumX5(data) * sumX4(data))
                - (n * sumX3(data) * sumX3(data) * sumX6(data))
                - (n * sumX2(data) * sumX5(data) * sumX5(data))
                + (n * sumX2(data) * sumX4(data) * sumX6(data));
    }
 
    private double calculateB3(double[][] data){
        int n = data.length;
        return (sumY(data) * sumX3(data) * sumX3(data) * sumX3(data))
                - (sumY(data) * sumX3(data) * sumX2(data) * sumX4(data))
                - (sumY(data) * sumX2(data) * sumX4(data) * sumX3(data))
                + (sumY(data) * sumX2(data) * sumX2(data) * sumX5(data))
                + (sumY(data) * sumX(data) * sumX4(data) * sumX4(data))
                - (sumY(data) * sumX(data) * sumX3(data) * sumX5(data))
                - (sumX2(data) * sumXY(data) * sumX3(data) * sumX3(data))
                + (sumX2(data) * sumXY(data) * sumX2(data) * sumX4(data))
                + (sumX2(data) * sumX2(data) * sumX2Y(data) * sumX3(data))
                - (sumX2(data) * sumX2(data) * sumX2(data) * sumX3Y(data))
                - (sumX2(data) * sumX(data) * sumX2Y(data) * sumX4(data))
                + (sumX2(data) * sumX(data) * sumX3(data) * sumX3Y(data))
                + (sumX(data) * sumXY(data) * sumX4(data) * sumX3(data))
                - (sumX(data) * sumXY(data) * sumX2(data) * sumX5(data))
                - (sumX(data) * sumX3(data) * sumX2Y(data) * sumX3(data))
                + (sumX(data) * sumX3(data) * sumX2(data) * sumX3Y(data))
                + (sumX(data) * sumX(data) * sumX2Y(data) * sumX5(data))
                - (sumX(data) * sumX(data) * sumX4(data) * sumX3Y(data))
                - (n * sumXY(data) * sumX4(data) * sumX4(data))
                + (n * sumXY(data) * sumX3(data) * sumX5(data))
                + (n * sumX3(data) * sumX2Y(data) * sumX4(data))
                - (n * sumX3(data) * sumX3(data) * sumX3Y(data))
                - (n * sumX2(data) * sumX2Y(data) * sumX5(data))
                + (n * sumX2(data) * sumX4(data) * sumX3Y(data));
    }
    
    private double calculateB2(double[][] data){
        int n = data.length;
        return (sumX3(data) * sumXY(data) * sumX3(data) * sumX3(data))
                - (sumX3(data) * sumXY(data) * sumX4(data) * sumX2(data))
                - (sumX3(data) * sumX2(data) * sumX2Y(data) * sumX3(data))
                + (sumX3(data) * sumX2(data) * sumX2(data) * sumX3Y(data))
                + (sumX3(data) * sumX(data) * sumX2Y(data) * sumX4(data))
                - (sumX3(data) * sumX(data) * sumX3(data) * sumX3Y(data))
                - (sumY(data) * sumX4(data) * sumX3(data) * sumX3(data))
                + (sumY(data) * sumX4(data) * sumX2(data) * sumX4(data))
                + (sumY(data) * sumX2(data) * sumX5(data) * sumX3(data))
                - (sumY(data) * sumX2(data) * sumX2(data) * sumX6(data))
                - (sumY(data) * sumX(data) * sumX5(data) * sumX4(data))
                + (sumY(data) * sumX(data) * sumX3(data) * sumX6(data))
                + (sumX(data) * sumX4(data) * sumX2Y(data) * sumX3(data))
                - (sumX(data) * sumX4(data) * sumX2(data) * sumX3Y(data))
                - (sumX(data) * sumXY(data) * sumX5(data) * sumX3(data))
                + (sumX(data) * sumXY(data) * sumX6(data) * sumX2(data))
                + (sumX(data) * sumX(data) * sumX5(data) * sumX3Y(data))
                - (sumX(data) * sumX(data) * sumX2Y(data) * sumX6(data))
                - (n * sumX4(data) * sumX2Y(data) * sumX4(data))
                + (n * sumX4(data) * sumX3(data) * sumX3Y(data))
                + (n * sumXY(data) * sumX5(data) * sumX4(data))
                - (n * sumXY(data) * sumX3(data) * sumX6(data))
                - (n * sumX2(data) * sumX5(data) * sumX3Y(data))
                + (n * sumX2(data) * sumX2Y(data) * sumX6(data));
    }
    
    private double calculateB1(double[][] data){
        int n = data.length;
        return (sumX3(data) * sumX3(data) * sumX2Y(data) * sumX3(data))
                - (sumX3(data) * sumX3(data) * sumX3Y(data) * sumX2(data))
                - (sumX3(data) * sumXY(data) * sumX4(data) * sumX3(data))
                + (sumX3(data) * sumXY(data) * sumX2(data) * sumX5(data))
                + (sumX3(data) * sumX(data) * sumX4(data) * sumX3Y(data))
                - (sumX3(data) * sumX(data) * sumX2Y(data) * sumX5(data))
                - (sumX2(data) * sumX4(data) * sumX2Y(data) * sumX3(data))
                + (sumX2(data) * sumX4(data) * sumX2(data) * sumX3Y(data))
                + (sumX2(data) * sumXY(data) * sumX5(data) * sumX3(data))
                - (sumX2(data) * sumXY(data) * sumX2(data) * sumX6(data))
                - (sumX2(data) * sumX(data) * sumX5(data) * sumX3Y(data))
                + (sumX2(data) * sumX(data) * sumX2Y(data) * sumX6(data))
                + (sumY(data) * sumX4(data) * sumX4(data) * sumX3(data))
                - (sumY(data) * sumX4(data) * sumX2(data) * sumX5(data))
                - (sumY(data) * sumX3(data) * sumX5(data) * sumX3(data))
                + (sumY(data) * sumX3(data) * sumX2(data) * sumX6(data))
                + (sumY(data) * sumX(data) * sumX5(data) * sumX5(data))
                - (sumY(data) * sumX(data) * sumX4(data) * sumX6(data))
                - (n * sumX4(data) * sumX4(data) * sumX3Y(data))
                + (n * sumX4(data) * sumX2Y(data) * sumX5(data))
                + (n * sumX3(data) * sumX5(data) * sumX3Y(data))
                - (n * sumX3(data) * sumX2Y(data) * sumX6(data))
                - (n * sumXY(data) * sumX5(data) * sumX5(data))
                + (n * sumXY(data) * sumX4(data) * sumX6(data));
    }
    
    private double calculateB0(double[][] data){
        return (sumX3(data) * sumX3(data) * sumX3(data) * sumX3Y(data))
                - (sumX3(data) * sumX3(data) * sumX2Y(data) * sumX4(data))
                - (sumX3(data) * sumX2(data) * sumX4(data) * sumX3Y(data))
                + (sumX3(data) * sumX2(data) * sumX2Y(data) * sumX5(data))
                + (sumX3(data) * sumXY(data) * sumX4(data) * sumX4(data))
                - (sumX3(data) * sumXY(data) * sumX3(data) * sumX5(data))
                - (sumX2(data) * sumX4(data) * sumX3(data) * sumX3Y(data))
                + (sumX2(data) * sumX4(data) * sumX2Y(data) * sumX4(data))
                + (sumX2(data) * sumX2(data) * sumX5(data) * sumX3Y(data))
                - (sumX2(data) * sumX2(data) * sumX2Y(data) * sumX6(data))
                - (sumX2(data) * sumXY(data) * sumX5(data) * sumX4(data))
                + (sumX2(data) * sumXY(data) * sumX3(data) * sumX6(data))
                + (sumX(data) * sumX4(data) * sumX4(data) * sumX3Y(data))
                - (sumX(data) * sumX4(data) * sumX2Y(data) * sumX5(data))
                - (sumX(data) * sumX3(data) * sumX5(data) * sumX3Y(data))
                + (sumX(data) * sumX3(data) * sumX2Y(data) * sumX6(data))
                + (sumX(data) * sumXY(data) * sumX5(data) * sumX5(data))
                - (sumX(data) * sumXY(data) * sumX4(data) * sumX6(data))
                - (sumY(data) * sumX4(data) * sumX4(data) * sumX4(data))
                + (sumY(data) * sumX4(data) * sumX3(data) * sumX5(data))
                + (sumY(data) * sumX3(data) * sumX5(data) * sumX4(data))
                - (sumY(data) * sumX3(data) * sumX3(data) * sumX6(data))
                - (sumY(data) * sumX2(data) * sumX5(data) * sumX5(data))
                + (sumY(data) * sumX2(data) * sumX4(data) * sumX6(data));
    }
    
    private double b3(double[][] data){
        return calculateB3(data) / determinant(data);
    }
    
    private double b2(double[][] data){
        return calculateB2(data) / determinant(data);
    }
    
    private double b1(double[][] data){
        return calculateB1(data) / determinant(data);
    }
    
    private double b0(double[][] data){
        return calculateB0(data) / determinant(data);
    }
    
    private void printBetas(double[][] data){
        System.out.println("B0: " + b0(data));
        System.out.println("B1: " + b1(data));
        System.out.println("B2: " + b2(data));
        System.out.println("B3: " + b3(data));
        System.out.println("");
    }
     
    private void predict(double[][] data){
        System.out.println("Y = β0 " + b0(data) + " + β1 " + b1(data) + " x + β2 " + b2(data) + " x² + β3 " + b3(data) + " x³");
        System.out.println("");
        
        int n = data.length;
        
        for (int i = 0; i < n; i++) {
            yPredict[i] = b0(data) + b1(data) * (data[i][0]) + b2(data) * (Math.pow(data[i][0], 2)) + b3(data) * (Math.pow(data[i][0], 3));
            System.out.println((i + 1) + ": " + yPredict[i]);
        }
        System.out.println("");
        
    }

    private double totalSumOfSquares(double[][] data){
        double totalSumOfSquares = 0;

        int n = data.length;
        
        for (int i = 0; i < n; i++) {
            totalSumOfSquares += Math.pow((data[i][1] - meanY(data)), 2);
        }
        
        return totalSumOfSquares;
    }
    
    private double sumOfSquaredResidual(double[][] data){
        double sumOfSquaredResiduals = 0;
        
        int n = data.length;
        
        for (int i = 0; i < n; i++) {
            sumOfSquaredResiduals += Math.pow((data[i][1] - yPredict[i]), 2);
        }
        
        return sumOfSquaredResiduals;
        
    }
   
    private void printR2(double[][] data){
        
        double rSquared = 1 - (sumOfSquaredResidual(data) / totalSumOfSquares(data));

        System.out.println("R²: " + rSquared);
        
        System.out.println("");
    }
    
}
