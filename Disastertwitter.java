/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package disastertwitter;
import java.util.*;
import java.io.*;

/**
 *
 * @author zoinks
 */
public class Disastertwitter 
{
    private final HashMap<String, Integer> keywords;
    public Disastertwitter()
    {
        keywords = parseKeywords();
        System.out.println(keywords);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new Disastertwitter();
    }
    private HashMap<String, Integer> parseKeywords()
    {
        //read the file keywords.txt
        //if the line starts with a #, ignore it
        //else add it to a hashmap of keywords
        Scanner sc = null;
        HashMap<String, Integer> keywords = new HashMap<>();
        try
        {
            sc = new Scanner(new File("keywords.txt"));
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if(line.startsWith("#") || line.equals(""))
                continue;
            
            String[] splitline = line.split(",");
            keywords.put(splitline[0],Integer.parseInt(splitline[1]));
        }
        
        sc.close();
        
        return keywords;
    }
}
