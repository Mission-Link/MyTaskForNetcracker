import Actions.Action;
import Actions.ActionCreator;
import Actions.ActionDeque;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is DOM parser class extracts Action subclass instances from
 * XML file
 * parsed Action subclass instances
 */
public class Parser {

    public Parser() {
    }

    /**
     * Method parseXML parses XML file
     *
     * @param pathToXML
     * @return ActionDeque instance where all actions are stored
     * @throws IOException
     * @throws SAXException
     */
    public ActionDeque parseXML(String pathToXML) throws IOException, SAXException {
        File xmlFile = new File(pathToXML);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = db.parse(xmlFile);

        doc.getDocumentElement().normalize(); //normalization?

        Element root = doc.getDocumentElement();
        System.out.println("Root element: " + root.getNodeName());
        System.out.println("-----------");

        ActionDeque actionDeque = new ActionDeque();

        NodeList nodeList = root.getChildNodes();

        analyseNode(actionDeque, nodeList);

        return actionDeque;
    }


    /**
     * This method processes node to get an
     * action child
     *
     * @param actionDeque deque that stores Action subclass instance
     * @param parent parent node
     */
    private static void analyseNode(ActionDeque actionDeque, NodeList parent) {
        for (int i = 0; i < parent.getLength(); i += 1) {
            Node node = parent.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getNodeName().toLowerCase().equals("action")) {
                    printChildNames(actionDeque, element.getChildNodes());
                } else {
//                    System.out.println("Element (getNodeName)" + element.getNodeName() + " HAS child nodes");
//                    System.out.println("Child tag val: " + element.getChildNodes().item(0).getNodeValue());
                    analyseNode(actionDeque, element.getChildNodes());
                }

            }
        }
    }//end of method

    /**
     * Processes action element tags to create an Action subclass obj and
     * to store it in deque
     *
     * @param actionDeque deque that stores Action subclass instance
     * @param nodeList    node that has to be processed
     */
    private static void printChildNames(ActionDeque actionDeque, NodeList nodeList) {

        ArrayList<String> actionArrayList = new ArrayList<>();
        ActionCreator actionCreator = new ActionCreator();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String s = element.getChildNodes().item(0).getNodeValue();
//                System.out.println("Received string: " + s);

                actionArrayList.add(s);
            }
        }

        Action action = actionCreator.createAction(actionArrayList);
        actionDeque.putAction(action);

    }//end of method printChildNames()

}//end of class
