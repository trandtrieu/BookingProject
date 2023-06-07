/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {

    public static void sendConfirmationEmail(String recipientEmail, BookTour orderModel) throws MessagingException {
        // Cấu hình thông tin liên quan đến thư
        String host = "smtp.gmail.com";
        String port = "587";
        final String username = "trieudz02@gmail.com";
        final String password = "hylpmfiuezpxbxia";
        String fromEmail = "trieudz02@gmail.com";
        String subject = "Xac nhan dat tour";

        // Tạo đối tượng Session từ thông tin cấu hình
        java.util.Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Xây dựng nội dung email
        String content = "<html><body>"
                + "<h1>Xin chào,"+ orderModel.getName() + "</h1>" 
                + "<p>Tour của bạn đã được đặt thành công.</p>"
                + "<h2>Thông tin tour:</h2>"
                + "<p>Tên tour: " + orderModel.getTourName()+ "</p>"
                + "<p>Tên khách hàng: " + orderModel.getName() + "</p>"
                + "<p>Ngày khởi hành: " + orderModel.getDateStart() + "</p>"
                + "<p>Ngày kết thúc: " + orderModel.getDateEnd() + "</p>"
                + "<p>Tổng tiền: " + orderModel.getTotalAmount() + "</p>"
                + "<p>Ngày: " + orderModel.getDate() + "</p>"
                + "<p>Số lượng người lớn: " + orderModel.getQuantityAd() + "</p>"
                + "<p>Số lượng trẻ em: " + orderModel.getQuantityChildren() + "</p>"
                + "</body></html>";

        // Tạo đối tượng MimeMessage
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        message.setSubject(subject);
        message.setContent(content, "text/html; charset=utf-8");

        // Gửi email
        Transport.send(message);
    }
}
