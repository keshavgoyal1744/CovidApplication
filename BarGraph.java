package prj5;

public class BarGraph {
    
    private String state;
    private String raceName;
    private double fatalityRatio;

    public BarGraph(String ste, String race, double ratio) {
        state = ste;
        raceName = race;
        fatalityRatio = ratio;
    }
    
    public void setState(String otherState) {
        state = otherState;
    }

    public String getState() {
        return state;
    }
    
    public void setFatalityRatio(double ratio) {
        fatalityRatio = ratio;
    }

    public double getFatalityRatio() {
        return fatalityRatio;
    }

    public String getRaceName() {
        return raceName;
    }
    
    //use this in State to set the race name
    public void setRaceName(String name) {
        raceName = name;
    }
    
    
}