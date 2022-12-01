package com.example.supplychainproject;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    void  placeOrder(String productID) throws SQLException {
        ResultSet res = HelloApplication.connection.executeQuery("Select max(orderID) from orders");
        int orderID = 0;
        if(res.next())
            orderID = res.getInt("max(orderID)")+1;
        System.out.println(orderID);
        String query = String.format("Insert Into orders values(%s,%s,'%s')",orderID,productID,HelloApplication.emailId);
        System.out.println(query);
        int responce = HelloApplication.connection.executeUpdate(query);
        if(responce>0){
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Order");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your Order is Placed Thank you ");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();


        }
    }
}
