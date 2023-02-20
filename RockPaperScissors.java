import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Path;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String player1, player2;
        int score1 = 0, score2 = 0;
        int highestScore = 0;

        System.out.println("Rock, Paper, Scissors Game");
        
        BufferedReader reader =new BufferedReader(new FileReader("new.txt"));
         File f = new File("new.txt");
        long num = f.length();
        int max = 0;
        String Int_line;

        while ((Int_line = reader.readLine()) != null) {
            int In_Value = Integer.parseInt(Int_line);
            int[] array = new int[100];  
                for(int i=0; i<num; i++)  
                    {  
                    array[i]=In_Value; 
                    if(array[i]>max) {
    				    max = array[i];
                    }  
                }
        }

            System.out.println("maximum highest score: " + max);
        
        System.out.println("Enter Player 1 Name: ");
        player1 = sc.nextLine();
        System.out.println("Enter Player 2 Name: ");
        player2 = sc.nextLine();
        
         
        while (true) {
            System.out.println("\n" + player1 + " choose (R)ock, (P)aper, (S)cissors or (Q)uit: ");
            String player1Choice = sc.nextLine();
            String q="q", r = "r", s = "s", p = "p";
            
            // if (player1Choice.equals("Q")) {
            //     break;
            // }
            if(player1Choice.toLowerCase().equals(q.toLowerCase())){
                break;
            }

            System.out.println("\n" + player2 + " choose (R)ock, (P)aper, (S)cissors or (Q)uit: ");
            String player2Choice = sc.nextLine(); 
            
            if (player2Choice.toLowerCase().equals(q.toLowerCase())) {
                break;
            }

            if (player1Choice.toLowerCase().equals(r.toLowerCase())){
                if (player2Choice.toLowerCase().equals(s.toLowerCase())) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.toLowerCase().equals(p.toLowerCase())){
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            } else if (player1Choice.toLowerCase().equals(p.toLowerCase())) {
                if (player2Choice.toLowerCase().equals(r.toLowerCase())) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.toLowerCase().equals(s.toLowerCase())) {
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            } else if (player1Choice.toLowerCase().equals(s.toLowerCase())) {
                if (player2Choice.toLowerCase().equals(p.toLowerCase())) {
                    System.out.println(player1 + " wins!");
                    score1++;
                } else if (player2Choice.toLowerCase().equals(r.toLowerCase())) {
                    System.out.println(player2 + " wins!");
                    score2++;
                } else {
                    System.out.println("Draw!");
                }
            }

            if (score1 > highestScore) {
                highestScore = score1;
            }
            if (score2 > highestScore) {
                highestScore = score2;
            }

            System.out.println("\nCurrent scores: " + player1 + ": " + score1 + ",\n" + player2 + ": " + score2);
            System.out.println("Highest score: " + highestScore);
        }


            try{
                FileWriter fileWriter = new FileWriter("new.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                Scanner scanner = new Scanner (new File("new.txt"));
                if(scanner.hasNextInt()){
                    highestScore = scanner.nextInt();
                }
                
                if(score1 > highestScore){
                    highestScore = score1;
                }
                if(score2 > highestScore){
                    highestScore = score2;
                }
                
                bufferedWriter.write(highestScore + "\n");
                
                bufferedWriter.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        sc.close();
    }
}
