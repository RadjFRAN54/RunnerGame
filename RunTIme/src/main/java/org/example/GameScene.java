package org.example;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.LinkedList;


public class GameScene extends Scene {
    protected ImageView BackGroundleft;
    protected ImageView BackGroundRight;
    protected Scene scene;
    protected int lifePoint;
    protected Rectangle2D camera;
    protected AnimationTimer timer;
    protected HBox root;
    protected LinkedList ImageViewMember=new LinkedList<ImageView>();

    public GameScene(HBox root, String FileName, double sizeX, double sizeY, String Fileleft, String Fileright, Camera camera) {
        super(root,sizeX,sizeY);
        this.camera=camera.getCamera();
        this.lifePoint=3;
        this.BackGroundleft=  new StaticThing(Fileleft,sizeX,sizeY).getImageviev();
        this.BackGroundRight=  new StaticThing(Fileleft,sizeX,sizeY).getImageviev();
        this.root=root;

    }


    public ImageView getBackGroundleft() {
        return BackGroundleft;
    }

    public ImageView getBackGroundRight() {
        return BackGroundRight;
    }

    public LinkedList getImageViewMember() { /*Liste possédant tous les images à afficher*/
        return ImageViewMember;
    }

    public Scene getScene() {
        return scene;
    }
    public ImageView render(double x, int y, ImageView sprite){/* Permet de créer une image qui découpe le sprite du background en fonction de la caméra*/
        this.camera=new Camera(x%1280,y,0).getCamera();
        sprite.setViewport(this.camera);
        this.ImageViewMember.add(sprite);
        return sprite;
    }
    public void NumberOfLives(Pane pane,double lifePoint){ /*Permet d'afficher le nombre de lifepoint du heros*/
        String heart="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/heart.png";

        switch ((int) lifePoint){
            case 1:

                ImageView b = new StaticThing(heart, 500, 230).getImageviev();
                b.setFitWidth(40);
                b.setPreserveRatio(true);
                pane.getChildren().add(b);
                break;
            case 2:
                ImageView b1 = new StaticThing(heart, 500, 230).getImageviev();
                b1.setFitWidth(40);
                b1.setPreserveRatio(true);
                pane.getChildren().add(b1);

                ImageView b2=new StaticThing(heart,450,230).getImageviev();
                b2.setFitWidth(40);
                b2.setPreserveRatio(true);
                pane.getChildren().add(b2);
                break;
            case 3:
                ImageView b3 = new StaticThing(heart, 500, 230).getImageviev();
                b3.setFitWidth(40);
                b3.setPreserveRatio(true);
                pane.getChildren().add(b3);

                ImageView b4=new StaticThing(heart,450,230).getImageviev();
                b4.setFitWidth(40);
                b4.setPreserveRatio(true);
                pane.getChildren().add(b4);

                ImageView b5=new StaticThing(heart,400,230).getImageviev();
                b5.setFitWidth(40);
                b5.setPreserveRatio(true);
                pane.getChildren().add(b5);
                break;
        }
    }
    public void update(long time){ /*Pas utiliser pour l'instant */
        /*AnimationTimer time2 = new AnimationTimer(){
            @Override
            public void handle(long time){

                //new Hero(name2);
            };};
        */

    }


    public int getLifePoint() {
        return lifePoint;
    }
}


