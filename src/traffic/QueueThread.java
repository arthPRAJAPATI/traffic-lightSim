package traffic;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static traffic.Main.*;

public class QueueThread extends Thread{

    static Scanner sc = new Scanner(System.in);
    private volatile int timeSinceStartup = 0;
    private CircularQueue circularQueue = new CircularQueue(Integer.parseInt(roads));

    @Override
    public void run() {
        while(true) {
            if(globalOptions == 3) {
                System.out.println("! " + timeSinceStartup + "s. have passed since system startup !");
                System.out.println("! Number of roads: " + roads + " !");
                System.out.println("! Interval: " + interval + " !");
                circularQueue.show();
                System.out.println("! Press \"Enter\" to open menu !");

            }  else if (globalOptions == 1) {
                System.out.print("Input road name: ");
                String roadToAdd = sc.next();
                circularQueue.enqueue(roadToAdd);
            } else if (globalOptions == 2) {
                circularQueue.dequeue();
            }

            try {
                ++timeSinceStartup;
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void clearConsole() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException e) {}
    }
}
