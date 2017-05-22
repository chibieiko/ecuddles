package com.evil.Repository;

import com.evil.Entity.Product;
import com.evil.Entity.StockNotification;
import com.evil.Entity.User;
import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Implements repository event handler to send emails on stock updates.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Component
@RepositoryEventHandler(Product.class)
public class StockNotificationHandler {

    /**
     * Email service.
     */
    @Autowired
    EmailService emailService;

    /**
     * Notification repository.
     */
    @Autowired
    StockNotificationRepository notifications;

    /**
     * Handles saving of products.
     *
     * <p>
     * Sends email notifications when necessary.
     *
     * @param product Product that was saved
     */
    @HandleAfterSave
    public void handleProductSave(Product product) {
        System.out.println(product.getStock());

        final ArrayList<InternetAddress> receivers = new ArrayList<>();

        notifications.findAll().forEach(stockNotification -> {
            if (stockNotification.getProduct() == product) {
                InternetAddress receiver = new InternetAddress();
                receiver.setAddress(stockNotification.getUser().getEmail());

                try {
                    receiver.setPersonal(stockNotification.getUser().getName());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                receivers.add(receiver);
                notifications.delete(stockNotification);
            }
        });


        new Thread(() -> {
            for (InternetAddress receiver : receivers) {
                try {
                    Email email = DefaultEmail.builder()
                            .from(new InternetAddress("noreply.ecuddles@gmail.com", "eCuddles"))
                            .to(Lists.newArrayList(receiver))
                            .subject(product.getName() + " is available at eCuddles!")
                            .body("You wanted to know when " + product.getName() + " becomes available! Guess what, now it is!\n\nBest regards,\neCuddles Team")
                            .encoding("UTF-8").build();

                    emailService.send(email);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
