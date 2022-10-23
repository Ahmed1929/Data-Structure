import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StackOrQueue implements ActionListener{
    JFrame myFrame;
    JButton Stack, Queue, MergeSort;
    StackOrQueue(){
        //Declare label 1 & sub label
        JLabel label = new JLabel();
        JLabel sublabel = new JLabel();
        sublabel.setText("Choose your option");
        sublabel.setBounds(345, 145, 350, 60);
        sublabel.setFont(new Font("Montagu Slab", Font.ITALIC, 25));
        sublabel.setForeground(Color.decode("#F3E8EE"));
        //sublabel.setForeground(Color.black); original color
        label.setText("Vending Machine");
        label.setForeground(Color.decode("#F3E8EE"));
        label.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label.setBounds(250, 75, 400, 70);
        label.setOpaque(false);

        //Buttons
        Stack = new JButton("Stack");
        Queue = new JButton("Queue");
        MergeSort = new JButton("Merge Sort");
        MergeSort.setBackground(Color.decode("#BACDB0"));
        //MergeSort.setBackground(Color.decode("0x03FC94")); original color //100 400 150 100
        Stack.setBackground(Color.decode("#BACDB0"));
        Queue.setBackground(Color.decode("#BACDB0"));
        Stack.setBounds(100, 300, 170, 100);
        MergeSort.setBounds(350, 300, 170, 100);
        Queue.setBounds(600, 300, 170, 100);
        MergeSort.setFocusable(false);
        Stack.setFocusable(false);
        Queue.setFocusable(false);
        Stack.addActionListener(this);
        Queue.addActionListener(this);
        MergeSort.addActionListener(this);


        //Frame
        myFrame = new JFrame("Vending Machine");
        myFrame.getContentPane().setBackground(Color.decode("#729B79"));
        myFrame.setVisible(true);
        myFrame.setLocation(500, 50);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(900, 600);
        myFrame.add(label);
        myFrame.add(sublabel);
        myFrame.add(Stack);
        myFrame.add(Queue);
        myFrame.add(MergeSort);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Stack) {
            //this will close the current window and open Stack window
            myFrame.dispose();
            new Stack();
        }
        else if(e.getSource() == Queue){
            //this will close the current window and open Queue window
            myFrame.dispose();
            new Queue();
        }
        else {
            myFrame.dispose();
            new MergeSort();
        }
    }
}
