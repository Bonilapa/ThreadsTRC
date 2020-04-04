package threadsStudy;

import entity.ThreadOutput;

import java.util.LinkedList;

public class WithRunnable implements Runnable {

    private String spaceTab;
    private int loopsNumber;

    public WithRunnable(String spaceTab, int loopsNumber) {

        this.spaceTab = spaceTab;
        this.loopsNumber = loopsNumber;
    }

    @Override
    public void run() {
        ThreadOutput.operate(loopsNumber, spaceTab, new LinkedList<>());
    }
}