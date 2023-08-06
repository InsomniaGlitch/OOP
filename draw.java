import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class draw {
    public ArrayList<toy> l;
    public HashMap<toy, String> wl;
    FileWriter fw;

    Scanner in = new Scanner(System.in);
    
    public draw(ArrayList<toy> l, HashMap<toy, String> wl, FileWriter fw) {
        this.l = l;
        this.wl = wl;
        this.fw = fw;
    }

    public void insert(toy t) {
        this.l.add(t);
    }

    public void change_weight(String name, int weight) {
        for (toy t : this.l) {
            if (t.name.equals(name)) {
                t.weight = weight;
            }
        }
    }

    public void win(toy t, String name) throws IOException {
            this.fw.write(name + " won a " + t.name);
            this.fw.append('\n');
            this.fw.flush();
        t.amount -= 1;
        System.out.println(t.amount + " " + t.name + " remains");
        wl.put(t, name);
        if (t.amount == 0) {
            this.l.remove(t);
        }
    }

    //public void give_out(toy t) throws IOException {
    //        this.fw.write(t.name + " was sent to " + this.wl.get(t));
    //        this.fw.append('\n');
    //        this.fw.flush();
    //        this.wl.remove(t, this.wl.get(t));
    //}

    public void start() throws IOException {
        System.out.println("The draw starts now! The toys are:");
        for (toy t : this.l) {
            System.out.println(t.name + " in amount of " + t.amount);
        }
        while(this.l.size() > 0) {
            int full_weight = 0;
            for (toy t : this.l) {
                full_weight += t.weight;
            }
            int ran = ThreadLocalRandom.current().nextInt(0, full_weight + 1);
            int id = -1;
            for (toy t : this.l) {
                ran -= t.weight;
                id += 1;
                if(ran <= 0) {
                    System.out.println("Someone won a " + this.l.get(id).name + " ! Who was it? Enter their name:");
                    win(this.l.get(id), in.nextLine());
                    break;
                }
            }
        }
        System.out.println("The draw is over!");
    }
}
