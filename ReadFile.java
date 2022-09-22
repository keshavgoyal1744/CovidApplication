package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * 
 * @author Keshav Goyal
 * @version 4/18/2022
 *
 */
public class ReadFile {
    /**
     * These are the private fields for the class
     */
    private int[] cases;
    private int[] deaths;
    private String[] states;
    private SinglyLinkedList<BarGraph> barGraphs;
    public static final int ARRAY_LENGTH = 5;
    public static final String[] RACES = {"white", "black", "latina", "asian", "other"};

    /**
     * This is the default constructor for the class
     */
    public ReadFile(String dataFile) throws Exception {
        cases = caseData(dataFile);
        deaths = deathData(dataFile);
        states = stateData(dataFile);
        barGraphs = convertToGraph();
    }

    /*
     * private String[] readDataFile(String fileName) throws Exception {
     * String[] data = new String[11];
     * Scanner file = new Scanner(new File(fileName));
     * for (int i = 0; i < 11 && file.hasNextLine(); i++) {
     * String[] param = file.nextLine().split(",");
     * if (param.length != 11) {
     * throw new ParseException(fileName, i + 1);
     * }
     * int whiteCases = Integer.valueOf(param[1]);
     * int blackCases = Integer.valueOf(param[2]);
     * int latinaCases = Integer.valueOf(param[3]);
     * int asianCases = Integer.valueOf(param[4]);
     * int otherCases = Integer.valueOf(param[5]);
     * int whiteDeaths = Integer.valueOf(param[6]);
     * int blackDeaths = Integer.valueOf(param[7]);
     * int latinaDeaths = Integer.valueOf(param[8]);
     * int asianDeaths = Integer.valueOf(param[9]);
     * int otherDeaths = Integer.valueOf(param[10]);
     * 
     * // String[i] = new String[param[0], whiteCases];
     * // data = new String[param[0]];
     * 
     * }
     * file.close();
     * 
     * 
     * return reader;
     * }
     */
    
    private int[] caseData(String fileName) throws FileNotFoundException, ParseException {
        int[] caseData = new int[5];
        Scanner file = new Scanner(new File(fileName));
        
        while(file.hasNextLine()) {
            String[] param = file.nextLine().split(",");
            if (param.length != 11) {
                throw new ParseException(fileName, 1);
            }
            
            int count = 1;
            for (int j = 0; j <= ARRAY_LENGTH; j++) {
                caseData[j] = Integer.valueOf(param[count]);
                count++;
            }
        }
        file.close();
        return caseData;
    }
    
    private int[] deathData(String fileName) throws FileNotFoundException, ParseException {
        int[] deathData = new int[5];
        Scanner file = new Scanner(new File(fileName));
        
        while(file.hasNextLine()) {
            String[] param = file.nextLine().split(",");
            if (param.length != 11) {
                throw new ParseException(fileName, 1);
            }
            
            int count2 = 6;
            for (int k = 0; k <= ARRAY_LENGTH; k++) {
                deathData[k] = Integer.valueOf(param[count2]);
                count2++;
            }
        }
        file.close();
        return deathData;
    }
    
    private String[] stateData(String fileName) throws FileNotFoundException, ParseException {
        String[] stateData = new String[5];
        Scanner file = new Scanner(new File(fileName));
        
        while(file.hasNextLine()) {
            int count = 0;
            String[] param = file.nextLine().split(",");
            if (param.length != 11) {
                throw new ParseException(fileName, 1);
            }
            stateData[count] = param[0];
            count++;
        }
        file.close();
        return stateData;
    }
    
    private SinglyLinkedList<BarGraph> convertToGraph() {
        SinglyLinkedList<BarGraph> graphs = new SinglyLinkedList<BarGraph>();
        for (int i = 0; i <= ARRAY_LENGTH; i++) {
            CovidCalculator calc = new CovidCalculator(cases[i], deaths[i]);
            graphs.add(new BarGraph(states[i], RACES[i], calc.calculateRatio()));
        }
        return graphs;
    }
 }

