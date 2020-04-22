package com.holidays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Present {
    String name;
    Double price;
    public Present(String Name,Double Price){
        name = Name;
        price = Price;
    }
}



public class WomensDay {

	public static ArrayList<Present> vishlist = new ArrayList<Present>();

	public static void loadFile(String filename) throws IOException, FileNotFoundException {
		vishlist.clear();
	    BufferedReader in = new BufferedReader(new FileReader(filename));
	    String s;
	    String name = in.readLine() + "\n";
	    while((s = in.readLine()) != null){
	        if (!s.isEmpty()) name += s + "\n";
	        else {
	        	String[] name2 = name.split("-");
	        	vishlist.add(new Present(name2[0],Double.parseDouble(name2[1])));
	        	name = "";
	        }
	    }
	    in.close();
	}
	
    public static Present pickRandom(){
        int n = vishlist.size();
        Random r = new Random();
        return vishlist.get(r.nextInt(n));   
    }
	
    public static void toSave(String filename,int Sum) throws IOException, FileNotFoundException {
    	int Sum2 = 0;
    	int y = 0;
        FileWriter out = new FileWriter(filename);
        while ((vishlist.size()>=0)&&(Sum2 <= Sum)&&(y <= 100)) {
        	
        	 Present name = pickRandom();
        	if (Sum2+name.price <= Sum) {
        System.out.println(name.name+"-"+String.format("%.0f",name.price));
        out.write(name.name+"-"+String.format("%.0f",name.price)+"\n");
        Sum2+=name.price;
        vishlist.remove(name);
        } else {y++;} 
        }
        out.close();
    }
	

	
}
