package prj5;

public class State {

    private String stateName;
    private int cases;
    private int population;

    /**
     * This is the constructor for the state class
     * 
     */
    public State(String stateName, int cases, int population) {
        this.stateName = stateName;
        this.cases = cases;
        this.population = population;
    }


    /**
     * This is the getter method for the stateName field
     * 
     * @return this method return the name of the state
     */
    public String getStateName() {
        return this.stateName;
    }


    /**
     * This is getter method for cases
     * 
     * @return will return the number of cases
     */
    public int getCases() {
        return this.cases;
    }


    /**
     * This is the getter method for the population of the state
     * 
     * @return will return the population of the state
     * 
     */
    public int getPopulation() {
        return this.population;
    }


    /**
     * This method will sort in alphabetical order
     */
    public void sortAlphabetically() {
        int count = 0;
        String[] array = new String[11];
        for (int i = 0; i < count; i++) // Holds each element
        {
            for (int j = i + 1; j < count; j++) // Check for remaining
                                                // elements
            {
                // compares each elements of the array to all the remaining
                // elements
                if (array[i].compareTo(array[j]) > 0) {
                    // swapping array elements
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    /**
     * This method will sort in CFR descending order
     */
    public void sortCFR() {
        int count = 0;
        String[] array = new String[11];
        for (int i = 0; i < count; i++) // Holds each element
        {
            for (int j = i + 1; j < count; j++) // Check for remaining
                                                // elements
            {
                // compares each elements of the array to all the remaining
                // elements
                if (array[i].compareTo(array[j]) == -1) {
                    // swapping array elements
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * toString method for the state class which will output
     */

}
