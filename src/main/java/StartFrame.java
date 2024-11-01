import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;



public class StartFrame extends JFrame implements ActionListener{
    
    public File file;
   JLabel  Start = new JLabel();
   
   JButton Start_Button = new JButton();
   JButton p1_button = new JButton("PLAYER 1");
   JButton p2_button = new JButton("PLAYER 2");
   
   Player player1 = new Player();
   Player player2 = new Player();
   
    boolean press_start = false;
    SoundEfficte sound = new SoundEfficte();
    String soundFile = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\mouse-click-153941 (1).wav";
   
   
   StartFrame(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        this.setTitle("X_O GAME");
        
        
        
        
        
        JLabel name = new JLabel();
        name.setText("X/Twitter: @Suhild2004"
                + "     Github: SUHIL-B");
         name.setFont(new Font("", Font.PLAIN, 20));
        name.setVisible(true);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20,20));
        bottomPanel.add(name, BorderLayout.WEST);

        this.add(bottomPanel, BorderLayout.SOUTH);
        
        
        
        Start.setText("X_O GAME");
        Start.setVisible(true);
        
        Start.setHorizontalAlignment(JLabel.CENTER);
        Start.setVerticalAlignment(JLabel.TOP);
        Start.setFont(new Font("MV Boli",Font.PLAIN,50));
        Start.setBackground(new Color(240,235,235));
        Start.setOpaque(true);
        
        
       
        Start_Button.setVisible(true);
        Start_Button.setBounds(190, 150, 200, 50);
        Start_Button.setText("START");
        Start_Button.setFocusable(false);
        Start_Button.setHorizontalTextPosition(JButton.CENTER);
        Start_Button.setVerticalTextPosition(JButton.CENTER);
        Start_Button.setFont(new Font("MV Boli",Font.PLAIN,25));
        Start_Button.setForeground(Color.BLACK);
        Start_Button.setLayout(new BorderLayout());
        
        Start_Button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Start_Button.setBackground(new Color(240,235,235));
        Start_Button.addActionListener(this);
        
        
        
        
        p1_button.setVisible(true);
        p1_button.setBounds(190,220, 200, 50);
        
        p1_button.setFocusable(false);
        p1_button.setHorizontalTextPosition(JButton.CENTER);
        p1_button.setVerticalTextPosition(JButton.CENTER);
        p1_button.setFont(new Font("MV Boli",Font.PLAIN,25));
        p1_button.setForeground(Color.RED);
        p1_button.setBackground(new Color(240,235,235));
        p1_button.setBorder(BorderFactory.createLineBorder(Color.RED));
        p1_button.addActionListener(this);
        
        
        
        p2_button.setVisible(true);
        p2_button.setBounds(190,290, 200, 50);
        
        p2_button.setFocusable(false);
        p2_button.setHorizontalTextPosition(JButton.CENTER);
        p2_button.setVerticalTextPosition(JButton.CENTER);
        p2_button.setFont(new Font("MV Boli",Font.PLAIN,25));
        p2_button.setForeground(Color.BLUE);
        p2_button.setBackground(new Color(240,235,235));
        p2_button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        p2_button.addActionListener(this);
        
        
        
       
        this.add(p1_button);
        this.add(p2_button);
        this.add(Start_Button);
        this.add(Start);
        
        
        ImageIcon image = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\xo.png");
        Image x_o = image.getImage();
        this.setIconImage(x_o);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== p1_button){
            sound.setFile(soundFile);
            sound.playSound();
            String name = JOptionPane.showInputDialog("ENTER PLAYER NAME");
            player1.setName(name);
            p1_button.setText(name);
            
            
            
            
        }
        else if(e.getSource()== p2_button){
            sound.setFile(soundFile);
            sound.playSound();
            String name = JOptionPane.showInputDialog("ENTER PLAYER NAME");
            player2.setName(name);
            p2_button.setText(name);
            
        }
        
        else if(e.getSource() == Start_Button){
            if(X_OGame.getSound_ON()){
                sound.setFile(soundFile);
                sound.playSound();}
            Start.setVisible(false);
            Start_Button.setVisible(false);
            p1_button.setVisible(false);
            p2_button.setVisible(false);
            press_start = true;
            
            
            
            new GameBoordePanel();
            this.dispose();
            
            
        }
        
        
        
    }

    
}