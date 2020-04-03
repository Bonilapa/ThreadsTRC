package threadsStudy;

import entity.ThreadOutput;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) {

        int loopsNumber = 4;

        new WithThread("+++++", loopsNumber).start();

        new Thread(new WithRunnable("_____", loopsNumber)).start();

        Callable<Integer> callable = new WithCallable("=====", loopsNumber);
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread threadCallable = new Thread(futureTask);
        threadCallable.start();

        try {

            threadCallable.join();
            System.out.println(futureTask.get());

        }catch(ExecutionException e){

            e.printStackTrace();

        }catch(InterruptedException e){

            e.printStackTrace();
        }
    }
}
