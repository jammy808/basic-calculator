import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.plaf.multi.MultiInternalFrameUI;

import java.awt.*;
import java.awt.event.*;

public class Cal implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[]functionButton = new JButton[8];
    JButton add,sub,mul,div;
    JButton dec,equal,del,clr;
    JPanel panel;
    Font mazaFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;
    Cal(){

        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(mazaFont);
        textfield.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("x");
        div = new JButton("/");
        dec = new JButton(".");
        equal = new JButton("=");
        del = new JButton("Delete");
        clr = new JButton("Clear");

        functionButton[0] = add;
        functionButton[1] = sub;
        functionButton[2] = mul;
        functionButton[3] = div;
        functionButton[4] = dec;
        functionButton[5] = equal;
        functionButton[6] = del;
        functionButton[7] = clr;

        for(int i = 0;i<8;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(mazaFont);
            functionButton[i].setFocusable(false);
        }
        
        for(int i = 0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(mazaFont);
            numberButtons[i].setFocusable(false);
        }
        del.setBounds(50,430,145,50);
        clr.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.CYAN);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numberButtons[0]);
        panel.add(equal);
        panel.add(div);

        frame.add(panel);
        
        frame.add(del);
        frame.add(clr);
        frame.add(textfield);
        frame.setVisible(true);

        

    }

    public static void main(String args[]){
       Cal calculator = new Cal();
     
    }

    public  void actionPerformed(ActionEvent e){
        for(int i = 0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }

        }
        if(e.getSource() == dec ){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()== add){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource()== sub){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()== div){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()== mul){
            num1 = Double.parseDouble(textfield.getText());
            operator = 'x';
            textfield.setText("");
        }
        if(e.getSource()== equal){
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator){
                case'+' : result = num1 + num2;
                          break;
                case'-' : result = num1 - num2;
                          break;
                case'x' : result = num1 * num2;
                          break;
                case'/' : result = num1 / num2;
                          break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()== clr){
            textfield.setText("");
        }
        if(e.getSource()== del){
            String s = textfield.getText();
            textfield.setText("");
            for(int i=0;i<s.length()-1;i++){
                textfield.setText(textfield.getText()+s.charAt(i));
            }
        }


    }
    
}
