/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examscheduler;
import javax.swing.*;

/**
 *
 * @author Saurav Verma
 */
public class Schedule {
    private JFrame f = new JFrame("Schedule");
    private JTextArea Answer = new JTextArea();
    
    public Schedule(int result[]){
        
        Answer.setEditable(false);
        for(int i=0; i<17; i++)
        {
            Answer.append("Vertex "+i+" ---> Color "+result[i]+"\n");
        }
        
        f.add(Answer);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);
        f.setVisible(true);
    }
    
    public static void main(String args[])
    {
        
    }
}
