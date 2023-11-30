package Hands_on_10;

public class Main {

    public static void main(String[] args){
        
        double data[][] = {
            {108, 95},
            {115, 96},
            {106, 95},
            {97, 97},
            {95, 93},
            {91, 94},
            {97, 95},
            {83, 93},
            {83, 92},
            {78, 86},
            {54, 73},
            {67, 80},
            {56, 65},
            {53, 69},
            {61, 77},
            {115, 96},
            {81, 87},
            {78, 89},
            {30, 60},
            {45, 63},
            {99, 95},
            {32, 61},
            {25, 55},
            {28, 56},
            {90, 94},
            {89, 93}
        };

        DataSet dataSet = new DataSet(data);
        dataSet.printDataSet(data);
        
        Lineal lineal = new Lineal(dataSet);
        lineal.analyzeData();
        
        Cuadratic cuadratic = new Cuadratic(dataSet);
        cuadratic.analyzeData();
        
        Cubic cubic = new Cubic(dataSet);
        cubic.analyzeData();
        
    }
    
}
