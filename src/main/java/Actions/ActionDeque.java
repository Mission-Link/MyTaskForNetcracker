package Actions;

import java.util.ArrayDeque;
import java.util.Deque;

public class ActionDeque {
    private Deque<Action> actionDeque;

    //constructor
    public ActionDeque() {
        actionDeque = new ArrayDeque<>();
    }

    //methods
    public void putAction(Action action){
        actionDeque.add(action);
    }



    public void printDeque(){
        for (Action tmp : actionDeque) {
//            System.out.println(tmp.getClass().toString());
            if (tmp.getClass().toString().endsWith("OpenURLAct")) {
                OpenURLAct action = (OpenURLAct) tmp;
                System.out.println(action);
            }
            else if (tmp.getClass().toString().endsWith("ClickAct")) {
                ClickAct action = (ClickAct) tmp;
                System.out.println(action);
            }
            else if (tmp.getClass().toString().endsWith("SetValueAct")) {
                SetValueAct action = (SetValueAct) tmp;
                System.out.println(action);
            }
            else if (tmp.getClass().toString().endsWith("ScreenshotAct")) {
                ScreenshotAct action = (ScreenshotAct) tmp;
                System.out.println(action);
            }
            else{
                System.out.println("Operation "+tmp.getActionName()+
                        " not supported yet");
            }
        }//end of for each loop
    }//end of method printDeque()

    public Deque<Action> getActionDeque() {
        return actionDeque;
    }
}
