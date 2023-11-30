package Hands_on_10;

public class Lineal {

    private final DataSet dataSetInstance;
    private final double[] yPredict;

    public Lineal(DataSet dataSet) {
        this.dataSetInstance = dataSet;
        this.yPredict = new double[dataSet.getDataSet().length];
    }

    public DataSet getDataSetInstance() {
        return dataSetInstance;
    }

    public void analyzeData() {
        System.out.println("==================================================");
        System.out.println("Lineal predictive model");
        System.out.println("");
        printBetas();
        printPrediction(dataSetInstance.getDataSet());
        printR2();
    }

    private double meanX(double[][] data) {
        int n = data.length;
        double meanX = 0;

        for (int i = 0; i < n; i++) {
            meanX += data[i][0];
        }

        return meanX /= n;
    }

    private double meanY(double[][] data) {
        int n = data.length;
        double meanY = 0;

        for (int i = 0; i < n; i++) {
            meanY += data[i][1];
        }

        return meanY /= n;
    }

    private double b1(double[][] data) {
        int n = data.length;
        double beta1 = 0;
        double sumSquareDiffX = 0;

        for (int i = 0; i < n; i++) {
            beta1 += (data[i][0] - meanX(data)) * (data[i][1] - meanY(data));
            sumSquareDiffX += Math.pow((data[i][0] - meanX(data)), 2);
        }

        return beta1 /= sumSquareDiffX;
    }

    private double b0(double[][] data) {
        return meanY(data) - (b1(data) * meanX(data));
    }

    private void printBetas() {
        System.out.println("Beta1: " + b1(dataSetInstance.getDataSet()));
        System.out.println("Beta0: " + b0(dataSetInstance.getDataSet()));
        System.out.println("β0 = " + meanY(dataSetInstance.getDataSet()) + " - " + b1(dataSetInstance.getDataSet()) + " ⋅ " + meanX(dataSetInstance.getDataSet()));
        System.out.println("");
    }

    private double sumSquareDiffResidual(double[][] data) {
        int n = data.length;
        double sumSquareDiffResidual = 0;
        for (int i = 0; i < n; i++) {
            sumSquareDiffResidual += Math.pow((data[i][1] - yPredict[i]), 2);
         }
        return sumSquareDiffResidual;
    }
    
    private double sumSquareDiffTotal(double[][] data) {
        int n = data.length;
        double sumSquareDiffTotal = 0;
        for (int i = 0; i < n; i++) {
            sumSquareDiffTotal += Math.pow((data[i][1] - meanY(data)), 2);
         }
        return sumSquareDiffTotal;
    }

    private void printPrediction(double[][] data) {
        System.out.println("y = β0 + β1 ⋅ x");
        System.out.println("");

        int n = data.length;

        for (int i = 0; i < n; i++) {
            yPredict[i] = b0(data) + (b1(data) * data[i][0]);
            System.out.println((i + 1) + ": " + yPredict[i]);
        }
        System.out.println("");
    }

    private void printR2() {
        double r2 = 1 - (sumSquareDiffResidual(dataSetInstance.getDataSet()) / sumSquareDiffTotal(dataSetInstance.getDataSet()));
        System.out.println("R²: " + r2);
        System.out.println("");
    }

}
