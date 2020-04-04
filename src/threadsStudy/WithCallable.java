package threadsStudy;

import entity.ThreadOutput;

import java.util.Queue;
import java.util.concurrent.Callable;

public class WithCallable implements Callable<Integer> {

    private String spaceTab;
    private int upperLimit;
    //loops number before random variable == 7
    private int result;
    private Queue<Integer> resultThreadArray;

    public int getResult() {

        return result;
    }

    public WithCallable(String spaceTab, int upperLimit, Queue<Integer> resultThreadArray) {

        this.spaceTab = spaceTab;
        this.upperLimit = upperLimit;
        this.resultThreadArray = resultThreadArray;
    }

    @Override
    public Integer call() throws Exception {

        //result = ThreadOutput.operate(getClass().getName(), upperLimit, spaceTab);



        return ThreadOutput.operate(upperLimit, spaceTab, resultThreadArray);
    }
}
