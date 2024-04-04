package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Random;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
// import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.skin.TextInputControlSkin.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// import javafx.scene.control.Button;
// import javafx.scene.control.Menu;
// import javafx.scene.control.MenuBar;
// import javafx.scene.control.MenuItem;
// import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

    int score;
    private String high_score;
    private int hig_h;

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Target_Shoot");

        TilePane tilePane = new TilePane();
        tilePane.setPadding(new Insets(0, 0, 0, 0));
        tilePane.setAlignment(Pos.TOP_CENTER);
        // tilePane.setMargin(tilePane, new Insets(10, 0, 0, 0));
        Scene mainScene = new Scene(tilePane, 800, 600);

        Image image = new Image("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\background\\background2.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background mainbackground = new Background(backgroundImage);
        tilePane.setBackground(mainbackground);
        tilePane.setVgap(8.0);
        tilePane.setHgap(10.0);

        Image Startimage = new Image("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\play.png");
        ImageView start = new ImageView(Startimage);

        Image Exitimage = new Image("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\cancel.png");
        ImageView exit = new ImageView(Exitimage);

        Label gameName = new Label("Target and Shoot Game");

        gameName.setStyle(
                "-fx-pref-width:340px; -fx-pref-height:50px; -fx-border-radius:40px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent, black, #daf7f4; -fx-font-size:30px;");
        // gameName.setPadding(new Insets(0,0,10,0));
        // gameName.setAlignment(Pos.TOP_CENTER);

        Button btnStart = new Button("Start", start);
        btnStart.setCursor(Cursor.HAND);
        btnStart.setStyle(
                "-fx-pref-width:230px; -fx-pref-height:50px; -fx-border-color:lime; -fx-border-radius:20px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");
        // btnStart.setPadding(10,0,0,0);;

        // high score
        Button btnHS = new Button("High Score");
        btnHS.setCursor(Cursor.HAND);
        btnHS.setStyle(
                "-fx-pref-width:230px; -fx-pref-height:50px; -fx-border-color:lime; -fx-border-radius:20px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");

        btnHS.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                VBox var = new VBox();
                var.setAlignment(Pos.CENTER);
                var.setSpacing(70);
                var.setStyle("-fx-background-color:#7574d6;");
                Label var1 = new Label("Highscore :" + hig_h);
                var1.setStyle(
                        "-fx-font-size:50px; -fx-border-color:red; -fx-text-fill:Aqua; -fx-border-radius:30px; -fx-border-width:3,3;");
                Scene scene = new Scene(var, 800, 600);

                Button btnClose = new Button("Close");
                btnClose.setCursor(Cursor.HAND);
                btnClose.setStyle(
                        "-fx-pref-width:150px; -fx-pref-height:50px; -fx-border-color:lime; -fx-border-radius:40px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");

                btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent arg0) {
                        stage.setScene(mainScene);
                    }

                });

                var.getChildren().addAll(var1, btnClose);

                stage.setScene(scene);
                stage.setTitle("HIGH SCORE");
            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setCursor(Cursor.HAND);
        btnExit.setStyle(
                "-fx-pref-width:230px; -fx-pref-height:50px; -fx-border-radius:20px; -fx-border-color:lime; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");

        Button btnHelp = new Button("Help");
        btnHelp.setCursor(Cursor.HAND);
        btnHelp.setStyle(
                "-fx-pref-width:230px; -fx-pref-height:50px; -fx-border-color:lime; -fx-border-radius:20px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");

        btnHelp.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                Text help1 = new Text("1) Press \u2190 arrow to rotate the gun\n");
                help1.setFill(Color.RED);
                help1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
                Text help2 = new Text("2) Press \u2192 arrow to rotate the gun\n");
                help2.setFill(Color.RED);
                help2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
                help2.setTextAlignment(TextAlignment.RIGHT);
                Text help3 = new Text("3) Press \u2191 arrow to rotate the gun\n");
                help3.setFill(Color.RED);
                help3.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
                Text help4 = new Text("4) Press \u2193 arrow to rotate the gun\n");
                help4.setFill(Color.RED);
                help4.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
                Text help5 = new Text("5) Press SpaceBar to shoot the bubble\n");
                help5.setFill(Color.RED);
                help5.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
                Text help6 = new Text("6) Press Esc. to close the game\n");
                help6.setFill(Color.RED);
                help6.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));

                Button btnClose = new Button("Close");
                btnClose.setCursor(Cursor.HAND);
                btnClose.setStyle(
                        "-fx-pref-width:150px; -fx-pref-height:50px; -fx-border-color:lime; -fx-border-radius:40px; -fx-font-weight:bold; -fx-border-width: 3, 3; -fx-background-color:transparent; -fx-text-fill:Lime; -fx-font-size:30px;");

                btnClose.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent arg0) {
                        stage.setScene(mainScene);
                    }

                });

                GridPane gridPane = new GridPane();
                gridPane.addRow(0, help1);
                gridPane.addRow(1, help2);
                gridPane.addRow(2, help3);
                gridPane.addRow(3, help4);
                gridPane.addRow(4, help5);
                gridPane.addRow(5, help6);
                gridPane.addRow(6, btnClose);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setStyle(
                        "-fx-border-width:3,3; -fx-border-color:#ebcbb0; -fx-font-fill:aqua; -fx-background-color:#7574d6;");
                Scene scene = new Scene(gridPane, 800, 600);
                stage.setScene(scene);
                stage.setTitle("HELP");
            }

        });

        VBox vBox = new VBox(btnStart, btnHS, btnHelp, btnExit);
        vBox.setSpacing(60);
        vBox.setPadding(new Insets(100, 0, 0, 0));
        vBox.setAlignment(Pos.TOP_CENTER);

        tilePane.getChildren().addAll(gameName, vBox);
        stage.setScene(mainScene);
        stage.setTitle("HOME SCREEN");

        /*-------------------------Game-------------------------*/
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        // root.add(menuBar);

        // handle continuous inputs
        ArrayList<String> keyPressedList = new ArrayList<String>();

        ArrayList<String> keyJustPressedList = new ArrayList<String>();

        /*--------------------------Start Game-----------------------------*/
        btnStart.setOnAction(e -> {
            stage.setScene(scene);
        });

        /*--------------------------Exit Game-----------------------------*/
        btnExit.setOnAction(e -> {
            Platform.exit();
        });

        /*-------------------Left-Right Movement--------------------- */
        scene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String KeyName = event.getCode().toString();
                    if (!keyPressedList.contains(KeyName)) {
                        keyPressedList.add(KeyName);
                        keyJustPressedList.add(KeyName);
                    }
                });

        scene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String KeyName = event.getCode().toString();
                    if (keyPressedList.contains(KeyName))
                        keyPressedList.remove(KeyName);
                });

        Sprite background = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\background.png");
        background.position.set(400, 300);

        Sprite spaceship = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\Gun\\riffle.png");
        spaceship.position.set(100, 300);
        spaceship.velocity.set(50, 0);

        ArrayList<Sprite> laserList = new ArrayList<Sprite>();
        ArrayList<Sprite> BubbleList = new ArrayList<Sprite>();

        double asteroidCount = 5;
        for (int n = 1; n < asteroidCount; n++) {
            Sprite Ybubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\jaune.png");
            Sprite Bbubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\bleu.png");
            Sprite Obubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\orange.png");
            Sprite Rbubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\rouge.png");
            Sprite Vbubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\vert.png");
            Sprite Vibubble = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\bubble\\violet.png");
            double x = 500 * Math.random() + 300;
            double y = 400 * Math.random() + 100;
            Ybubble.position.set(x, y);
            Bbubble.position.set(x, y);
            Obubble.position.set(x, y);
            Rbubble.position.set(x, y);
            Vbubble.position.set(x, y);
            Vibubble.position.set(x, y);
            double angle = 360 * Math.random();
            double angle2 = 360 * Math.random();
            double angle3 = 360 * Math.random();
            double angle4 = 360 * Math.random();
            double angle5 = 360 * Math.random();
            double angle6 = 360 * Math.random();
            Bbubble.velocity.setLength(50);
            Bbubble.velocity.setAngle(angle);
            Ybubble.velocity.setLength(50);
            Ybubble.velocity.setAngle(angle2);
            Obubble.velocity.setLength(50);
            Obubble.velocity.setAngle(angle3);
            Rbubble.velocity.setLength(50);
            Rbubble.velocity.setAngle(angle4);
            Vbubble.velocity.setLength(50);
            Vbubble.velocity.setAngle(angle5);
            Vibubble.velocity.setLength(50);
            Vibubble.velocity.setAngle(angle6);
            BubbleList.add(Bbubble);
            BubbleList.add(Ybubble);
            BubbleList.add(Obubble);
            BubbleList.add(Rbubble);
            BubbleList.add(Vbubble);
            BubbleList.add(Vibubble);
        }

        score = 0;

        AnimationTimer gameloop = new AnimationTimer() {

            @Override
            public void handle(long nanotime) {

                if (keyPressedList.contains("LEFT"))
                    spaceship.rotation -= 3;
                if (keyPressedList.contains("RIGHT"))
                    spaceship.rotation += 3;

                if (keyPressedList.contains("UP")) {
                    spaceship.velocity.setLength(150);
                    spaceship.velocity.setAngle(spaceship.rotation);
                } else {
                    spaceship.velocity.setLength(0);
                }

                if (keyJustPressedList.contains("SPACE")) {
                    Sprite laser = new Sprite("C:\\Users\\ANKIT\\Downloads\\Game\\src\\game\\icons8-circle-30.png");
                    laser.position.set(spaceship.position.x, spaceship.position.y);
                    laser.velocity.setLength(400);
                    laser.velocity.setAngle(spaceship.rotation);
                    laserList.add(laser);
                }

                if (keyJustPressedList.contains("ESCAPE")) {
                    if (score > hig_h) {
                        // .fillText("Your Score is: " + score + " \n Click to play again"+"\nHIGH
                        // SCORE!", WIDTH / 2, HEIGHT /2.5);
                        try {
                            FileWriter myWriter = new FileWriter("C:\\Users\\ANKIT\\OneDrive\\Desktop\\score.txt");
                            myWriter.write(new Integer(score).toString());
                            hig_h = score;
                            myWriter.close();
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    }
                    stage.setScene(mainScene);

                }

                // after processing user input, clear JustPressedList
                keyJustPressedList.clear();

                spaceship.update(1 / 60.0);
                for (Sprite asteroid : BubbleList)
                    asteroid.update(1 / 60.0);

                // update lasers; destroy if 2 seconds passed
                for (int n = 0; n < laserList.size(); n++) {
                    Sprite laser = laserList.get(n);
                    laser.update(1 / 60.0);
                    if (laser.elapsedTime > 1.8)
                        laserList.remove(n);
                }

                for (int laserNum = 0; laserNum < laserList.size(); laserNum++) {
                    Sprite laser = laserList.get(laserNum);
                    for (int asteroidNum = 0; asteroidNum < BubbleList.size(); asteroidNum++) {
                        Sprite asteroid = BubbleList.get(asteroidNum);
                        if (laser.overlaps(asteroid)) {
                            laserList.remove(laserNum);
                            BubbleList.remove(asteroidNum);
                            score += 100;
                        }
                    }
                }

                background.render(context);
                spaceship.render(context);
                for (Sprite laser : laserList)
                    laser.render(context);
                for (Sprite asteroid : BubbleList)
                    asteroid.render(context);

                context.setFill(Color.WHITE);
                context.setStroke(Color.BLUE);
                context.setFont(new Font("Arial Black", 48));
                context.setLineWidth(3);
                String text = "Score: " + score;
                String hscore = "HighScore: " + hig_h;
                int textX = 450;
                int textY = 50;
                context.fillText(text, textX, textY);
                // context.fillText(hscore, textX+200, textY);
                context.strokeText(text, textX, textY);
            }

        };
        gameloop.start();
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
}