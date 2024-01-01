import javax.swing.*;  
class TextFieldExample  
{  
public static void main(String args[])  
    {  
    JFrame f= new JFrame("This is the name of the new DungCan");  
    JTextField t1,t2;  
    t1=new JTextField("Sai Bobjeff");  
    t1.setBounds(50,100, 200,30);  
    t2=new JTextField("new DungCan memeber since 2021");  
    t2.setBounds(50,150, 200,30);  
    f.add(t1); f.add(t2);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    }  
    }  
