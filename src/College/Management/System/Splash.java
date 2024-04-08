package College.Management.System;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash()

    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);

        t =new Thread(this);
        t.start();

        int x = 1;

        for(int i = 2; i<= 600; i+=4, x+=1){
            setLocation(600 - ((i + x)/2),350 - (i/2));
            setSize(i+3*x, i+3*x);
        }
        try {
            Thread.sleep(10);
        }catch (Exception e)
           {
               System.out.println("Print the exception"+e);
           }
        }
        public void run()
        {
            try{
                Thread.sleep(7000);
                setVisible(false);
                new Login();
            }catch (Exception e)

            {
              System.out.println("Print this exception"+e);
            }

        }

public static void main(String[] args)
{

    Splash s =  new Splash();
   }
}