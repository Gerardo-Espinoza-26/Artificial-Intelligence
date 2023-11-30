package Artificial_Neural_Network;

public class Neural {

    public static void main(String[] args) {
        double x[] = {1, 4, 5};
        double t[] = {0.1, 0.05};
        double b[] = {0.5, 0.5};
        double w[] = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 0.1};

        double a = 0.05;

        System.out.println("DataSet x");
        printDataSet(x);
        System.out.println("");
        System.out.println("DataSet t");
        printDataSet(t);
        System.out.println("");
        System.out.println("Bias b");
        printDataSet(b);
        System.out.println("");
        System.out.println("Width w");
        printDataSet(w);
        System.out.println("");
        System.out.println("Learing Rate a");
        System.out.println(a);
        System.out.println("");
        System.out.println("Zh1");
        System.out.println(zh1(w, x, b));
        System.out.println("");
        System.out.println("Zh2");
        System.out.println(zh2(w, x, b));
        System.out.println("");
        System.out.println("h1");
        System.out.println(h1(zh1(w, x, b)));
        System.out.println("");
        System.out.println("h2");
        System.out.println(h2(zh2(w, x, b)));
        System.out.println("");
        System.out.println("zo1");
        System.out.println(zo1(w, zh1(w, x, b), zh2(w, x, b), b));
        System.out.println("");
        System.out.println("zo2");
        System.out.println(zo2(w, zh1(w, x, b), zh2(w, x, b), b));
        System.out.println("");
        System.out.println("o1");
        System.out.println(o1(zo1(w, zh1(w, x, b), zh2(w, x, b), b)));
        System.out.println("");
        System.out.println("o2");
        System.out.println(o2(zo2(w, zh1(w, x, b), zh2(w, x, b), b)));
        System.out.println("");
        System.out.println("∂E/∂o1");
        System.out.println(delta_error_o1(zo1(w, zh1(w, x, b), zh2(w, x, b), b), t));
        System.out.println("");
        System.out.println("∂E/∂o2");
        System.out.println(delta_error_o2(zo2(w, zh1(w, x, b), zh2(w, x, b), b), t));
        System.out.println("");
        System.out.println("∂E/∂w7");
        System.out.println(delta_error_w7(zo1(w, zh1(w, x, b), zh2(w, x, b), b), w, x, b, t));
        System.out.println("");
        System.out.println("∂E/∂w9");
        System.out.println(delta_error_w9(w, x, b, t, zo1(w, zh1(w, x, b), zh2(w, x, b), b), zh2(w, x, b)));
        System.out.println("");
        System.out.println("∂E/∂b2");
        System.out.println(delta_error_b2(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), t));
        System.out.println("");
        System.out.println("∂E/∂h1");
        System.out.println(delta_error_h1(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), t, w));
        System.out.println("");
        System.out.println("∂E/∂w1");
        System.out.println(delta_error_w1(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b), t, w));
        System.out.println("");
        System.out.println("∂E/∂w3");
        System.out.println(delta_error_w3(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b), t, w, x));
        System.out.println("");
        System.out.println("∂E/∂w5");
        System.out.println(delta_error_w5(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b), t, w, x));
        System.out.println("");
        System.out.println("∂E/∂b1");
        System.out.println(delta_error_b1(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), t, w));
        System.out.println("");
        System.out.println("w1: " + w1(w, t, a, zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b)));
        System.out.println("");
        System.out.println("w3: " + w3(w, t, x, a, zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b)));
        System.out.println("");
        System.out.println("w5: " + w5(w, t, x, a, zo1(w, zh1(w, x, b), zh2(w, x, b), b), zo2(w, zh1(w, x, b), zh2(w, x, b), b), zh1(w, x, b)));
        System.out.println("");
        System.out.println("w7: " + w7(zo1(w, zh1(w, x, b), zh2(w, x, b), b), x, b, t, w, a));
        System.out.println("");
        System.out.println("w9: " + w9(zo1(w, zh1(w, x, b), zh2(w, x, b), b), zh2(w, x, b), x, b, t, w, a));
        System.out.println("");

    }

    public static void printDataSet(double data[]) {
        int n = data.length;

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static double zh1(double w[], double x[], double b[]) {

        double zh1 = w[0] * x[0] + w[2] * x[1] + w[4] * x[2] + b[0];

        return zh1;

    }

    public static double zh2(double w[], double x[], double b[]) {

        double zh2 = w[1] * x[0] + w[3] * x[1] + w[5] * x[2] + b[0];

        return zh2;

    }

    public static double sigmoidal(double aux) {
        double sigmoidal = 1 / (1 + Math.pow(Math.E, -aux));
        return sigmoidal;
    }

    public static double h1(double zh1) {
        double h1 = sigmoidal(zh1);
        return h1;
    }

    public static double h2(double zh2) {
        double h2 = sigmoidal(zh2);
        return h2;
    }

    public static double zo1(double w[], double zh1, double zh2, double b[]) {
        double zo1 = w[6] * h1(zh1) + w[8] * h2(zh2) + b[1];

        return zo1;
    }

    public static double zo2(double w[], double zh1, double zh2, double b[]) {
        double zo1 = w[7] * h1(zh1) + w[9] * h2(zh2) + b[1];

        return zo1;
    }

    public static double o1(double zo1) {
        double o1 = sigmoidal(zo1);
        return o1;
    }

    public static double o2(double zo2) {
        double o2 = sigmoidal(zo2);
        return o2;
    }

    public static double delta_error_o1(double zo1, double t[]) {
        double delta_error_o1 = o1(zo1) - t[0];
        return delta_error_o1;
    }

    public static double delta_error_o2(double zo2, double t[]) {
        double delta_error_o2 = o2(zo2) - t[1];
        return delta_error_o2;
    }

    public static double delta_error_zo1(double zo1) {
        double delta_error_zo1 = (o1(zo1) * (1 - o1(zo1)));
        return delta_error_zo1;
    }

    public static double delta_error_zo2(double zo2) {
        double delta_error_zo2 = (o2(zo2) * (1 - o2(zo2)));
        return delta_error_zo2;
    }

    public static double delta_error_w7(double zo1, double w[], double x[], double b[], double t[]) {
        double delta_error_w7 = (o1(zo1) - t[0]) * delta_error_zo1(zo1) * h1(zh1(w, x, b));
        return delta_error_w7;
    }

    public static double delta_error_w9(double w[], double x[], double b[], double t[], double zo1, double zh2) {
        double delta_error_w9 = delta_error_o1(zo1(w, zh1(w, x, b), zh2(w, x, b), b), t) * delta_error_zo1(zo1) * h2(zh2);
        return delta_error_w9;
    }

    public static double delta_error_b2(double zo1, double zo2, double t[]) {
        double delta_error_b2 = delta_error_o1(zo1, t) * delta_error_zo1(zo1) * 1 + delta_error_o2(zo2, t) * delta_error_zo2(zo2) * 1;
        return delta_error_b2;
    }

    public static double delta_error_h1(double zo1, double zo2, double t[], double w[]) {
        double delta_error_h1 = delta_error_o1(zo1, t) * delta_error_zo1(zo1) * w[6] + delta_error_o2(zo2, t) * delta_error_zo2(zo2) * w[7];
        return delta_error_h1;
    }

    public static double delta_error_zh1(double zh1) {
        double delta_error_zh1 = h1(zh1) * (1 - h1(zh1));
        return delta_error_zh1;
    }

    public static double delta_error_zh2(double zh2) {
        double delta_error_zh2 = 1 - sigmoidal(zh2);
        return delta_error_zh2;
    }

    public static double delta_error_w1(double zo1, double zo2, double zh1, double t[], double w[]) {
        double delta_error_w1 = delta_error_h1(zo1, zo2, t, w) * delta_error_zh1(zh1) * 1;
        return delta_error_w1;
    }

    public static double delta_error_w3(double zo1, double zo2, double zh1, double t[], double w[], double x[]) {
        double delta_error_w3 = delta_error_h1(zo1, zo2, t, w) * delta_error_zh1(zh1) * x[1];
        return delta_error_w3;
    }

    public static double delta_error_w5(double zo1, double zo2, double zh1, double t[], double w[], double x[]) {
        double delta_error_w5 = delta_error_h1(zo1, zo2, t, w) * delta_error_zh1(zh1) * x[2];
        return delta_error_w5;
    }

    public static double delta_error_b1(double zo1, double zo2, double t[], double w[]) {
        double delta_error_b1 = delta_error_o1(zo1, t) * delta_error_zo1(zo1) * w[6] * 1 + delta_error_o2(zo2, t) * delta_error_zo2(zo2) * w[9] * 1;
        return delta_error_b1;
    }

    public static double w1(double w[], double t[], double a, double zo1, double zo2, double zh1) {
        double w1 = w[0] - a * delta_error_w1(zo1, zo2, zh1, t, w);
        return w1;
    }

    public static double w3(double w[], double t[], double x[], double a, double zo1, double zo2, double zh1) {
        double w3 = w[2] - a * delta_error_w3(zo1, zo2, zh1, t, w, x);
        return w3;
    }

    public static double w5(double w[], double t[], double x[], double a, double zo1, double zo2, double zh1) {
        double w5 = w[4] - a * delta_error_w5(zo1, zo2, zh1, t, w, x);
        return w5;
    }

    public static double w7(double zo1, double x[], double b[], double t[], double w[], double a) {
        double w7 = w[6] - a * delta_error_w7(zo1, w, x, b, t);
        return w7;
    }

    public static double w9(double zo1, double zh2, double x[], double b[], double t[], double w[], double a) {
        double w9 = w[8] - a * delta_error_w9(w, x, b, t, zo1, zh2);
        return w9;
    }

}