/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 *
 * @author ASUS
 */
public class Notification {
    public static void showNotif(String text, String text2) {
        Notifications notificationBuilder = Notifications.create()
                .title(text)
                .text(text2)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_CENTER)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

        notificationBuilder.darkStyle();
        notificationBuilder.showConfirm();
        
    }
}
