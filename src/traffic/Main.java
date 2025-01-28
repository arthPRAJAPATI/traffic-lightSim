package traffic;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static String roads = null;
  static String interval = null;
  static int globalOptions = 0;
  public static void main(String[] args) throws IOException, InterruptedException {
    String Begin = """ 
            Welcome to the traffic management system!
            Input the number of roads:""";
    System.out.print(Begin);
    getRoads();
    System.out.print("Input the interval:");
    getIntervals();
    clearConsole();

    Thread thread = new QueueThread();
    thread.start();
    thread.setName("QueueThread");

    String menu = """
            Menu:
            1. Add road
            2. Delete road
            3. Open System
            0. Quit
            """;
    boolean toContinue = true;
    do {
      System.out.print(menu);
      int option = 0;
      try {
        option = Integer.parseInt(sc.nextLine());
      }catch (Exception e) {
        System.out.println("incorrect option");
        try {
          System.in.read();
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        clearConsole();
        continue;
      }
      switch (option) {
        case 0:
          System.out.println("Bye!");
          toContinue = false;
          break;
        case 1:
          System.out.println("Road added");
//          roads++;
          break;
        case 2:
          System.out.println("Road deleted");
//          roads--;
          break;
        case 3:
          globalOptions = 3;
          break;
        default:
          System.out.println("Incorrect option");

          break;
      }
      if(toContinue) {
        try {
          System.in.read();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        clearConsole();
      }

    } while(toContinue);

  }

  public static void getRoads() {
    validateRoads();

  }
  public static void getIntervals() {
    interval = sc.nextLine();
    validateIntervals(interval);
  }

  public static void validateIntervals(String value) {
    try {
      int parsedValue = Integer.parseInt(value);
      if(parsedValue <= 0) {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Error! Incorrect Input. Try again:");
      getIntervals();
    }
  }

  public static void validateRoads() {
    try {
      roads = sc.nextLine();
//      int parsedValue = Integer.parseInt(roads);
      if(!roads.matches("[1-9]+")) {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println("Error! Incorrect Input. Try again:");
      getRoads();
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
