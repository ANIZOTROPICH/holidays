package com.holidays;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class Valentines {

	
	 public static ArrayList<String> arts = new ArrayList<String>();
	 public static ArrayList<String> congratulation = new ArrayList<String>();
	 
	    public static void toCongratulate(String name){
	        System.out.println("I love you, " + name);
	    }
	    
	    public static void loadFileArts(String filename) throws IOException, FileNotFoundException {
	    	arts.clear();
	        BufferedReader in = new BufferedReader(new FileReader(filename));
	        String s;
	        String art = in.readLine() + "\n";
	        while((s = in.readLine()) != null){
	            if (!s.isEmpty()) art += s + "\n";
	            else {
	                arts.add(art);
	                art = "";
	            }
	        }
	        in.close();
	    }
	    
	    public static void loadFileCongratulation(String filename) throws IOException, FileNotFoundException {
	    	congratulation.clear();
	    	FileInputStream in = new FileInputStream(new File(filename));
	        BufferedReader code = new BufferedReader(new InputStreamReader(in,"UTF-8"));
	        String s;
	        String art = code.readLine() + "\n";
	        while((s = code.readLine()) != null){
	            if (!s.isEmpty()) art += s + "\n";
	            else {
	            	congratulation.add(art);
	                art = "";
	            }
	        }
	        in.close();
	        code.close();
	    }
	    
	    
	    public static String pickRandomArt(){
	        int n = arts.size();
	        Random r = new Random();
	        return arts.get(r.nextInt(n));   
	    }
	    
	    public static String pickRandomCongratulation(){
	        int n = congratulation.size();
	        Random r = new Random();
	        return congratulation.get(r.nextInt(n));   
	    }
	    
	    public static void toSaveCongratulation(String filename, String name) throws IOException, FileNotFoundException {
	        FileWriter out = new FileWriter(filename);
	        String art = pickRandomArt();
	        String congratulation = pickRandomCongratulation();
	        out.write(art + "\n");
	        //System.out.println(art + "\n");
	        out.write(congratulation + "\n");
	        //System.out.println(congratulation + "\n");
	        out.write("I love you, " +name);
	        //System.out.println("I love you, " +name);
	        out.close();
	    }
	    
	    
}
