package viva2;

/**
 * Objective: Viva 2-Q2: Write a program with a java method that receives 2 double arrays as input and returns a double value as output to help her solve this problem.
 */

//import java Scanner utility package
import java.util.Scanner;
//create public class Viva2Q2
public class Viva2Q2 {
    //create main method
    public static void main(String[] args) {
        //create Scanner object: input
        Scanner input = new Scanner(System.in);
        //prompt the user to enter first response time data
        System.out.println("First Response Time");
        System.out.print("Enter the size: ");
        int num1 = input.nextInt();
        System.out.print("Enter the time list: ");
        double [] array1 = new double[num1];
        for(int i=0; i<array1.length; i++){
            array1[i] = input.nextDouble();    
        }
        System.out.println("");
        //prompt the user to enter first response time data
        System.out.println("Second Response Time");
        System.out.print("Enter the size: ");
        int num2 = input.nextInt();
        System.out.print("Enter the time list: ");
        double [] array2 = new double[num2];
        for(int i=0; i<array2.length; i++){
            array2[i] = input.nextDouble();    
        }
        //print the output(median) in three decimal places with method FindMedian
        System.out.printf("\nThe median is %.3f", FindMedian(array1, array2));
    }
    
    public static double FindMedian(double[] a, double[] b){
        //merge two arrays into one
        int sum = a.length+b.length;
        double [] finalArray = new double[sum];
        for (int i=0; i<a.length; i++) {
            finalArray[i] = a[i];
        }

        for (int i=0; i<b.length; i++) {
            finalArray[a.length + i] = b[i];
        }
        
        //sort the array in asc(bubble sort)
        for(int pass=0; pass<finalArray.length; pass++){
            for(int i=0; i<finalArray.length-1; i++){
                if(finalArray[i]>finalArray[i+1]){
                    double hold = finalArray[i];
                    finalArray[i] = finalArray[i+1];
                    finalArray[i+1] = hold;
                }
            }
        }
        
        //determine the formula
        double median;
        if(sum%2==0){
            //even, median = ((n/2)th term)+((n/2)th+1 term)/2
            median = (finalArray[sum/2]+finalArray[(sum/2)-1])/2;  
        }
        else{
            //odd, median = ((n+1/2)th term)/2   
            median = finalArray[(sum-1)/2];
        }   
        return median;    
    }
    
}
