package cheers;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class XMLWriter {
	
	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	Document document;
	String length;
	String time;
	
	public XMLWriter(double length, double time){
		
		this.length = Double.toString(length);
		this.time = Double.toString(time);
	}
	
	public String WriteXML(){
		
		try {

			docFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docFactory.newDocumentBuilder();
			

			// root elements
			document = docBuilder.newDocument();
			
			Element rootElement = document.createElement("cheers");
			document.appendChild(rootElement);
				
			// result elements
			Element results = document.createElement("result");
			rootElement.appendChild(results);

			// set attribute to length element
			Attr attr = document.createAttribute("length");
			attr.setValue(length);
			results.setAttributeNode(attr);

			// complexity element
			Element complexity = document.createElement("complexity");
			complexity.appendChild(document.createTextNode(time)); // TODO: add the time
			results.appendChild(complexity);



			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			StringWriter writer = new StringWriter();
			
			StreamResult result = new StreamResult(writer);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMImplementation domImpl = document.getImplementation();
			DocumentType docType = domImpl.createDocumentType("doctype", "cheersFormat", "xmlFile.dtd");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, docType.getPublicId());
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());
			
			transformer.transform(source, result);

			System.out.println(writer.toString());
			
			return writer.toString();


		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			return "error";
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
			return "error";
		  }
	}

}
