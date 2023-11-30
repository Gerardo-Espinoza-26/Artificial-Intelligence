package Hands_On_2;

public class Nodes {

    public String[] NY = {"DEN", "TOR", "CHI"};
    public String[] CHI = {"DEN"};
    public String[] TOR = {"LA", "CALG"};
    public String[] DEN = {"URB", "HOW", "LA"};
    public String[] HOW = {"LA"};

    public String[] getDestinations(String city) {
        switch (city) {
            case "NY":
                return NY;
            case "DEN":
                return DEN;
            case "TOR":
                return TOR;
            case "CHI":
                return CHI;
            case "HOW":
                return HOW;
            default:
                return new String[0]; 
        }
    }
    
}
