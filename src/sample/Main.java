package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    Stage window;
    Label dumb = new Label("Are you dumb?");
    Label knewIt = new Label("I knew it :)");
    Label clickedTimes = new Label();
    Button no = new Button("No");
    Button yes = new Button("Yes");
    TextField typing = new TextField();

    StackPane wonLayout = new StackPane();
    Scene youWon = new Scene(wonLayout, 400, 400);

    StackPane mainLayout = new StackPane();
    Scene mainPage = new Scene(mainLayout, 400, 400);

    StackPane youLostLayout = new StackPane();
    Scene knewItScene = new Scene(youLostLayout, 400, 400);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AtomicInteger amountOfClicks = new AtomicInteger();
        window = primaryStage;
        window.setTitle("");
        window.setResizable(true);
        /*
        The Labels
         */
        dumb.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        dumb.setTranslateX(0);
        dumb.setTranslateY(-140);

        knewIt.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        knewIt.setTranslateX(0);
        knewIt.setTranslateY(-140);
        clickedTimes.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));


        typing.setVisible(true);


        /*
        the buttons
        */
        no.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
        no.setTranslateX(45);

        yes.setFont(javafx.scene.text.Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        yes.setTranslateX(-20);



        no.onMouseEnteredProperty().set(event -> {
            Random rand = new Random();
            int randomXNumber = rand.nextInt((100 - (-100)) + 1);
            int randomYNumber = rand.nextInt((100 - (-100)) + 1);
            no.setTranslateX(randomXNumber);
            no.setTranslateY(randomYNumber);
            amountOfClicks.set(amountOfClicks.get() + 1);
            clickedTimes.setText("You clicked " + amountOfClicks + " times on \"No\"! ");
        });
        yes.setOnAction(event ->{
            if(!typing.getText().equalsIgnoreCase("no")) {


                window.setScene(knewItScene);
                window.show();
            } else {
                window.setScene(youWon);
            }


        });


        mainLayout.getChildren().add(typing);
        mainLayout.getChildren().add(dumb);
        mainLayout.getChildren().add(no);
        mainLayout.getChildren().add(yes);
        youLostLayout.getChildren().add(knewIt);
        youLostLayout.getChildren().add(clickedTimes);
        mainPage.getStylesheets().add("sample/MainPage.css");
        knewItScene.getStylesheets().add("sample/KnewItScene.css");
        youWon.getStylesheets().add(("sample/YouWon.css"));
        window.setScene(mainPage);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
