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
	private Document document;
	
	
	public XMLWriter(){	
		
	}
	
	/**
	 * This method takes the results of an incarnation computation and converts it into an xml format
	 *    
	 * @author Eric Watat Lowe
	 * @param  length The length of the segment X1X2 as described in the cheers specifications
	 * @param  time the time complexity of the computation.
	 * @return      the string representation of the xml document produced
	 * @exception throws a ParserConfigurationException or a TransformerException
	 */
	public String WriteXML(double length, double time){
		
		try {
			
			String l = Double.toString(length);
			String t = Double.toString(time);

			docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setValidating(true);
			docBuilder = docFactory.newDocumentBuilder();
			

			// root elements
			document = docBuilder.newDocument();
			
			Element rootElement = document.createElement("cheers");
			document.appendChild(rootElement);
				
			// result element
			Element results = document.createElement("result");
			rootElement.appendChild(results);

			// set attribute to result element
			Attr attr = document.createAttribute("length");
			attr.setValue(l);
			results.setAttributeNode(attr);

			// complexity element
			Element complexity = document.createElement("complexity");
			complexity.appendChild(document.createTextNode(t)); // TODO: add the time
			results.appendChild(complexity);



			// write the content into xml document
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);

			StringWriter writer = new StringWriter();
			
			//create a result to get a string representation of the xml document
			StreamResult result = new StreamResult(writer);
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			//adds the document type to the xml document
			DOMImplementation domImpl = document.getImplementation();
			DocumentType docType = domImpl.createDocumentType("doctype", "cheersFormat", "cheers.dtd");
			//transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, docType.getPublicId());
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());
			
			transformer.transform(source, result);
			
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
