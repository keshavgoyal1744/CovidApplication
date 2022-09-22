package prj5;

/**
 * 
 * @author Keshav
 * @version 4/20/2022
 */
public class Input {

    public static void main(String[] args) throws Exception {
        if (args != null) {
            new ReadFile(args[0]);
        }
        else {
            new ReadFile("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }

}
