/******************************************************************************
 * Copyright (C) 2014 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

package kafka.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FIXME 类注释信息(此标记自动生成,注释填写完成后请删除)
 * 
 * <pre>
 * [
 * 调用关系:
 * 实现接口及父类:
 * 子类:
 * 内部类列表:
 * ]
 * </pre>
 * 
 * @author 作者
 * @since 1.0
 * @version 2014-04-08 作者
 */
public class Consumer1 {

	/**
	 * kafka的消息获取
	 */
	private static ConsumerConnector consumerConnectorForStatus;

	/**
	 * 日志
	 */
	private static final Logger log = LoggerFactory.getLogger(Consumer1.class);

	/**
	 * 消息状态的主題
	 */
	public static final String MESSAGE_STATUS = "One";
	/**
	 * 线程池
	 */
	private static ExecutorService executorForStatus = Executors
			.newSingleThreadExecutor();

	/**
	 * 初始化kafka的配置
	 */
	public static void init() {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("consumer.properties"));
			ConsumerConfig consumerConfig = new ConsumerConfig(properties);
			consumerConnectorForStatus = Consumer
					.createJavaConsumerConnector(consumerConfig);
		} catch (IOException e) {
			log.error("KafkaHelper.java==>>Kafka Consumer init failed");
		}
		initReceiveMessageStatus();
	}

	/**
	 * 监听信息的状态队列
	 */
	private static void initReceiveMessageStatus() {
		HashMap<String, Integer> map = new HashMap<String, Integer>(1);
		map.put(MESSAGE_STATUS, 1);
		Map<String, List<KafkaStream<byte[], byte[]>>> topicMessageStreams = consumerConnectorForStatus
				.createMessageStreams(map);
		List<KafkaStream<byte[], byte[]>> streams = topicMessageStreams
				.get(MESSAGE_STATUS);
		for (final KafkaStream<byte[], byte[]> stream : streams) {
			executorForStatus.submit(new Runnable() {

				public void run() {
					System.out.println("sdfsdfsdf");
					ConsumerIterator<byte[], byte[]> it = stream.iterator();
					while (it.hasNext()) {
						String strMessage = new String(it.next().message());
						System.out.println("Consumer1:" + strMessage);
						// consumerConnectorForStatus.commitOffsets();
					}
				}
			});
		}
	}

	/**
	 * 销毁资源信息
	 */
	public static void destory() {
		if (consumerConnectorForStatus != null) {
			consumerConnectorForStatus.commitOffsets();
			consumerConnectorForStatus.shutdown();
		}
		executorForStatus.shutdown();
	}

	/**
	 * FIXME 方法注释信息(此标记由Eclipse自动生成,请填写注释信息删除此标记)
	 * 
	 * @param args
	 *            ssdf
	 */
	public static void main(String[] args) {
		init();
		// destory();
		try {
			Thread.sleep(10 * 20 * 1000);
			destory();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
