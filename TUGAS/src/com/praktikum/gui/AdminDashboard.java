package com.praktikum.informatik.laboratory;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;


class Mahasiswa {
    private final SimpleStringProperty nama;
    private final SimpleStringProperty nim;
    private final SimpleStringProperty jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = new SimpleStringProperty(nama);
        this.nim = new SimpleStringProperty(nim);
        this.jurusan = new SimpleStringProperty(jurusan);
    }

    public String getNama() { return nama.get(); }
    public SimpleStringProperty namaProperty() { return nama; }

    public String getNim() { return nim.get(); }
    public SimpleStringProperty nimProperty() { return nim; }

    public String getJurusan() { return jurusan.get(); }
    public SimpleStringProperty jurusanProperty() { return jurusan; }
}


public class AdminDashboard {

    private Stage stage;
    private String adminUsername;

    public AdminDashboard(Stage stage, String adminUsername) {
        this.stage = stage;
        this.adminUsername = adminUsername;
    }

    public void show() {

        Label welcomeLabel = new Label("Halo, Administrator " + adminUsername);
        Label laporanBarangTitle = new Label("Laporan Barang");
        laporanBarangTitle.setStyle("-fx-font-weight: bold;");


        TableView<Laporan> laporanTable = new TableView<>();


        TableColumn<Laporan, String> namaLaporanCol = new TableColumn<>("Nama");
        namaLaporanCol.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        namaLaporanCol.setPrefWidth(100);

        TableColumn<Laporan, String> lokasiLaporanCol = new TableColumn<>("Lokasi");
        lokasiLaporanCol.setCellValueFactory(cellData -> cellData.getValue().lokasiProperty());
        lokasiLaporanCol.setPrefWidth(100);

        TableColumn<Laporan, String> statusLaporanCol = new TableColumn<>("Status");
        statusLaporanCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        statusLaporanCol.setPrefWidth(100);

        TableColumn<Laporan, String> reportedByCol = new TableColumn<>("Reported By");
        reportedByCol.setCellValueFactory(cellData -> cellData.getValue().reportedByProperty());
        reportedByCol.setPrefWidth(100);

        laporanTable.getColumns().addAll(namaLaporanCol, lokasiLaporanCol, statusLaporanCol, reportedByCol);
        laporanTable.setItems(ReportService.getAllReports());
        laporanTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        Button tandaiClaimedButton = new Button("Tandai Claimed");
        Button logoutButton = new Button("Logout");


        logoutButton.setOnAction(e -> {
            new LoginScreen(stage).show();
        });


        // Vertical Layout for Reports Section
        VBox laporanBarangSection = new VBox(10);
        laporanBarangSection.getChildren().addAll(laporanBarangTitle, laporanTable, tandaiClaimedButton);
        VBox.setVgrow(laporanTable, Priority.ALWAYS);


        Label dataMahasiswaTitle = new Label("Data Mahasiswa");
        dataMahasiswaTitle.setStyle("-fx-font-weight: bold;");


        TableView<Mahasiswa> mahasiswaTable = new TableView<>();
        TableColumn<Mahasiswa, String> namaMahasiswaCol = new TableColumn<>("Nama");
        namaMahasiswaCol.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        namaMahasiswaCol.setPrefWidth(150);

        TableColumn<Mahasiswa, String> nimMahasiswaCol = new TableColumn<>("NIM");
        nimMahasiswaCol.setCellValueFactory(cellData -> cellData.getValue().nimProperty());
        nimMahasiswaCol.setPrefWidth(150);

        TableColumn<Mahasiswa, String> jurusanMahasiswaCol = new TableColumn<>("Jurusan");
        jurusanMahasiswaCol.setCellValueFactory(cellData -> cellData.getValue().jurusanProperty());
        jurusanMahasiswaCol.setPrefWidth(150);

        mahasiswaTable.getColumns().addAll(namaMahasiswaCol, nimMahasiswaCol, jurusanMahasiswaCol);


        ObservableList<Mahasiswa> mahasiswaData = FXCollections.observableArrayList(
                new Mahasiswa("Safira", "202410370110233", "Informatika"),
                new Mahasiswa("Marlove salim", "202410370110263", "Informatika"),
                new Mahasiswa("natania oktaviani", "202410370110273", "Informatika"),
                new Mahasiswa("ahmad nadif zufar", "202410370110243", "Informatika")
        );
        mahasiswaTable.setItems(mahasiswaData);
        mahasiswaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        TextField namaMahasiswaField = new TextField();
        namaMahasiswaField.setPromptText("Nama Mahasiswa");
        TextField nimMahasiswaField = new TextField();
        nimMahasiswaField.setPromptText("NIM");
        TextField jurusanMahasiswaField = new TextField();
        jurusanMahasiswaField.setPromptText("Jurusan");
        Button taButton = new Button("Tambah");
        Button hButton = new Button("Hapus");


        // Horizontal Layout for Input Fields
        HBox mahasiswaInputLayout = new HBox(10, namaMahasiswaField, nimMahasiswaField, jurusanMahasiswaField, taButton, hButton);
        mahasiswaInputLayout.setAlignment(Pos.CENTER_LEFT);

        // Vertical Layout for Student Section
        VBox dataMahasiswaSection = new VBox(10);
        dataMahasiswaSection.getChildren().addAll(dataMahasiswaTitle, mahasiswaTable, mahasiswaInputLayout);
        VBox.setVgrow(mahasiswaTable, Priority.ALWAYS);

        // Main Layout Structure
        HBox mainContentLayout = new HBox(20);
        mainContentLayout.setPadding(new Insets(10));
        mainContentLayout.getChildren().addAll(laporanBarangSection, dataMahasiswaSection);
        HBox.setHgrow(laporanBarangSection, Priority.ALWAYS);
        HBox.setHgrow(dataMahasiswaSection, Priority.ALWAYS);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(welcomeLabel, mainContentLayout, logoutButton);
        root.setAlignment(Pos.TOP_LEFT);

        // Scene and Stage Management
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Lost & Found Kampus - Admin");
        stage.setScene(scene);
        stage.show();
    }
}
