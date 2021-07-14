package com.shop.middleware.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: ConnectionFactory.java,v 0.1 2021/7/5 10:47  Exp $
 */
@Component
public class RabbitMqConnection {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public static Connection connection;

    public static Channel channel;


    public Connection getConnection() throws IOException, TimeoutException {
        if (null == connection){

            //Properties properties = FileUtils.getProperties("application.yml");

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            factory.setPort(port);
            factory.setUsername(username);
            factory.setPassword(password);
            connection = factory.newConnection();
        }
        return connection;
    }

    public Channel getChannel() throws IOException, TimeoutException {

        if (null == channel){
            channel = getConnection().createChannel();
        }
        return channel;
    }

    public void exchangeDeclare(String exchangeName, String routingKey) throws IOException, TimeoutException {

        Channel channel = getChannel();
        channel.exchangeDeclare(exchangeName, "direct", true);
        String queue = channel.queueDeclare().getQueue();
        channel.exchangeBind(queue, exchangeName, routingKey);

    }

}
