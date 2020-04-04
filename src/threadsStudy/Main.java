

package threadsStudy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        executorPlusSynchronizedResultQueue();

        //executionWithExecutor();

        //standardThreadExecution();

    }
    /*
        Studied with
        https://www.youtube.com/watch?v=r3Tf8kYhbi0&list=PLY7PmJJFH5nSJMIRopDsFOOsPjNYUsVms&index=8
    */
    static private void executorPlusSynchronizedResultQueue() {

        int totalThreadNumber = 10;
        int concurrentThreadLimit = 4;

        LinkedList<Integer> resultThreadArray = new LinkedList<>();

        //pool for concurrent processed threads
        ExecutorService pool = Executors.newFixedThreadPool(concurrentThreadLimit);
        Queue<Future<Integer>> resultQueue = new LinkedList<>();

        int count = 0;


        int startedThreadsNumber = 0;//
        int finishedThreadNumber = 0;
        while(finishedThreadNumber < totalThreadNumber) {

            if (startedThreadsNumber < totalThreadNumber) {

                //thread difference variable
                StringBuilder stringBuilder = new StringBuilder();
                while(stringBuilder.length() < startedThreadsNumber){

                    stringBuilder.append('+');
                }

                // start threads and place future results into queue
                System.out.println("Start thread " + startedThreadsNumber);
                resultQueue.add(pool.submit(new WithCallable(stringBuilder.toString(), 15, resultThreadArray)));
                startedThreadsNumber++;
            }

            //wait for some thread will stop
            if(startedThreadsNumber >= concurrentThreadLimit){

                Future<Integer> future = resultQueue.poll();

                //structure to let finished threads leave the pool and let scheduler start other threads
                while(!future.isDone()){

                    //put thread into the end of the Thread Queue
                    resultQueue.add(future);

                    try {

                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    //and see whether another thread is done
                    future = resultQueue.poll();
                }

                try {
                    // ~thread join + get result
                    System.out.println("futureGet = " + future.get());
                    System.out.println("_____thread " + finishedThreadNumber + "finished");

                } catch (Exception e) {

                    e.printStackTrace();
                }

                finishedThreadNumber++;
            }
        }

        //executor is independant thread that can run even after
        //main process is ended. to prevent this we need to wait a thread end
        pool.shutdown();

        for (int i = 0; i < totalThreadNumber; i++) {

            System.out.println(resultThreadArray.get(i));
        }

    }

    static private void standardThreadExecution(){

        int loopsNumber = 4;

        //new WithThread("+++++", loopsNumber).start();

        //new Thread(new WithRunnable("_____", loopsNumber)).start();

        Callable<Integer> callable = new WithCallable("=====", loopsNumber, new LinkedList<>());
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
