package org.example;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {

    protected double sizeX;
    protected double sizeY;

    private ImageView imageviev;


    public StaticThing(String FileName, double sizeX, double sizeY) {
        Image spriteSheet=new Image(FileName);
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setX(sizeX);
        sprite.setY(sizeY);
        this.imageviev=sprite;
    }



    public ImageView getImageviev() {
        return imageviev;
    }
}
