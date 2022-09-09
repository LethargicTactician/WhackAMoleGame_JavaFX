package com.example.whack;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class WhackBoardController implements Initializable {

    @FXML
    private GridPane moleTable;

    @FXML
    private Label score;

    @FXML
    private ImageView img00;

    @FXML
    private ImageView img20;

    @FXML
    private ImageView img30;

    @FXML
    private ImageView img40;

    @FXML
    private ImageView img50;

    @FXML
    private ImageView img60;

    @FXML
    private ImageView img70;

    @FXML
    private ImageView img80;

    @FXML
    private ImageView img90;

    @FXML
    private ImageView imgWhacked;
//    public WhackBoardController() {}

    int countScore = 0;
    @FXML
    void img00_Clicked(MouseEvent event) throws FileNotFoundException {
        System.out.println("img00_Clicked");

        //score set up
        countScore++;
        score.setText("Score: " + countScore*10);


        //reset
        try{
            String strTarget = String.valueOf(event.getTarget());
        } catch(Exception e){
            e.printStackTrace();
        }

        //TO CHANGE IMAGE
        try {
            //InputStream stream = new FileInputStream("src/main/resources/MoleDown.PNG");

            Image image = new Image(moleDown);
            ImageView view = (ImageView) event.getTarget();
            view.setImage(image);


            Random rand = new Random();
            int intRandom = rand.nextInt(2);
            System.out.println("Random number: " + intRandom);
            System.out.println(event.getTarget());

            img00.setId("up");
            System.out.println(img00.getId());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    String moleUp = "file:/C:/Users/Rosy Gonzalez/IdeaProjects/JavaFX stuff/whack/src/main/resources/MoleUp.PNG";
    String moleDown = "file:/C:/Users/Rosy Gonzalez/IdeaProjects/JavaFX stuff/whack/src/main/resources/MoleDown.PNG";
    String moleWhack = "file:/C:/Users/Rosy Gonzalez/IdeaProjects/JavaFX stuff/whack/src/main/resources/MoleWhack.jpg";
    public void MoleUpdate(){
        Random rand = new Random();
        for(Node n: moleTable.getChildren()) {
            ImageView view = (ImageView) n;
            Image imgDown = new Image(moleDown);
            Image imgUp = new Image(moleUp);

            if(view.getImage().getUrl().contains(moleDown) && rand.nextInt(100) > 85){
                view.setImage(imgUp);
            } else if(view.getImage().getUrl().contains(moleUp) && rand.nextInt(100) > 75 ) {
                //
                view.setImage(imgDown);
            }


        }





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Timer t = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                try {
                    Thread.sleep(300);

                } catch(InterruptedException e){
                    System.out.println("Sleep error: " + e);
                }
                System.out.println("Timer Ticked" + new Date());
                MoleUpdate();
            }


        };
        t.schedule(task, new Date(), 3000);
    }

}
