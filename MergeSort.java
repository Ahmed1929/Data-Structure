import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MergeSort implements ActionListener{
    JFrame myFrame;
    JButton Back, Sort, Add;
    JTextField textField;
    ArrayList<Integer> list = new ArrayList<Integer>();
    MergeSort(){
        //Back button
        Back = new JButton("Back");
        Back.setBounds(100, 450, 100, 50);
        Back.setBackground(Color.decode("#BACDB0"));
        Back.addActionListener(this);
        Back.setFocusable(false);
        // Add Button
        Add = new JButton("Add");
        Add.setBounds(500, 250, 150, 80);
        Add.setBackground(Color.decode("#BACDB0"));
        Add.addActionListener(this);
        Add.setFocusable(false);
        //Sort Button
        Sort = new JButton("Sort");
        Sort.setBounds(250, 250, 150, 80); //100, 50
        Sort.setBackground(Color.decode("#BACDB0"));
        Sort.addActionListener(this);
        Sort.setFocusable(false);
        //text Field to take input from the user
        textField = new JTextField();
        textField.setBounds(445, 150, 100, 30);
        textField.setFont(new Font("MV Boli", Font.PLAIN, 20));
        //label
        JLabel label = new JLabel("Enter a number: ");
        label.setForeground(Color.decode("#BACDB0"));
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setBounds(195, 127, 270, 70);
        label.setOpaque(false);

        myFrame = new JFrame("MergeSort");
        myFrame.getContentPane().setBackground(Color.decode("#729B79"));
        myFrame.setVisible(true);
        myFrame.setLocation(500, 50);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(900, 600);
        myFrame.add(Back);
        myFrame.add(label);
        myFrame.add(textField);
        myFrame.add(Sort);
        myFrame.add(Add);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if the user pressed back
        if(e.getSource() == Back) {
            myFrame.dispose();
            new StackOrQueue();
        }
        //if the user pressed sort
        else if(e.getSource() == Sort) {
            if(!list.isEmpty()) {
                int array[] = new int[list.size()];
                for(int i = 0; i < list.size(); i++) {
                    array[i] = list.get(i);
                }
                array = MergeSort(array);
                System.out.print("{");
                int i;
                for(i = 0; i < array.length - 1; i++) {
                    System.out.print(array[i] + ", ");
                }
                System.out.println(array[i] + "}");
                System.out.println("*******");
            }
            else {
                JOptionPane.showMessageDialog(null, "Enter some numbers in the array", "The array is empty", JOptionPane.ERROR_MESSAGE);
            }
        }
        //if the user pressed add
        else if(e.getSource() == Add) {
            try {
                int num = Integer.parseInt(textField.getText());
                list.add(num);
            }catch(NumberFormatException x) {
                JOptionPane.showMessageDialog(null, "Please enter a number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
        }
    }
    //MergeSort Method
    static int[] MergeSort(int[] array) {
        int n = array.length;
        if(n == 1)
            return array;
        int midpoint = n / 2;
        int[] left = new int[midpoint];
        int[] right;

        if(n % 2 != 0)
            right = new int[midpoint + 1];
        else
            right = new int[midpoint];

        for(int i = 0; i < midpoint; i++)
            left[i] = array[i];
        int len = right.length;
        for(int i = 0; i < len; i++)
            right[i] = array[midpoint + i];

        left = MergeSort(left);
        right = MergeSort(right);

        return Merge(left, right);
    }
    static int[] Merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int len1 = left.length;
        int len2 = right.length;

        int leftCounter, rightCounter, resultCounter;
        leftCounter = rightCounter = resultCounter = 0;
        while(leftCounter < len1 && rightCounter < len2) {
            if(left[leftCounter] > right[rightCounter])
                result[resultCounter++] = right[rightCounter++];
            else
                result[resultCounter++] = left[leftCounter++];
        }
        while(leftCounter < len1)
            result[resultCounter++] = left[leftCounter++];
        while(rightCounter < len2)
            result[resultCounter++] = right[rightCounter++];

        return result;
    }

}