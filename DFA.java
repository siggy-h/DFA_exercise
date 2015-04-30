package SiggyH;
import java.util.Scanner;
import java.io.*;



public class DFA {

    // Fields
    protected int currentState = 0;     //keeps track of current state during string processing
    protected String description;       // what strings the dfa accepts
    protected int numStates;            // the number of states in the DFA
    protected String alphabet;
    protected int start;                // start state
    protected State[] stateArray;       // collection of states...


    // Methods

    // displayAlphabet() - displays the DFA's alphabet
    // Input: none        Output: none
    public void display() {
        System.out.println( description );
        System.out.println("\nDFA\'s Alphabet = " + alphabet);
    }




    // processInput() - Wrapper - processes the input string, resets currentState
    //                  to start state,  returns true for accept
    // Input: String        Output: none
    public boolean processInput(String inputString) {

        if(inputString == null)  // if char is null - check if state 0 is accept
            return stateArray[start].isAcceptState();

        boolean accept;

        accept = process(inputString);
        reset();
        return  accept;
    }





    // process() - processes the input string, returns true for accept
    // Input: String        Output: none
    protected boolean process(String inputString) {

        int aChar;

        for(int i = 0; i < inputString.length(); ++i) {
            aChar = inputString.charAt(i);  // get char
            int charIndex = alphabet.indexOf(aChar);

            if( charIndex == -1 ) {  // else check if in alphabet
                return false;
            }
            else
                currentState = stateArray[currentState].getTransition(charIndex);
        }

        return stateArray[currentState].isAcceptState();
    }





    // loadFile() - loads a file
    // Input: String        Output: none
    public int loadFile(String fileName) {

        InputStream in; // source file
        in = getFileInputStream(fileName);

        if(in == null)
            return 0;

        Scanner scanning = new Scanner(in).useDelimiter(",|\n");
        description = scanning.next();
        numStates = scanning.nextInt();     // get number of states

        alphabet = scanning.next();         // get alphabet

        stateArray = new State[numStates];  // *create the array & initialize
        for (int i = 0; i < numStates; i++) {
            stateArray[i] = new State( alphabet.length() );
        }

        start = scanning.nextInt();
        currentState = start;       // setting the currentStart to start...

        String acceptState = scanning.next();
        int acceptNum;

        while( !acceptState.equalsIgnoreCase("#") ) {
            acceptNum = Integer.parseInt(acceptState);
            stateArray[acceptNum].setAcceptState(); // Set the accept states

            acceptState = scanning.next();

        }

        // set up the transitions
        int aStateLocation = -1;
        int trans1 = -1;
        int trans2 = -1;

        while (scanning.hasNext()) {

            aStateLocation = scanning.nextInt();
            trans1 = scanning.nextInt();
            trans2 = scanning.nextInt();
            stateArray[aStateLocation].setTransitions(0, trans1);
            stateArray[aStateLocation].setTransitions(1, trans2);
        }

        return 1;
    }




    // getFileInputStream(): Returns an input stream that gets data from a named file
    // Input: String        Output: none
    protected static InputStream getFileInputStream(String fileName) {

        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            inputStream = null;
        }

        return inputStream;
    }




    // reset(): sets the currentState back to the start
    // Input: none        Output: none
    public void reset() {
        currentState = start;
    }




} // end of DFA




