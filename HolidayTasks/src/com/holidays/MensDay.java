package com.holidays;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Gamer {
    private final String name;
    private boolean alive;
    public Gamer(String gamerName){
        name = gamerName;
        alive = true;
    }
    public String getName(){
        return name;
    }
    public void toDie(){
        alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
}


public class MensDay {
	
	public static ArrayList<String> arts = new ArrayList<String>();

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
	
    public static String pickRandomArt(){
        int n = arts.size();
        Random r = new Random();
        return arts.get(r.nextInt(n));   
    }
	
    public static void toSaveCongratulation(String filename, String name, String congratulation) throws IOException, FileNotFoundException {
        FileWriter out = new FileWriter(filename);
        String art = pickRandomArt();
        out.write(art + "\n");
        out.write(congratulation + "\n");
        out.write(name);
        out.close();
    }
	
    public static void russianRoulette(ArrayList<Gamer> gamers) throws FileNotFoundException, IOException{
        Random r = new Random();
		Scanner sc = new Scanner(System.in);
        int bullet = r.nextInt(6);
        int push = r.nextInt(6);
        int n = gamers.size();
       

        while (n > 1){
            for (Gamer g: gamers){
                if (g.isAlive()){
                    System.out.println("Hey, " + g.getName() + "! Roll and push(1) or just push(any number, except 1)?");
                    if (sc.nextInt() == 1) push = r.nextInt();
                    else push = (push + 1) % 6;
                    if (push == bullet) {
                        g.toDie();
                        System.out.println(g.getName() + ", you,re dead! Good night");
						toSaveCongratulation("../HolidayTasks/Postcards/MensDay/"+g.getName()+".txt", g.getName(), "You Die");
                        n -= 1;
                        bullet = r.nextInt(6);	} } } }
        for (Gamer g: gamers) if (g.isAlive()) {System.out.println(g.getName() + " - WINNER!!!"); 
        	loadFileArts("../HolidayTasks/Patterns/WinArts.txt");
        	toSaveCongratulation("../HolidayTasks/Postcards/MensDay/"+g.getName()+"_Win.txt", g.getName(), "You Win!");
	    
    }
    sc.close();}
    

}

