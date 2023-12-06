package org.example;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    ImageView sprite;
    protected int attitude;
    protected int index;
    protected long duration;
    protected double size;
    protected double offset;
    protected AnimationTimer timer;

    final String altair="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/altair.png";
    final ImageView SpriteSheet= new StaticThing(altair,0,0).getImageviev();

    public AnimatedThing(String FileName) {
        this.sprite=SpriteSheet;
        this.sprite.setViewport(new Camera(10,0,1).getCamera());
        this.index=0;
    }

    public void update(long time)  {

        this.index++;
        this.sprite=SpriteSheet;
        //Les différentes frames du héros ne possède pas la même hitbox
        switch (index%8){
            case 0, 1:
                this.sprite.setViewport(new Camera((index%8)*40,66,1).getCamera());
                break;
            case 2, 3, 6, 7:
                this.sprite.setViewport(new Camera((index%8)*43+(index%8)-1,66,2).getCamera());
                break;
            case  4, 5:
                this.sprite.setViewport(new Camera((index%8)*44+(index%8)-1,66,1).getCamera());
                break;

        }

        this.duration=time;
        new Hero(altair);
    }
    public ImageView getSprite() {
        return sprite;
    }
}
