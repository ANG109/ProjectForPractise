package bw.practise.ang.util;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class analysisXml {
	   
	public static void main(String[] args) {
		SAXReader reader=new SAXReader();
		File file=new File("analysisXml.xml");
		
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			
			for(Element child:list){
				List<Attribute> attributeList=child.attributes();
				for(Attribute attr:attributeList){
					System.out.println(attr.getName());
				}
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
