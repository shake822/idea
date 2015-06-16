package kafka.producer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import kafka.javaapi.producer.Producer;

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
 * @version 2014-04-04 作者
 */
public class ProducerSample {

	/**
	 * FIXME 方法注释信息(此标记由Eclipse自动生成,请填写注释信息删除此标记)
	 * 
	 * @param args
	 *            s
	 * @throws IOException
	 *             s
	 */
	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();
		properties.load(ClassLoader
				.getSystemResourceAsStream("producer.properties"));
		ProducerConfig config = new ProducerConfig(properties);

		Producer<String, String> producer = new Producer<String, String>(config);
		List<KeyedMessage<String, String>> all = new ArrayList<KeyedMessage<String, String>>();
		for (int i = 0; i < 1222; i++) {
			all.add(new KeyedMessage<String, String>("One",i+"", UUID.randomUUID().toString()+"_"+i));
		}
		producer.send(all);
		producer.close();
	}
}
