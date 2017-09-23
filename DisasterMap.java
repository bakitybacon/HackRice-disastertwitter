/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.io.File;

/**
 *
 * @author zoinks
 */
public class DisasterMap 
{
    private DisasterSquare[][] map;
    public DisasterMap(File file, int width, int height)
    {
        map = new DisasterSquare[width][height];
        Scanner sc = null;
        try
        {
            sc = new Scanner(file);
        }
        catch(java.io.FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        int i = 0;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] squares = line.split(",");
            for(int j = 0; j < squares.length; j++)
            {
                String s = squares[j];
                int severity = Integer.parseInt(s);
                map[i][j] = new DisasterSquare(severity);
            }
            i++;
            System.out.println("whipit");
        }
        
        String output = "";
        for(int j = 0; j < map.length; j++)
        {
            for(int k = 0; k < map[0].length;k++)
            {
               output += (map[j][k]+",");
            }
            output = output.substring(0,output.length() - 1);
            output += "\n";
        }
        System.out.println(output);
    }
    
    public DisasterSquare[][] getMap()
    {
        return map;
    }
    
    public static void main(String[] argumentes) throws Exception
    {
        System.out.println("dab");
        File file = new File("sampledata.txt");
        new DisasterMap(file, 7, 5);
    }
}

class DisasterSquare
{
    private double severity;
    public DisasterSquare(double severity)
    {
        this.severity = severity;
    }
    public double getSeverity()
    {
        return severity;
    }
    public String toString()
    {
        return severity+"";
    }
}
