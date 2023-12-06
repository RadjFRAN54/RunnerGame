package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Assassin's Creed Runner");
        HBox root = new HBox();

        Camera camera=new Camera(300,334,0);
        String name="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/desert.png";
        //primaryStage.getScene().setRoot(new Region());
        GameScene a=new GameScene(root,name,0,0,name,name,camera); // Création d'une scène
        String name2="file:///C:/Users/Radji/Downloads/Ressources audio et image pour le runner-20231128/img/heros.png";



        Pane root2=new Pane();


        a.render(camera.getX(),camera.getY(),a.BackGroundleft);
        ImageView tempo= (ImageView) a.getImageViewMember().get(0);
        root2.getChildren().add(tempo);
        a.NumberOfLives(root2,a.getLifePoint());
        Hero h=new Hero(name2); /*Création du héros*/

        root2.getChildren().add(h.getSprite());
        Scene scene = new Scene(root2);

        final int[] k = {1};
        primaryStage.setScene(scene);

        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() { //Création d'un timer
            @Override
            public void handle(long now) {

                root2.getChildren().removeAll(h.getSprite());/*Permet d'éviter un problème d'héritage lié à heros*/
                camera.update(now);
                h.update(now);
                ImageView Background=new StaticThing(name,0,0).getImageviev();
                a.render(camera.getX(),camera.getY(),Background);

                root2.getChildren().add((ImageView) a.getImageViewMember().get(k[0]));
                a.NumberOfLives(root2,a.getLifePoint());
                root2.getChildren().add(h.getSprite());

                k[0] = k[0] +1;
                }
            };
            timer.start();



    }


    public static void main(String[] args) {
        launch(args);

    }


}
