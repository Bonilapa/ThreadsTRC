package threadsStudy;

import entity.ThreadOutput;

import java.util.Random;
import java.util.concurrent.Callable;

public class WithCallable implements Callable<Integer> {

    private String spaceTab;
    private int upperLimit;
    //loops number before random variable == 7
    private int result;

    public int getResult() {

        return result;
    }

    public WithCallable(String spaceTab, int upperLimit) {

        this.spaceTab = spaceTab;
        this.upperLimit = upperLimit;
    }

    @Override
    public Integer call() throws Exception {

        //result = ThreadOutput.operate(getClass().getName(), upperLimit, spaceTab);

        return ThreadOutput.operate(upperLimit, spaceTab);
    }
}
