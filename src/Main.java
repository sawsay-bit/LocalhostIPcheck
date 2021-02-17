import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main implements ActionListener {
    JFrame frame;
    JButton button;
    JLabel label;
    JTextField field;
    ImageIcon icon;
    JLabel image;
    Main(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,150);
        frame.setTitle("Localhost ip check");
        frame.setLayout(null);

        label = new JLabel("Let check IP address");
        label.setBounds(5,10,130,20);
        label.setForeground(Color.green);
        frame.add(label);

        button = new JButton("Check");
        button.setBounds(20,40,80,20);
        button.setForeground(Color.red);
        button.addActionListener(this);
        frame.add(button);

        field = new JTextField(20);
        field.setBounds(20,70,200,20);
        field.setForeground(Color.red);
        frame.add(field);

        icon = new ImageIcon("src/ip.jpeg");

        image = new JLabel(icon);
        image.setSize(400,150);
        frame.add(image);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource()==button){
               InetAddress ip;
               try{
                   ip = InetAddress.getLocalHost();
                   field.setText(""+ip);
               } catch (UnknownHostException unknownHostException) {
                   unknownHostException.printStackTrace();
               }
           }
    }
}