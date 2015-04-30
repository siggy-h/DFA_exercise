package SiggyH;


public class State {

    // Fields
    protected boolean acceptState = false;  // true if accept state
    protected int []transitions;

    
    // Methods

    // Constructor - takes int for number of transitions/ connections
    // Input: int       Output: none
    public State(int lengthOfEdges) {

        transitions = new int[lengthOfEdges];
        for (int i = 0; i < lengthOfEdges; ++i) {
            transitions[i] = -1;    // setting to -1 so it's easier to spot errors
        }

    }




    // setAcceptState() - sets the state's accept to true
    // Input: none       Output: none
    public void setAcceptState() {
        acceptState = true;
    }




    // setTransitions() - adds an index of state to transition to on a specific char index from the Alphabet.
    // Input: int, int       Output: none
    public void setTransitions(int index, int transitionTo) {
        transitions[index] = transitionTo;
    }




    // getTransition() - returns the int @ index
    // (this is the vertex this state is connected to on a specific char index from the Alphabet.
    // Input: int       Output: int
    public int getTransition(int index) {

        return transitions[index];
    }




    // isAcceptState() - returns true if this state is an accept state
    // Input: none       Output: boolean
    public boolean isAcceptState() {
        return acceptState;
    }


    
} // end of State
