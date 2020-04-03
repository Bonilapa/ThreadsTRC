package entity;

public  class ThreadOutput {

    public static int operate(String className, int temp, String spaceTab) {

        while (temp != 0) {

            temp = out(className, temp, spaceTab) - 1;
        }

        return temp;

    }

    ///int is faster than Integer and Integer is needed only for callable
    ///so most of work would work better with primitive
    private static int out(String className, int temp, String spaceTab){

        System.out.println(className + spaceTab + temp);

        try {

            Thread.sleep(500);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        return temp;
    }
}
