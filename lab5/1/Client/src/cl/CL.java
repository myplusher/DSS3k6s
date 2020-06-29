package cl;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class CL {
    
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private Destination destination;
 
    public static void main(String[] args) {
        CL mySend = new CL();
        mySend.sendMessage();
    }
 
    void sendMessage() {
        try {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("lab5");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
            TextMessage message = session.createTextMessage("THIS IS THE TEST MESSAGE !");
            producer.send(message);
 
            connection.close();
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
