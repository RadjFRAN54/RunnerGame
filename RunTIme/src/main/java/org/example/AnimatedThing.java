package org.example;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    ImageView sprite;
    protected int attitude;
    protected int index;
    protected double duration;
    protected double size;
    protected double offset;
    protected AnimationTimer timer;
    //final String name2="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/heros.png";
    final String altair="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/altair.png";
    final ImageView SpriteSheet= new StaticThing(altair,0,0).getImageviev();
    //final ImageView SpriteSheet2=new StaticThing(altair,0,0).getImageviev();
    public AnimatedThing(String FileName) {
        this.sprite=SpriteSheet;
        this.sprite.setViewport(new Camera(10,0,1).getCamera());
        this.index=0;
    }

    public void update(long time){
       /* this.timer = new AnimationTimer(){
            @Override
            public void handle(long time){
                System.out.println(time);
                System.out.println("b");
                //new Hero(name2);
            };};*/
        System.out.println(time);
        this.index++;
        this.sprite=SpriteSheet;
        //this.sprite.setViewport(new Camera((index%6)*85,0,1).getCamera());
        this.sprite.setViewport(new Camera((index%8)*46,66,1).getCamera());

        new Hero(altair);
        //System.out.println("a");
    }
    public ImageView getSprite() {
        return sprite;
    }
}
