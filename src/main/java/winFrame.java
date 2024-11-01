import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class winFrame extends JFrame implements ActionListener {
    JButton homeButton;
    JButton settingsButton;
    SoundEfficte sound = new SoundEfficte();
    String soundFile = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\mouse-click-153941 (1).wav";
    String win = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\win (tadaaaa).wav";
    String algom = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\القم يالهطف.wav";
    
    
    
    winFrame(){
        this.setTitle("X_O Game");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(240,235,235));
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,25,0));

        
        
        ImageIcon image = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\home button.png");
        Image images = image.getImage();
        Image home = images.getScaledInstance(50,33,Image.SCALE_SMOOTH);
        ImageIcon Home = new ImageIcon(home);
        
        ImageIcon imagea = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\settings button.png");
        Image imagesa = imagea.getImage();
        Image settings = imagesa.getScaledInstance(50,33,Image.SCALE_SMOOTH);
        ImageIcon Settings = new ImageIcon(settings);
        
        
        
        homeButton = new JButton();
        homeButton.setPreferredSize(new Dimension(50, 35));
        homeButton.setIcon(Home);
        homeButton.setVerticalTextPosition(SwingConstants.CENTER);
        homeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        homeButton.setBackground(new Color(240,235,235));
        homeButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(200,195,195),new Color(200,195,195)));
        homeButton.setFocusable(false);
        homeButton.addActionListener(this);
        
        
        settingsButton = new JButton();
        settingsButton.setPreferredSize(new Dimension(50, 35));
        settingsButton.setIcon(Settings);
        settingsButton.setVerticalTextPosition(SwingConstants.CENTER);
        settingsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        settingsButton.setBackground(new Color(240,235,235));
        settingsButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(200,195,195),new Color(200,195,195)));
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);
        
       
       topPanel.add(homeButton);
        topPanel.add(settingsButton);
        this.add(topPanel, BorderLayout.NORTH);

        
        image = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\trophy emoji.png");
        images = image.getImage();
        Image trophy = images.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon Trophy = new ImageIcon(trophy);
        
        
         imagea = new ImageIcon("CC:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\poop emoji.png");
         imagesa = imagea.getImage();
        Image poop = imagesa.getScaledInstance(120,150,Image.SCALE_SMOOTH);
        ImageIcon Poop = new ImageIcon(poop);
        
        ImageIcon rightFinger = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\left hand point.png");
        Image rightfinger = rightFinger.getImage();
        Image rightpoint =rightfinger.getScaledInstance(100,70, Image.SCALE_SMOOTH);
        ImageIcon rightPoint = new ImageIcon(rightpoint);
        
        
        
        
        
        JLabel label = new JLabel();
        label.setIcon(Trophy);
        if(X_OGame.frame.player1.getWin()){
            label.setText(X_OGame.frame.player1.getName());
        }
        else{
            label.setText(X_OGame.frame.player2.getName());
        }
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        
        
       
        
        
        JLabel label2 = new JLabel();
        label2.setIcon(Poop);
        if(!X_OGame.frame.player1.getWin()){
            label2.setText(X_OGame.frame.player1.getName());
        }
        else{
            label2.setText(X_OGame.frame.player2.getName());
        }
        label2.setFont(new Font("Arial", Font.PLAIN, 30));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setVerticalAlignment(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.TOP);
        
        JLabel label3 = new JLabel();
        label3.setIcon(rightPoint);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setVerticalAlignment(SwingConstants.CENTER);
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.TOP);
        
         
        
        
        label.setBackground(new Color(240,235,235));
        label.setOpaque(true);
        
        label2.setBackground(new Color(240,235,235));
        label2.setOpaque(true);
        
       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 10)); 
        panel.setBackground(new Color(240,235,235));
        panel.add(label, BorderLayout.WEST); 
        panel.add(label2, BorderLayout.EAST);
        panel.add(label3, BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
        ImageIcon x_oimage = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\xo.png");
        Image x_o = x_oimage.getImage();
        this.setIconImage(x_o);
        
        int delay = 10; // Delay in milliseconds (adjust as desired)
        Timer timer = new Timer(delay, new ActionListener() {
            private int direction = 1; // Initial direction: 1 (to the right)
            private int panelWidth = 420;
            private int labelWidth = 200;
            private int x = 200; // Initial x position in the middle

            @Override
            public void actionPerformed(ActionEvent e) {
                x += direction;
                if (x + labelWidth >= panelWidth || x < 180) {
                    direction *= -1; // Reverse direction when reaching the boundaries
                }
                label3.setLocation(x, label3.getY());
            }
        });

        // Start the animation
        timer.start();
        
        
        
        
        if(X_OGame.getSound_ON()){
                sound.setFile(algom);
                sound.playSound();}
        
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== homeButton){
            if(X_OGame.getSound_ON()){
                sound.setFile(soundFile);
                sound.playSound();}
            dispose(); 
            X_OGame.main(new String[0]);
            
            
        }
        
        else if(e.getSource()==settingsButton){
                if(X_OGame.getSound_ON()){
                    this.sound.setFile(soundFile);
                    this.sound.playSound();
                }
                
                JFrame smallFrame = new JFrame();
                smallFrame.setSize(200, 200);
                smallFrame.setLocation(1100 , 230); 
                smallFrame.setTitle("Settings");
                smallFrame.setResizable(false);
                
                JButton soundShab = new JButton("Sound");
                soundShab.setPreferredSize(new Dimension(100, 50));
                soundShab.setBackground(Color.GREEN);
                
                soundShab.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SoundEfficte sound = new SoundEfficte();
                        String soundFile = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\mouse-click-153941 (1).wav";
                        if(X_OGame.getSound_ON()){
                            X_OGame.setSound_ON(false);
                            soundShab.setBackground(Color.RED);
                            
                            }
                        
                        else{
                            sound.setFile(soundFile);
                            sound.playSound();
                            X_OGame.setSound_ON(true);
                            soundShab.setBackground(Color.green);
                            
                            
                        }
                    }});

                JPanel panel = new JPanel();
                panel.add(soundShab);
                smallFrame.add(panel);
                smallFrame.pack();

                smallFrame.setVisible(true);
        }
    }
}
