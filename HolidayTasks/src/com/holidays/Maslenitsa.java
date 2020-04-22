package com.holidays;

import java.io.FileWriter;
import java.io.IOException;

public class Maslenitsa {

	public static String customSundress(String[] chars,int n){

		  int treeLength = ((n * (n + 1))/2);
		  String tree = "";
		  String head = "";
		  int headLength= n/2;
		  int headLength_2;
		  int headLength_3;
		  if (n%2 == 0) {
		  headLength_2 = (int) Math.floor(n/2);headLength_3=0;}
		  else {headLength_2 = (int) Math.floor(n/2)+1;headLength_3=2;};
		  String trunk = ("\n" + " ".repeat(headLength_2-1) + "|"+ " ".repeat(headLength_2*2-1-headLength_3) + "|").repeat((int) Math.floor(n/3));
		     
		  for (int i = 0; i < treeLength; i++) {
		    tree += chars[i % chars.length] + " ";
		  }
		  
		  
		  int rows = 1;
		  String solution = "";
		  
		  while (rows <= n) {
		    solution += " ".repeat(n - rows) + tree.substring(0, rows * 2) + "\n";
		    tree = tree.substring(rows * 2, tree.length());
		    rows++;
		  }
		  
		  rows = 1;
		  head+=" ".repeat(headLength_2);
		  for (int i = 0; i < headLength; i++) {head+="* ";};
		  head+="\n";
		  for (int i = 0; i < headLength-2; i++) {
			  head+=" ".repeat(headLength_2);
			  head+="*";  
			  for (int j = 0; j < ((headLength-1)*2)-1; j++) {head+=" ";};
			  head+="*\n"; 
		  }
		  head+=" ".repeat(headLength_2);
		  for (int i = 0; i < headLength; i++) {head+="* ";};
		  head+="\n";

		  solution = (head+solution.substring(0, solution.length() - 1) + trunk); 
		  
		  return solution;
		  
		}
	
	  public static void Scarecrow(int n) throws IOException {
		  String[] s = {"*","*"};
		  FileWriter writer = new FileWriter("../HolidayTasks/Postcards/Maslenitsa.txt");
		  writer.write(customSundress(s,n));
		  writer.flush();
		  writer.close();
	    }
}
