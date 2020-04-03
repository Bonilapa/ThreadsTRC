package threadsStudy;

import entity.ThreadOutput;

public class WithRunnable implements Runnable {

    private String spaceTab;
    private int loopsNumber;

    public WithRunnable(String spaceTab, int loopsNumber) {

        this.spaceTab = spaceTab;
        this.loopsNumber = loopsNumber;
    }

    @Override
    public void run() {
        ThreadOutput.operate(getClass().getName(), loopsNumber, spaceTab);
    }
}