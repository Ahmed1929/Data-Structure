import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Queue implements ActionListener{
    JFrame myFrame;
    JButton Back;
    JButton deQueue;
    JComboBox combo;
    QueueList list;
    //options
    String[] array = {"Pepsi", "Cola", "Sprite", "Fanta", "Mountain Dew"};
    Queue(){
        //Back button
        Back = new JButton("Back");
        Back.setBounds(100, 450, 100, 50);
        Back.setBackground(Color.decode("#BACDB0"));
        Back.addActionListener(this);
        Back.setFocusable(false);

        list = new QueueList();

        //ComboBox to let the user choose
        combo = new JComboBox(array);
        combo.setBounds(250, 90, 125, 50); //450, 60
        combo.setBackground(Color.decode("#475B63"));
        combo.setForeground(Color.decode("#F3E8EE"));
        combo.setFocusable(false);
        combo.addActionListener(this);

        //needed labels
        JLabel Choose = new JLabel("Choose: ");
        JLabel message = new JLabel("All purchases will be shown in console");
        JLabel label1 = new JLabel("-Pepsi");
        JLabel label2 = new JLabel("-Cola");
        JLabel label3 = new JLabel("-Sprite");
        JLabel label4 = new JLabel("-Fanta");
        JLabel label5 = new JLabel("-Mountain Dew");
        //choose label
        Choose.setForeground(Color.decode("#F3E8EE"));
        Choose.setFont(new Font("MV Boli", Font.PLAIN, 40));
        Choose.setBounds(90, 80, 400, 70); //300,50
        Choose.setOpaque(false);

        message.setForeground(Color.decode("#F3E8EE"));
        message.setFont(new Font("MV Boli", Font.PLAIN, 18));
        message.setBounds(100, 130, 400, 70); //300,50
        message.setOpaque(false);

        label1.setForeground(Color.decode("#F3E8EE"));
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label1.setBounds(500, 80, 400, 70); //100, 50
        label1.setOpaque(false);

        label2.setForeground(Color.decode("#F3E8EE"));
        label2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label2.setBounds(500, 120, 400, 70); //100
        label2.setOpaque(false);

        label3.setForeground(Color.decode("#F3E8EE"));
        label3.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label3.setBounds(500, 160, 400, 70);
        label3.setOpaque(false);

        label4.setForeground(Color.decode("#F3E8EE"));
        label4.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label4.setBounds(500, 200, 400, 70);
        label4.setOpaque(false);

        label5.setForeground(Color.decode("#F3E8EE"));
        label5.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label5.setBounds(500, 240, 400, 70);
        label5.setOpaque(false);
        //Dequeue button
        deQueue = new JButton("deQueue");
        deQueue.setBackground(Color.decode("#BACDB0"));
        deQueue.setFont(new Font("MV Boli", Font.PLAIN, 20));
        deQueue.setBounds(450, 400, 250, 80);
        deQueue.addActionListener(this);
        deQueue.setFocusable(false);

        //frame
        myFrame = new JFrame("Queue");
        myFrame.getContentPane().setBackground(Color.decode("#729B79"));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocation(500, 50);
        myFrame.setVisible(true);
        myFrame.setLayout(null);
        myFrame.setSize(900, 600);
        myFrame.add(Back);
        myFrame.add(label1);
        myFrame.add(label2);
        myFrame.add(label3);
        myFrame.add(label4);
        myFrame.add(label5);
        myFrame.add(Choose);
        myFrame.add(message);
        myFrame.add(combo);
        myFrame.add(deQueue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Back) {
            myFrame.dispose();
            new StackOrQueue();
        }
        else if(e.getSource() == combo) {
            list.enQueue(array[combo.getSelectedIndex()]);
            list.print();
        }
        else if(e.getSource() == deQueue) {
            list.deQueue();
            list.print();
        }
    }
}
class QueueList{
    //Creating Queue class
    Node head;
    Node tail;
    //some needed method for the queue operations
    void enQueue(String data) {
        Node node = new Node(data);
        if (tail != null){
            tail.next = node;
        }
        tail = node;
        if(head == null) {
            head = node;
        }
    }
    void deQueue() {
        if(head == null) {
            tail = null;
        }
        else {
            head = head.next;
        }
    }
    void print() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("***********");
    }
}
//Node class the is being used in Stack and Queue classes
class Node{
    String data;
    Node next;
    Node(String data){
        this.data = data;
    }
}
