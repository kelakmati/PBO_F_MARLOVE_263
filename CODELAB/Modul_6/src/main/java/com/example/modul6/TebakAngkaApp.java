package com.example.modul6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaApp extends Application {

    private int angkaRahasia;
    private int jumlahTebakan = 0;
    private Label feedbackLabel;
    private Label percobaanLabel;
    private TextField inputTebakan;
    private Button tombolTebak;

    private void generateAngkaBaru() {
        angkaRahasia = new Random().nextInt(100) + 1;
        jumlahTebakan = 0;
    }

    @Override
    public void start(Stage stage) {
        generateAngkaBaru();

        Label instruksiLabel = new Label("Tebak angka antara 1 sampai 100:");
        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka...");
        tombolTebak = new Button("Coba Tebak!");
        feedbackLabel = new Label("");
        percobaanLabel = new Label("Jumlah percobaan: 0");

        tombolTebak.setOnAction(e -> {
            if (tombolTebak.getText().equals("Main Lagi")) {
                generateAngkaBaru();
                feedbackLabel.setText("");
                percobaanLabel.setText("Jumlah percobaan: 0");
                tombolTebak.setText("Coba Tebak!");
                inputTebakan.clear();
                return;
            }

            String input = inputTebakan.getText();
            try {
                int tebakan = Integer.parseInt(input);
                jumlahTebakan++;

                if (tebakan < angkaRahasia) {
                    feedbackLabel.setText("Terlalu kecil!");
                } else if (tebakan > angkaRahasia) {
                    feedbackLabel.setText("Terlalu besar!");
                } else {
                    feedbackLabel.setText("Tebakan benar!");
                    tombolTebak.setText("Main Lagi");
                }

                percobaanLabel.setText("Jumlah percobaan: " + jumlahTebakan);
                inputTebakan.clear();

            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Masukkan angka yang valid!");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(instruksiLabel, inputTebakan, tombolTebak, feedbackLabel, percobaanLabel);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 250);
        stage.setTitle("Tebak Angka - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
