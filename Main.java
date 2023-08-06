import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<toy> list = new ArrayList<toy>();
        HashMap<toy, String> winlist = new HashMap<toy, String>();
        FileWriter filewriter = new FileWriter("log.txt", true);
        draw dr = new draw(list, winlist, filewriter);
        Scanner in = new Scanner(System.in);

        System.out.println("Running toy_draw.exe version 66.6");
        String command = in.nextLine();
        while(!command.equals("Start")) {
            switch (command) {
                case "Add a toy":
                    System.out.print("Name:   ");
                    String name = in.nextLine();
                    System.out.print("Amount:   ");
                    int amount = in.nextInt();
                    System.out.print("Weight:   ");
                    int weight = in.nextInt();
                    toy t = new toy(name, amount, weight);
                    dr.insert(t);
                    break;
                case "Change weight":
                    System.out.print("Toy name:   ");
                    String tname = in.nextLine();
                    System.out.print("New weight:   ");
                    int new_weight = in.nextInt();
                    dr.change_weight(tname, new_weight);
            }
            command = in.nextLine();
        }
        dr.start();
    }
}
