package src;


import com.jfoenix.controls.JFXBadge;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

import javax.swing.*;
import java.io.IOException;

public class dashboardController {

    @FXML
    JFXBadge class1 = new JFXBadge();

    @FXML
    JFXBadge class2 = new JFXBadge();

    @FXML
    JFXBadge class3 = new JFXBadge();

    Label class1Label = new Label("Grade: 100%");
    VBox vbox = new VBox(class1Label);
    PopOver popOver = new PopOver(vbox);

    Label class2Label = new Label("Grade: 100%");
    VBox vbox2 = new VBox(class2Label);
    PopOver popOver2 = new PopOver(vbox2);

    Label class3Label = new Label("Grade: 100%");
    VBox vbox3 = new VBox(class3Label);
    PopOver popOver3 = new PopOver(vbox3);

    @FXML
    void class1Hover(MouseEvent event) throws Exception {
        vbox.setPrefHeight(45);
        vbox.setPrefWidth(75);
        class1Label.setWrapText(true);
        vbox.setStyle("-fx-background-color: #ffccbb;" + "-fx-alignment: CENTER");
        popOver.show(class1);
    }

    @FXML
    void class1Exit(MouseEvent event) throws Exception {
        popOver.hide();
    }

    @FXML
    void class2Hover(MouseEvent event) throws Exception {
        vbox2.setPrefHeight(45);
        vbox2.setPrefWidth(75);
        class2Label.setWrapText(true);
        vbox2.setStyle("-fx-background-color: #6eb5c0;" + "-fx-alignment: CENTER");
        popOver2.show(class2);
    }

    @FXML
    void class2Exit(MouseEvent event) throws Exception {
        popOver2.hide();
    }

    @FXML
    void class3Hover(MouseEvent event) throws Exception {
        vbox3.setPrefHeight(45);
        vbox3.setPrefWidth(75);
        class3Label.setWrapText(true);
        vbox3.setStyle("-fx-background-color: #006c84;" + "-fx-alignment: CENTER");
        popOver3.show(class3);
    }

    @FXML
    void class3Exit(MouseEvent event) throws Exception {
        popOver3.hide();
    }



    @FXML
    private void settingsChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }
/*
    @FXML
    private void dashboardChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }*/

    @FXML
    private void quizChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    // TEMPORARY TEMPORARY TEMPRARY TEMPORARY
    @FXML
    private void gradesChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("writereview.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }
    @FXML
    private void scheduleChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("schedule.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    @FXML
    private void calendarChosen(Event event) throws IOException {
        // System.out.println("in button1pressed");

        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));

        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

}