package MyShop.service;

import MyShop.model.OrderItems;

import java.util.List;

public interface NotificationService {

    void sendNotification(String title, String content, OrderItems orderItems, String addTo);

    void shutdown();
}
