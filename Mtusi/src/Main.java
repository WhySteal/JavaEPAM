import java.io.*;
import java.util.Scanner;

public class Main {
public static int drob(Integer n){
    Integer counter = 0;
    try {
        FileWriter writer = new FileWriter("notes3.txt", false);
        for (int i = 2; i<=n; i++){
            for (int j = 1; j<i; j++){
                Integer a = i;
                Integer b = j;
                while ((a != 0) && (b != 0)){
                    if (a > b){
                        a = a % b;
                    }
                    else{
                        b = b % a;
                    }
                }
                Integer nod = (a + b);
                if (nod != 1){
                    continue;
                }
                else{
                    counter++;
                    String str = Integer.toString(j) + "/" + Integer.toString(i) + " ";
                    writer.append(str);
                    writer.flush();
                }
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return counter;
}
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Integer input = scan.nextInt();
    Integer k = drob(input);
    System.out.println(k);
    }
}