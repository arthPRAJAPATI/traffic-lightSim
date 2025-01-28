package traffic;

import java.io.IOException;
import java.util.Scanner;

import static traffic.Main.*;

public class QueueThread extends Thread{

    static Scanner sc = new Scanner(System.in);
    private volatile int timeSinceStartup = 0;

    @Override
    public void run() {
        while(globalOptions == 3) {
            System.out.println("! " + ++timeSinceStartup + "s. have passed since system startup !");
            System.out.println("! Number of roads: " + roads + " !");
            System.out.println("! Interval: " + interval + " !");
            System.out.println("! Press \"Enter\" to open menu !");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
