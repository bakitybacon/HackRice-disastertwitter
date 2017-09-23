/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zoinks
 */
public class DisasterPanel extends JPanel
{
    private final DisasterMap dm;
    private final DisasterSquare[][] map;
    public DisasterPanel(DisasterMap dm)
    {
        this.dm = dm;
        map = dm.getMap();
    }
    public void paint(Graphics g)
    {
        int itemwidth = getWidth()/map[0].length;
        int itemheight = getHeight()/map.length;
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[0].length; j++)
            {
                float severity = (float)map[i][j].getSeverity();
                g.setColor(new Color(severity/10.0f,0.0f,0.0f));
                g.fillRect(j*itemwidth, i*itemheight, itemwidth, itemheight);
            }
        }
    }
    
    public static void main(String[] args)
    {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(300,300);
        jf.setTitle("based");
        
        jf.add(new DisasterPanel(new DisasterMap(new java.io.File("sampledata.txt"),7,5)));
        jf.setVisible(true);
    }
}
