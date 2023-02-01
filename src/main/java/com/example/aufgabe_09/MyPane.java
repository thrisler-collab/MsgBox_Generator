package com.example.aufgabe_09;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class MyPane extends FlowPane {
    public MyPane(){
        init();
    }

    public void init(){
        Label header = new Label("| Header: ");
        TextField he = new TextField();
        Label tt = new Label("| Titel: ");
        TextField ttt = new TextField();
        Label txt = new Label("| Message: ");
        TextField msg = new TextField();
        Button en = new Button("Create MsgBox");
        en.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String head = he.getText();
                String txxt = msg.getText();
                String tit = ttt.getText();
                if (head.isBlank() || txxt.isBlank() || tit.isBlank()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid input");
                    alert.setHeaderText("Incorrect input");
                    alert.setContentText("The content of the message, title and header must not be null!");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                             System.err.println("ERROR!");
                        }
                    });
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(head);
                    alert.setHeaderText(tit);
                    alert.setContentText(txxt);
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            he.setText("");
                            msg.setText("");
                            ttt.setText("");
                        }
                    });
                }

            }
        });
        this.setPadding(new Insets(15));
        this.setHgap(20);
        this.getChildren().addAll(header, he, tt, ttt, txt, msg, en);
    }
}
