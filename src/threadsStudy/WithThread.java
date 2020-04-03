package threadsStudy;

import entity.ThreadOutput;

public class WithThread extends Thread {

    private String spaceTab;
    private int loopsNumber;

    public WithThread(String spaceTab, int loopsNumber) {

        this.spaceTab = spaceTab;
        this.loopsNumber = loopsNumber;
    }

    @Override
    public void run() {

        ThreadOutput.operate(getClass().getName(), loopsNumber, spaceTab);
    }
}
