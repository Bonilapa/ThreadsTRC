package entity;

import java.util.Random;

public  class ThreadOutput {

    public static int operate(int upperLimit, String spaceTab) {

        int r = 0;
        int result = 0;
        Random variable = new Random();

        while(r != 7){

            r = variable.nextInt(upperLimit+1);
            System.out.println(spaceTab + r);
            result++;
        }
        return result;

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
