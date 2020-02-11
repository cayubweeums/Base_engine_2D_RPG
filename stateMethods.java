package States;

public class stateMethods {

    private static state currentState = null;

    public static void setState(state state){
        currentState = state;
    }

    public static state getCurrentState(){
        return currentState;
    }

}
