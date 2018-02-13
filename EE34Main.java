import java.util.Scanner;

public class EE34Main {

    public static void main(String[] args) {

        String str;
        String[] words;

        System.out.println("Enter a String to split");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        str = str.replace("\"", "");
        str = str.replace(".", "");
        str = str.replace(",", "");

        words = str.split("\\s");

        for(String w : words){
            System.out.println(w);
        }

    }
}