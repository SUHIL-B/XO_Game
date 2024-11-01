import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;


public class GameBoordePanel extends JFrame implements ActionListener {
    private JPanel gamePanel;
    private JPanel[][] cellPanels;
    private JButton[][] buttons;
    private boolean [][]button_pressed;
    String left_turn = "<--- His turn ";
    String right_turn = " His turn --->";
    char [][]map = {{'-','-','-'}
            ,{'-','-','-'},
            {'-','-','-'}};
   SoundEfficte sound = new SoundEfficte();
   String soundFile = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\mouse-click-153941 (1).wav";
   String win = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\win (tadaaaa).wav";
   String clapping = "C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\clapping sound.wav";
   private JButton lastButton; // Store the last pressed button
   private Timer timer = new Timer(4000, null);
   private boolean winFrameDisplayed = false;
    

    public GameBoordePanel() {
        this.setTitle("X_O Game");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        
        
        ImageIcon image = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\red-x.png");
        Image images = image.getImage();
        Image xsmall = images.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon Xsmall = new ImageIcon(xsmall);
        Image xbig = images.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon Xbig = new ImageIcon(xbig);
        
        image = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\blue-o.png");
        images = image.getImage();
        Image osmall = images.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon Osmall = new ImageIcon(osmall);
        Image obig = images.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon Obig = new ImageIcon(obig);
        
        
        
        
        JLabel player1Label = new JLabel();
        player1Label.setText(X_OGame.frame.player1.getName()+"     |");
        player1Label.setFont(new Font("Arial", Font.PLAIN, 30));
        player1Label.setIcon(Xsmall);
        X_OGame.frame.player1.setShape(Xbig);
        X_OGame.frame.player1.setHis_turn(true);
        
        
        JLabel turn = new JLabel();
        turn.setText(left_turn);
        turn.setFont(new Font("Arial", Font.PLAIN, 25));
        
        
        JLabel player2Label = new JLabel();
        player2Label.setIcon(Osmall);
        player2Label.setText("|     "+X_OGame.frame.player2.getName());
        player2Label.setFont(new Font("Arial", Font.PLAIN, 30));
        player2Label.setHorizontalTextPosition(JLabel.LEFT);
        X_OGame.frame.player2.setShape(Obig);
        X_OGame.frame.player2.setHis_turn(false);
        
        
        
        topPanel.add(player1Label, BorderLayout.EAST);
        topPanel.add(turn, BorderLayout.CENTER);
        topPanel.add(player2Label, BorderLayout.WEST);
        
        
        gamePanel = new JPanel(new GridLayout(3, 3));
        gamePanel.setBackground(Color.WHITE);
         
        

/*/================================================================================================/
/================================================================================================/
/================================================================================================/
/================================================================================================/*/
   
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int row = 0; row < buttons.length; row++) {
                for (int col = 0; col < buttons[row].length; col++) {
                    if (e.getSource() == buttons[row][col]) {
                        if (!button_pressed[row][col]) {
                            if (X_OGame.frame.player1.getHis_turn()) {
                                if (X_OGame.getSound_ON()) {
                                    sound.setFile(soundFile);
                                    sound.playSound();
                                }
                                buttons[row][col].setIcon(X_OGame.frame.player1.getShape());
                                X_OGame.frame.player1.setHis_turn(false);
                                X_OGame.frame.player2.setHis_turn(true);
                                turn.setText(right_turn);
                                turn.setFont(new Font("Arial", Font.PLAIN, 25));
                                map[row][col] = 'x';
                            } else if (X_OGame.frame.player2.getHis_turn()) {
                                if (X_OGame.getSound_ON()) {
                                    sound.setFile(soundFile);
                                    sound.playSound();
                                }
                                buttons[row][col].setIcon(X_OGame.frame.player2.getShape());
                                X_OGame.frame.player2.setHis_turn(false);
                                X_OGame.frame.player1.setHis_turn(true);
                                turn.setText(left_turn);
                                turn.setFont(new Font("Arial", Font.PLAIN, 25));
                                X_OGame.frame.player2.setPoint(row, col);
                                map[row][col] = 'o';
                            }

                            button_pressed[row][col] = true;
                            chick_if_player_win(map);

                            // Store the last pressed button
                            lastButton = buttons[row][col];

                            
                        }
                    }
                }
            }
        }
    };
cellPanels = new JPanel[3][3];
        buttons = new JButton[3][3];
        button_pressed = new boolean[3][3];

        // Create and add panels for each cell
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JPanel cellPanel = createCellPanel();
                JButton button = createButton();
                buttons[row][col] = button;
                buttons[row][col].addActionListener(actionListener);
                cellPanel.add(button);
                button_pressed[row][col] = false;
                
                cellPanels[row][col] = cellPanel;
                gamePanel.add(cellPanels[row][col]);
            }
        }

/*/================================================================================================/
/================================================================================================/
/================================================================================================/
/================================================================================================/*/
        
        this.add(topPanel, BorderLayout.NORTH);
        this.add(gamePanel, BorderLayout.CENTER);
        this.setVisible(true);
        ImageIcon x_oimage = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\X_OGAME\\src\\main\\java\\xo.png");
        Image x_o = x_oimage.getImage();
        this.setIconImage(x_o);
    }

    private JPanel createCellPanel() {
        JPanel cellPanel = new JPanel();
        cellPanel.setBackground(new Color(239, 169, 119));
        cellPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.DARK_GRAY));
        cellPanel.setLayout(new GridBagLayout());

        return cellPanel;
    }
    
    private JButton createButton(){
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(170, 150));
        button.setBackground(new Color(240,235,235));
         button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.DARK_GRAY));
        button.setLayout(new GridBagLayout());
        button.setVisible(true);
        return button;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void chick_if_player_win(char map[][]) {
    if (map[0][0] == 'x' && map[0][1] == 'x' && map[0][2] == 'x' ||
        map[1][0] == 'x' && map[1][1] == 'x' && map[1][2] == 'x' ||
        map[2][0] == 'x' && map[2][1] == 'x' && map[2][2] == 'x' ||
        map[0][0] == 'x' && map[1][0] == 'x' && map[2][0] == 'x' ||
        map[0][1] == 'x' && map[1][1] == 'x' && map[2][1] == 'x' ||
        map[0][2] == 'x' && map[1][2] == 'x' && map[2][2] == 'x' ||
        map[0][0] == 'x' && map[1][1] == 'x' && map[2][2] == 'x' ||
        map[0][2] == 'x' && map[1][1] == 'x' && map[2][0] == 'x' ||
        map[0][0] == 'o' && map[0][1] == 'o' && map[0][2] == 'o' ||
        map[1][0] == 'o' && map[1][1] == 'o' && map[1][2] == 'o' ||
        map[2][0] == 'o' && map[2][1] == 'o' && map[2][2] == 'o' ||
        map[0][0] == 'o' && map[1][0] == 'o' && map[2][0] == 'o' ||
        map[0][1] == 'o' && map[1][1] == 'o' && map[2][1] == 'o' ||
        map[0][2] == 'o' && map[1][2] == 'o' && map[2][2] == 'o' ||
        map[0][0] == 'o' && map[1][1] == 'o' && map[2][2] == 'o' ||
        map[0][2] == 'o' && map[1][1] == 'o' && map[2][0] == 'o') {
            
        X_OGame.frame.player1.setWin(true);
        if (X_OGame.getSound_ON()) {
            sound.setFile(win);
            sound.playSound();
        }
        if (!timer.isRunning()) {
            timer = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!winFrameDisplayed) {
                            winFrameDisplayed = true;
                            new winFrame();
                            GameBoordePanel.this.dispose();
                            
                        }
                }
            });
            timer.start();
        }
    }
    
    for (int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++){
            if(map[i][j] == '-'){
                return;
            }
        }}
    if(!X_OGame.frame.player1.getWin() && !X_OGame.frame.player2.getWin()){
       if (X_OGame.getSound_ON()) {
            sound.setFile(clapping);
            sound.playSound();
        }
        if (!timer.isRunning()) {
            timer = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!winFrameDisplayed) {
                            winFrameDisplayed = true;
                            new GameBoordePanel();
                            GameBoordePanel.this.dispose();
                        }
                }
            });
            timer.start();
        }
       }
}
}