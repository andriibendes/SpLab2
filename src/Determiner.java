import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Determiner {


    public static void main(String[] args) {
        try {
            File myObj = new File("test.txt");
            Scanner reader = new Scanner(myObj);
            int alfabet = reader.nextInt();
            int states_num = reader.nextInt();
            int start_state = reader.nextInt();
            int finite_num = reader.nextInt();
            boolean[] finite = new boolean[states_num];
            ArrayList<Transition>[] edges = new ArrayList[states_num];
            for (int i = 0; i < states_num; i++) {
                edges[i] = new ArrayList<Transition>();
            }
            for (int i = 0; i < states_num; i++) {
                finite[i] = false;
            }
            for (int i = 0; i < finite_num; i++) {
                int f = reader.nextInt();
                finite[f] = true;
            }
            /*System.out.println(alfabet);
            System.out.println(states_num);
            System.out.println(start_state);
            System.out.println(finite[1]);*/
            reader.nextLine();
            HashSet<Character> allLetters = new HashSet<Character>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split(" ");
                Transition transition = new Transition(Integer.parseInt(words[1]), words[2].charAt(0));
                allLetters.add(words[2].charAt(0));
                edges[Integer.parseInt(words[0])].add(transition);
            }
            for (Transition a: edges[start_state]) {
                if (finite[a.to])
                    allLetters.remove(a.letter);
            }
            for (char res : allLetters)
            {
                System.out.println(res);
            }
            /*for (int i = 0; i < states_num; i++)
            {
                System.out.pr/ln(i);
                for (Transition a: edges[i]) {
                    System.out.println(a.letter);
                    System.out.println(a.to);
                }
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            e.printStackTrace();
        }
    }
}
