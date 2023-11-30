package Hands_On_11;

public class Gate3 {

    private final DataSet dataSet;

    public Gate3(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public static final double learningRate = 0.05;
    public static final double[] initialWeights = {Math.random(), Math.random(), Math.random()};

    public double calculateWeightedSum(int[] data, double[] weights) {
        double weightedSum = 0;
        for (int i = 0; i < data.length; i++) {
            weightedSum += data[i] * weights[i];
        }
        return weightedSum;
    }

    public int applyActivationFunction(double weightedSum) {
        return (weightedSum > 1) ? 1 : 0;
    }

    public double[] adjustWeights(int[] data, double[] weights, double error) {
        double[] adjustedWeights = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            adjustedWeights[i] = learningRate * error * data[i] + weights[i];
        }
        return adjustedWeights;
    }

    public void Gate3() {
        int[][][] data = dataSet.getGates();
        double[] weights = initialWeights;
        boolean errorFlag = true;
        int epochNumber = 0;
        double error;
        double[] adjustedWeights;

        while (errorFlag) {
            printHeading(epochNumber++);
            errorFlag = false;
            error = 0;

            for (int i = 0; i < data.length; i++) {
                double weightedSum = calculateWeightedSum(data[i][0], weights);
                int result = applyActivationFunction(weightedSum);
                error = data[i][1][0] - result;

                if (error != 0) {
                    errorFlag = true;
                }

                adjustedWeights = adjustWeights(data[i][0], weights, error);
                printVector(data[i], weights, result, error, weightedSum, adjustedWeights);
                weights = adjustedWeights;
            }
        }
    }

    public void printHeading(int epochNumber) {
        System.out.println("\n=== Epoch # " + epochNumber + " =============================================================================================================");
        System.out.println("   w1   |   w2   |   w3   | x1 | x2 | x3 | Target | Result | error | Weighted sum | adjusted w1 | adjusted w2 | adjusted w3");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    public void printVector(int[][] data, double[] weights, int result, double error, double weightedSum, double[] adjustedWeights) {
        System.out.println(String.format(" %.2f   | %.2f   | %.2f   | %d  | %d  | %d  | %d      | %d      | %.2f  | %.2f         | %.2f        | %.2f        | %.2f",
                weights[0], weights[1], weights[2], data[0][0], data[0][1], data[0][2], data[1][0], result, error, weightedSum, adjustedWeights[0], adjustedWeights[1], adjustedWeights[2]));
    }
}
