package rectangleexperiment;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tile1 extends Rectangle {
    public char base;
    
    // default constructor
    public Tile1() {}
    
    // constructor with character
    public Tile1(char base) { this.base = base; }
    
    public Tile1(double width, double height, char base) {
        super(width, height);
        this.base = base;
    }
    
    public Tile1(double width, double height, Paint fill, char base) {
        super(width, height, fill);
        this.base = base;
    }
    
    public Tile1(double x, double y, double width, double height, char base) {
        super(x, y, width, height);
        this.base = base;
    }
    
    public char getBaseChar() { return base; }
    public void setBaseChar(char base) { this.base = base; }
}