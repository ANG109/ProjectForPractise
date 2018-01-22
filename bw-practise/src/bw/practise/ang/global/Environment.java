package bw.practise.ang.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Environment {

	private static final String GLOBAL_FILE = "/global.xml";
	private static final String GLOBAL_ROOT_NODE = "global_data";
	private static final String GLOBAL_SEC_NODE = "global";
	private static final String GLOBAL_FINAL_NODE = "param";
	private static final String GLOBAL_PROPERTIES_FILE = "global.properties";
	private static Properties globalProperties;
	public static Configuration configuration;
	private static Map<Integer, String> messageHandlerConfigMap;

	public static Configuration initConfiguration() {
		configuration = new Configuration(GLOBAL_FILE, "//" + GLOBAL_ROOT_NODE
				+ "/" + GLOBAL_SEC_NODE + "/" + GLOBAL_FINAL_NODE);
		return configuration;
	}

	public static Map<String, String> getGlobalMap() {
		if (configuration == null) {
			configuration = initConfiguration();
		}
		return configuration.getMap();
	}
	
	public static Properties getGlobalProperties() {
		if (globalProperties != null) {
			return globalProperties;
		}
		globalProperties = new Properties();
		InputStream inputStream = getConfigInputStream(GLOBAL_PROPERTIES_FILE);
		try {
			globalProperties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return globalProperties;
	}
	
	private static InputStream getConfigInputStream(String path) {
		return Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(path);
	}

	@SuppressWarnings("unchecked")
	private static Map<Integer, String> initMessageHandlerConfigMap() {
		try {
			InputStream in = ConfigHelper.getConfigStream("messageHandler.xml");
			Document document = null;
			SAXReader reader = new SAXReader();
			document = reader.read(in);
			List<Element> handlerList = (List<Element>) document
					.getRootElement().selectNodes("handler");
			String mid = null;
			String handlerName = null;
			for (Element handler : handlerList) {
				mid = handler.attributeValue("mid");
				handlerName = handler.elementText("handler-name");
				messageHandlerConfigMap.put(Integer.valueOf(mid), handlerName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return messageHandlerConfigMap;
	}

	public static Map<Integer, String> getMessageHandlerConfigMap() {
		if (messageHandlerConfigMap == null) {
			messageHandlerConfigMap = new HashMap<Integer, String>();
			messageHandlerConfigMap = initMessageHandlerConfigMap();
		}
		return messageHandlerConfigMap;
	}
}
