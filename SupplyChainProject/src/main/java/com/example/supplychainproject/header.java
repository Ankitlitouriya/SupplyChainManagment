package com.example.supplychainproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class header {
    public static AnchorPane root;
    header() throws IOException{
        root = FXMLLoader.load((getClass().getResource("header.fxml")));
    }
}
