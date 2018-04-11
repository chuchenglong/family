package com.mc.family.test;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author ChenglongChu
 * @description
 * @create 2018/02/02 10:48
 */
public class TestMQSender {
    //标明一个消息队列
    private static final String MESSAGE_QUEUE="chuchenglong";

    //默认的ActiveMQ服务器端绑定的端口
    private static final int PORT=61616;

    //发送10条消息
    private static final int COUNT = 10;

    public static void main(String[] args) {
        // ConnectionFactory: 连接工厂, JMS创建连接
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer producer;
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:"+PORT);

        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE.booleanValue(), Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值 chuchenglong 是一个服务器的queue, 须在在ActiveMq的console配置
            destination = session.createQueue(MESSAGE_QUEUE);
            // 得到消息生成者, 发送者
            producer = session.createProducer(destination);
            // 设置不持久化
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 发送消息
            sendMessage(session, producer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer){
        for (int i = 0; i <COUNT; i++) {
            TextMessage message = null;
            try {
                message = session.createTextMessage("chuchenglong message "+i);
                // 发送消息到目的地方
                producer.send(message);
                System.out.println("发送消息:"+message.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
