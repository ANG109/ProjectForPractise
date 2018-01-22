package bw.practise.ang.global;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configuration {

	private final Logger logger = Logger.getLogger(Configuration.class);

	private String subNode;
	private String xmlFile;
	private Map<String, String> Map = new HashMap<String, String>();

	public Configuration(String xmlFile, String subNode) {
		this.xmlFile = xmlFile;
		this.subNode = subNode;
		this.configure(xmlFile);
	}

	public Configuration configure(String resource) {
		InputStream stream = getConfigurationInputStream(resource);
		return doConfigure(stream, resource);
	}

	public InputStream getConfigurationInputStream(String resource) {
		return ConfigHelper.getResourceAsStream(resource);
	}

	// 配置文件初始
	public Configuration doConfigure(InputStream stream, String resourceName) {
		Document document;
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(stream);
			init(document);
		} catch (DocumentException e) {
			logger.error("Loading Configure File Fail..." + e);
			e.printStackTrace();
		}
		return this;
	}

	private void init(Document document) {
		initXML(document);
	}

	@SuppressWarnings("unchecked")
	private void initXML(Document document) {
		List<Element> list = (List<Element>) document.selectNodes(subNode);
		for (Element element : list) {
			String name = element.attributeValue("name");
			String value = element.attributeValue("value");
			Map.put(name, value);
		}
	}

	public String getSubNode() {
		return subNode;
	}

	public void setSubNode(String subNode) {
		this.subNode = subNode;
	}

	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public Map<String, String> getMap() {
		return Map;
	}

	public void setMap(Map<String, String> map) {
		Map = map;
	}

}
