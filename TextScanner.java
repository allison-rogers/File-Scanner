//This homework takes a text file of quiz answers (Also included in the repository), scans the student's answers, and outputs their grade

import java.io.*;
import java.util.*;
public class TextScanner {
public static void main(String[] args) throws FileNotFoundException {

//initialize file
   File file = new File("P22Data.txt");
   
//find array length (I made this work even if the file added more students, I'm not sure if i needed to do that)
   Scanner scan = new Scanner(file);
   int size = 0;
   while(scan.hasNextLine()){      
      String count = scan.nextLine();
      size++;    
   }

//put each line into an array
   String [] lines = new String [size];
   Scanner scan2 = new Scanner(file);   
   for(int i=0;i<size;i++){
      lines[i] = scan2.nextLine();
   }

//breaks the lines into pieces
   String [] ids = new String [size-1];
   String [] ans = new String [size-1];
   
   for(int i=1;i<size;i++){
      ids[i-1] = lines[i].substring(0,8);
      ans[i-1] = lines[i].substring(9);
   }

//Evaluates answers
   double [] points = new double [size-1];
   String a = "";
   for(int i=0;i<(size-1);i++){
      for(int j=0;j<20;j++){
         if(ans[i].length()!=0){
            if(lines[0].charAt(j)==ans[i].charAt(0)){
               points[i]=points[i]+2;
            }else if(ans[i].charAt(0)!= ' '){
               points[i]=points[i]-1;
            }else{
               points[i]=points[i];
            }
            ans[i] = ans[i].substring(1);

         }
      }
            double sc = (5*(points[i]))/2;
            if(sc<60){
               a = "F";
            }else if(sc<70){
               a = "D";
            }else if(sc<80){
               a = "C";
            }else if(sc<90){
               a = "B";
            }else{
               a= "A";
            }
            System.out.println(ids[i] + ": " + sc + "% -- " + a);
   }

}
}