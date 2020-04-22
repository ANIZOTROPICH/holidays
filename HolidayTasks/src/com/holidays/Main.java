package com.holidays;

import java.io.*;
import java.util.*;

public class Main {
	
	 public static void main(String[] args) throws IOException, FileNotFoundException {
		 
		 	//Valentines Day
		 
	        String[]  nameForValentines_temp = {"Anastasia", "Batty", "Valery", "Vanessa", "Julia"};
	        
	        ArrayList<String> nameForValentines = new ArrayList<String>();
	        for (String name: nameForValentines_temp) nameForValentines.add(name);
	        
	        for (String name: nameForValentines) {
	        Valentines.loadFileArts("../HolidayTasks/Patterns/ValentinesArts.txt");
	        Valentines.loadFileCongratulation("../HolidayTasks/Patterns/ValentinesCongratulation.txt");
	        Valentines.toSaveCongratulation("../HolidayTasks/Postcards/Valentines/"+name+"_ValentinesCongratulation.txt", name);	}
	        System.out.println("Valentines postcards generated");
	        
	        //Maslenitsa
	        Maslenitsa.Scarecrow(15);
	        System.out.println("Maslenitsa postcards generated");
	        
	        //Womens Day
	        System.out.println("Price:");
	        int Sum = 3500;
		 	WomensDay.loadFile("../HolidayTasks/Patterns/WomensDay.txt");
		 	WomensDay.toSave("../HolidayTasks/Postcards/WomensDay.txt",Sum);	
		 	
	        
	        //Fatherland Defender Day
	        System.out.println("Russian roulette:");
	        Scanner sc = new Scanner(System.in);
	        MensDay.loadFileArts("../HolidayTasks/Patterns/DieArts.txt");	
	        
	        
	        ArrayList<Gamer> nameForMensDay = new ArrayList<Gamer>();
	        String[] nameForMensDay_temp = {"Vladimir", "Andrey", "Sergey", "Pavel", "Demetrius"};
	        for (String name: nameForMensDay_temp){nameForMensDay.add(new Gamer(name));}
	        MensDay.russianRoulette(nameForMensDay);
	        
	        for (int i = 0; i<nameForMensDay_temp.length;i++) {
	        MensDay.loadFileArts("../HolidayTasks/Patterns/FatherlandArts.txt");
	        MensDay.toSaveCongratulation("../HolidayTasks/Postcards/MensDay/"+nameForMensDay_temp[i]+"_FatherlandDay.txt", nameForMensDay_temp[i], "Congratulations on Defender of the Fatherland Day!");}
	        sc.close();
	        System.out.println("Fatherland Defender Day postcards generated");
	        
	    
		 
		 

		 	
	        
	 }
	        
	 		};
	 
	    


