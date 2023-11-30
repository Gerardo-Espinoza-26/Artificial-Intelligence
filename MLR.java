package hands_on_9;

public class MLR {

    private final DataSet dataSetInstance;
    private double[] predictions;

    public MLR(DataSet dataSet) {
        this.dataSetInstance = dataSet;
    }

    public DataSet getDataSetInstance() {
        return dataSetInstance;
    }

    public void analyzeData() {
        printDataSet();
        printBetas();
        printPredict();
        printR2();
    }

    private void printDataSet() {
        double[][] n = dataSetInstance.getDataSet();
        System.out.println("========== Data Set ==========\t");
        System.out.println("==== Column X    Column X2    ==== Column Y ====");
        for (double[] rowData : n) {
            System.out.println("     " + rowData[0] + "          " + rowData[1] + "          " + rowData[2]);
        }
        System.out.println("");
    }

    private double meanx1(double[][] data) {
        int filas = data.length;
        double meanx1 = 0;
        for (int i = 0; i < filas; i++) {
            meanx1 += data[i][0];
        }
        return meanx1 /= filas;
    }

    private double meanx2(double[][] data) {
        int filas = data.length;
        double meanx2 = 0;
        for (int i = 0; i < filas; i++) {
            meanx2 += data[i][1];
        }
        return meanx2 /= filas;
    }

    private double meany(double[][] data) {
        int filas = data.length;
        double meany = 0;
        for (int i = 0; i < filas; i++) {
            meany += data[i][2];
        }
        return meany /= filas;
    }

    private double soqx1(double[][] data) {
        int fila = data.length;
        double soqx1 = 0;
        for (int i = 0; i < fila; i++) {
            soqx1 += Math.pow((data[i][0] - meanx1(data)), 2);
        }
        return soqx1;
    }

    private double soqx2(double[][] data) {
        int fila = data.length;
        double soqx2 = 0;
        for (int i = 0; i < fila; i++) {
            soqx2 += Math.pow((data[i][1] - meanx2(data)), 2);
        }
        return soqx2;
    }

    private double sopx1y(double[][] data) {
        int fila = data.length;
        double sopx1y = 0;
        for (int i = 0; i < fila; i++) {
            sopx1y += (data[i][0] - meanx1(data)) * (data[i][2] - meany(data));
        }
        return sopx1y;
    }

    private double sopx2y(double[][] data) {
        int fila = data.length;
        double sopx2y = 0;
        for (int i = 0; i < fila; i++) {
            sopx2y += (data[i][1] - meanx2(data)) * (data[i][2] - meany(data));
        }
        return sopx2y;
    }

    private double sopx1x2(double[][] data) {
        int fila = data.length;
        double sopx1x2 = 0;
        for (int i = 0; i < fila; i++) {
            sopx1x2 += (data[i][0] - meanx1(data)) * (data[i][1] - meanx2(data));
        }
        return sopx1x2;
    }

    private double b1(double[][] data) {
        double b1 = (sopx1y(data) * soqx2(data) - sopx1x2(data) * sopx2y(data)) / (soqx1(data) * soqx2(data) - sopx1x2(data) * sopx1x2(data));
        return b1;
    }

    private double b2(double[][] data) {
        double b2 = (sopx2y(data) * soqx1(data) - sopx1x2(data) * sopx1y(data)) / (soqx1(data) * soqx2(data) - sopx1x2(data) * sopx1x2(data));
        return b2;
    }

    private double b0(double[][] data) {
        double b0 = meany(data) - (b1(data) * meanx1(data)) - ((b2(data) * meanx2(data)));
        return b0;
    }

    private void printBetas() {
        System.out.println("Beta1: " + b1(dataSetInstance.getDataSet()));
        System.out.println("Beta2: " + b2(dataSetInstance.getDataSet()));
        System.out.println("Beta0: " + b0(dataSetInstance.getDataSet()));
        System.out.println("");
    }

    private double[] predict(double[][] data) {
        int n = data.length;
        double[] predict = new double[n];
        for (int i = 0; i < n; i++) {
            predict[i] = b0(data) + (b1(data) * data[i][0]) + (b2(data) * data[i][1]);
            System.out.println((i + 1) + ": " + predict[i]);
        }
        return predict;
    }

    private void printPredict(){
        System.out.println("ŷ = β0 " + b0(dataSetInstance.getDataSet()) + " + β1 " + b1(dataSetInstance.getDataSet()) + " + β2 " + b2(dataSetInstance.getDataSet()));
        System.out.println("");
        predictions = predict(dataSetInstance.getDataSet());
        System.out.println("");
    }
    
    private double calculateR2(double[][] data, double[] predictions) {
        int n = data.length;

        double totalSumOfSquares = 0;
        for (int i = 0; i < n; i++) {
            totalSumOfSquares += Math.pow((data[i][2] - meany(data)), 2);
        }

        double sumOfSquaredResiduals = 0;
        for (int i = 0; i < n; i++) {
            sumOfSquaredResiduals += Math.pow((data[i][2] - predictions[i]), 2);
        }

        double rSquared = 1 - (sumOfSquaredResiduals / totalSumOfSquares);

        return rSquared;
    }

    private double calculateAdjustedR2(double rSquared, int n, int k) {
        return 1 - ((1 - rSquared) * (n - 1) / (n - k - 1));
    }

    private void printR2(){
        System.out.println("R²: " + calculateR2(dataSetInstance.getDataSet(), predictions));
        int numPredictors = 2;
        System.out.println("Ajusted R²: " + calculateAdjustedR2(calculateR2(dataSetInstance.getDataSet(), predictions), dataSetInstance.getDataSet().length, numPredictors));
    }
    
}
