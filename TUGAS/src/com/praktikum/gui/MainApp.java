package com.praktikum.gui;

import com.praktikum.data.Database;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;

        // Dummy Data
        Admin admin = new Admin("Marlove Salim", "202410370110263", "admin", "admin123");
        Mahasiswa mhs = new Mahasiswa("Marlove Salim", "202410370110263");

        Database.userList.add(admin);
        Database.userList.add(mhs);

        stage.setTitle("Login");
        stage.setScene(LoginScene.getLoginScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
