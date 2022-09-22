package prj5;

import java.text.DecimalFormat;

public class CovidCalculator {
    
    private int deaths;
    private int cases;
    
    public CovidCalculator(int d, int c) {
        deaths = d;
        cases = c;
    }
    
    public double calculateRatio() {
        double ratio = (deaths / cases) * 100;
        DecimalFormat df2 = new DecimalFormat(" #,##0.00 '%'"); //This will add % symbol after the digits
        System.out.println(df2.format(ratio));
        return ratio;
    }
    
}
