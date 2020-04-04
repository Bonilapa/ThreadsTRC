package threadsStudy;

import entity.ThreadOutput;

import java.util.LinkedList;
import java.util.Queue;

public class WithThread extends Thread {

    private String spaceTab;
    private int loopsNumber;

    public WithThread(String spaceTab, int loopsNumber) {

        this.spaceTab = spaceTab;
        this.loopsNumber = loopsNumber;
    }

    @Override
    public void run() {

        ThreadOutput.operate( loopsNumber, spaceTab, new LinkedList<>());
    }
}
