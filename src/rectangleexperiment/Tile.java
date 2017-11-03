package rectangleexperiment;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private Rectangle mRect = new Rectangle();
    private Label mLabel = new Label();
    private char base = ' ';
    private Color rectFill;
    private Color labelFill;
    private int x;
    private int y;
    
    public Tile() {}
    
    public Tile(int coordX, int coordY, double x, double y, double width, double height, Color fill, Color textFill, char base) {
        this.rectFill = fill;
        this.labelFill = textFill;
        
        mRect = new Rectangle(x, y, width, height);
        mRect.setFill(fill);
        
        mLabel.setTextFill(textFill);
        
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.x = coordX;
        this.y = coordY;
        
        // Character.MIN_VALUE for no update (?)
        if (base != 0) {
            this.base = base;
            updateLabel();
        }
        mStack();
    }
    
    private void mStack() {
        this.getChildren().add(mRect);
        this.getChildren().add(mLabel);
    }
    
    private void updateLabel() { mLabel.setText(String.valueOf(base)); }
    
    public Rectangle getRectangle() { return mRect; }
    public void setRectangle(Rectangle r) { this.mRect = r; }
    
    public Label getLabel() { return mLabel; }
    public void setLabel(Label label) { this.mLabel = label; }
    
    public char getBaseChar() { return base; }
    public void setBaseChar(char base) {
        this.base = base;
        updateLabel();
    }
    
    public Color getRectFill() { return rectFill; }
    public void setRectFill(Color fill) {
        this.rectFill = fill;
        mRect.setFill(rectFill);
    }
    
    public Color getLabelFill() { return labelFill; }
    public void setLabelFill(Color fill) {
        this.labelFill = fill;
        mLabel.setTextFill(labelFill);
    }
    
    public int getXCoord() { return x; }
    public void setXCoord(int x) { this.x = x; }
    
    public int getYCoord() { return y; }
    public void setYCoord(int y) { this.y = y; }
}