/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.text.*;

/***************************************************
*  Program: Tech Fair Cost Calculator
*  Author: Emma Bian
*  Date: March 7, 2024
*  Description: calculates the cost per person for a science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
*number of students doing each project (Arduino, Raspberry PI, VR)
*
*PROCESSING:
*calculate the total cost of all base fees and material costs for the science fair
*divide the total cost by the number of participating students to get the cost per student
*
*OUTPUT:
*print the cost per student for the science fair 
*
***************************************************/
  
/**************** TEST CASES ************************
*Test   Input (numArduino, numRPI, numVR)  Desired Output
*       15, 20, 65                         "The cost per participating student is $67.50"
*       0, 0, 0                            "There are no students participating in the science fair"
*       -1, 42, 28                         "Please enter valid input (positive integers)"
*
*
*
*
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
    Scanner kb = new Scanner (System.in);
    DecimalFormat df = new DecimalFormat ("#.00");
   
  //CONSTANTS
  final double DISCOUNT = 0.05;
  final int FIXED_COST = 50;

  //VARIABLES
  int numArduino, numRPI, numVR; //number of students doing each project
  int totalStudents;
  double totalFixedCost, costArduino, costRPI, costVR;
  double totalCost;
  double costPerStudent;
  
  //CODE
  
  //read in number of students doing each project
  do {
      System.out.print("Enter number of students completing Arduino projects: ");
      numArduino = kb.nextInt();
      System.out.print("Enter number of students completing Raspberry PI projects: ");
      numRPI = kb.nextInt();
      System.out.print("Enter number of students completing VR projects: ");
      numVR = kb.nextInt();
      if ((numArduino < 0)||(numRPI < 0)||(numVR < 0 )) {
          System.out.println("Please enter valid input (positive integers)");
      }
  } while ((numArduino < 0)||(numRPI < 0)||(numVR < 0 ));
  
  //calculate total number of students
  totalStudents = numArduino + numRPI + numVR;
  
  if (totalStudents != 0) {
      //calculate total fixed cost for all students
    if (totalStudents > 100) {
        totalFixedCost = totalStudents*FIXED_COST*DISCOUNT;
    } else {
        totalFixedCost = totalStudents*FIXED_COST;
    }

      //calculate total cost for Arduino projects
    if (numArduino > 15) {
        costArduino = numArduino*9;
    } else {
        costArduino = numArduino*10;
    }
  
      //calculate total cost for Raspberry PI projects
    if (numRPI > 20) {
        costRPI = numRPI*12;
    } else {
        costRPI = numRPI*15;
    }
  
       //calculate total cost for VR projects
    costVR = numVR*20;
  
       //calculate overall total cost and cost per student
    totalCost = totalFixedCost + costArduino + costRPI + costVR;
    costPerStudent = (double)totalCost/totalStudents;
  
      //print cost per student
    System.out.println("The cost per participating student is $" + df.format(costPerStudent));
  } else { //if no students are participating
      System.out.println("There are no students participating in the science fair.");
  }
  
  
    }//end main method
}//end Main
