import javax.swing.ImageIcon;


public class Player {
    String name = "------";
    boolean his_turn;
    ImageIcon shape ;
    int [][] map = {{0,0,0},
                    {0,0,0},
                    {0,0,0}}; 
    boolean win = false;

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean getHis_turn() {
        return his_turn;
    }

    public void setHis_turn(boolean his_turn) {
        this.his_turn = his_turn;
    }
    Player(){
        
            
        }
        
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getShape() {
        return shape;
    }

    public void setShape(ImageIcon shape) {
        this.shape = shape;
    }
    
    public void setPoint(int x , int y){
        this.map[x][y]=1;
    }
    
    
    
}