package org.example;

import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing{
    protected ImageView hero;
    public Hero(String FileName) {
        super(FileName);
        this.sprite.setX(75);
        //this.sprite.setY(150);
        this.sprite.setY(169);
    }
}
