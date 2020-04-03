package threadsStudy;

import entity.ThreadOutput;

import java.util.concurrent.Callable;

public class WithCallable implements Callable<Integer> {

    private String spaceTab;
    private int loopsNumber;

    public WithCallable(String spaceTab, int loopsNumber) {

        this.spaceTab = spaceTab;
        this.loopsNumber = loopsNumber;
    }

    @Override
    public Integer call() throws Exception {

        return ThreadOutput.operate(getClass().getName(), loopsNumber, spaceTab);
    }
}
