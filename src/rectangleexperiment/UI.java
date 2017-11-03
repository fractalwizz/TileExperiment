package rectangleexperiment;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class UI {
    private static boolean TRIP_ERROR = false;
    public static int mWidth = 800;
    public static int mHeight = 384;
    public static int mSizeX = 80;
    public static int mSizeY = 24;
    
    private static Group mGroup;
    private static Tile[][] mTile;
    private static Scene mScene;
    
    private static final EventHandler<MouseEvent> mMouseEvent = (MouseEvent event) -> {
        EventType e = event.getEventType();
        if (e == MouseEvent.MOUSE_ENTERED || e == MouseEvent.MOUSE_EXITED) {
            Tile temp = (Tile) event.getSource();
            Color tempR = temp.getRectFill();
            Color tempL = temp.getLabelFill();
            
            temp.setRectFill(tempL);
            temp.setLabelFill(tempR);
        }
    };
    
    private static final EventHandler<MouseEvent> mClickEvent = (MouseEvent event) -> {
        EventType e = event.getEventType();
        if (e == MouseEvent.MOUSE_CLICKED) {
            Tile temp = (Tile) event.getSource();
            System.out.printf("You have clicked on Tile at position (%s,%s) with value '%s'\n", temp.getXCoord(), temp.getYCoord(), temp.getBaseChar());
        }
    };
    
    public static void setGroup(Group group) { UI.mGroup = group; }
    
    private static Color getRandColor() {
        Random rand = new Random();
        
        return new Color(
            rand.nextFloat(),
            rand.nextFloat(),
            rand.nextFloat(),
            1.0
        );
    }
    
    private static char getRandChar() {
        Random rand = new Random();
        return (char) ((char) 32 + rand.nextInt(94));
    }
    
    public static Scene initialize() {
        mScene = new Scene(mGroup, mWidth, mHeight, Color.WHITE);
        
        mTile = new Tile[mSizeX][mSizeY];
        for (int i = 0; i < mSizeX; i++) {
            for (int j = 0; j < mSizeY; j++) {
                double w = mWidth / mSizeX;
                double y = mHeight / mSizeY;
                double sx = w * i;
                double sy = y * j;
                
                Tile tile = new Tile(
                    i,                      // tile x-coordinate
                    j,                      // tile y-coordinate
                    sx,                     // tile start corner x
                    sy,                     // tile start corner y 
                    w,                      // tile width
                    y,                      // tile height
                    getRandColor(),         // rectangle fill
//                    Color.BLACK,
//                    Color.WHITE,
//--------------------------------------------------------
                    Color.BLACK,            // label fill
//                    Color.WHITE,
//                    getRandColor(),
                    getRandChar()           // character
                );
                
                tile.setOnMouseEntered(mMouseEvent);
                tile.setOnMouseExited(mMouseEvent);
                tile.setOnMouseClicked(mClickEvent);
                
                //r.xProperty().bind(scene.widthProperty().divide(mSizeX).multiply(i));
                //r.yProperty().bind(scene.heightProperty().divide(mSizeY).multiply(j));
                //r.widthProperty().bind(scene.widthProperty().divide(mSizeX));
                //r.heightProperty().bind(scene.heightProperty().divide(mSizeY));
                
                mTile[i][j] = tile;
            }
        }
        
        for (Tile[] mRect1 : mTile) { mGroup.getChildren().addAll(mRect1); }
        
        debugPrint();
        
        if (/*possible error error*/TRIP_ERROR) {
            // TODO - return error-based scene
            return null;
        }
        
        return mScene;
    }
    
    public static Tile tileAt(int x, int y) { return mTile[x][y]; }
    
    public static void debugPrint() {
        System.out.println("");
        for (int i = 0; i < mSizeY; i++) {
            for (int j = 0; j < mSizeX; j++) {
                System.out.print(mTile[j][i].getBaseChar());
            }
            System.out.println("");
        }
    }
    
    public static void putString(int x, int y, String string, int wrap) {
        if (x < 0 || x >= mSizeX) { return; }
        if (y < 0 || y >= mSizeY) { return; }
        if (string.isEmpty()) { return; }
        if (wrap >= mSizeX) { wrap = 0; }
        
        for (char c : string.toCharArray()) {
            if (x >= mSizeX) {
                x = wrap;
                y++;
            }
            if (y >= mSizeY) { return; }
            
            mTile[x][y].setLabelFill(Color.BLACK);
            mTile[x][y].setRectFill(Color.WHITE);
            mTile[x][y].setBaseChar(c);
            
            x++;
        }
    }
}