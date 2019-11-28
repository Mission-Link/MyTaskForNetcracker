package parser;

import actions.helpers.ActionDeque;
import actions.helpers.ActionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import strikepackage.Browser;

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
    private String pathToXML;
    private ActionFactory actionFactory;

    public Parser(String pathToXML, Browser browser) {
        this.pathToXML = pathToXML;
        actionFactory = new ActionFactory(browser);
    }

    /**
     * Method parseXML parses XML file
     *
     * @return ActionDeque instance where all actions are stored
     * @throws IOException
     * @throws SAXException
     */
    public ActionDeque parseXML() throws IOException, SAXException {
        ActionDeque actionDeque = new ActionDeque();
        File xmlFile = new File(pathToXML);
        if (!xmlFile.exists()) {  //if file does not exist
            System.out.println("XML file does not exist, exit");
            System.exit(0);
        }
        NodeList nodeList = retrieveNodeList();
        ArrayList<Element> arrayListWithElements = retrieveActionElements(nodeList);
        ArrayList<ArrayList<String>> allReceivedParams = printChildNames(arrayListWithElements);
        System.out.println("Size of big coll is: " + allReceivedParams.size());
        //-------

        for (ArrayList<String> tmp : allReceivedParams) {
            actionDeque.putAction(actionFactory.createAction(tmp));
        }

        return actionDeque;
    }

    private NodeList retrieveNodeList() {
        File xmlFile = new File(pathToXML);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = db.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize(); //normalization?
        Element root = doc.getDocumentElement();
        return root.getChildNodes();
    }

    private ArrayList<Element> retrieveActionElements(NodeList parent) {
        ArrayList<Element> arrayListWithActNodes = new ArrayList<>();
        analyseNode(arrayListWithActNodes, parent);
        return arrayListWithActNodes;
    }

    /**
     * Helper method for method retrieveActionElements(NodeList parent)
     *
     * @param parent parent node
     */
    private static void analyseNode(ArrayList<Element> nodeListArrayList, NodeList parent) {
        for (int i = 0; i < parent.getLength(); i += 1) {
            Node node = parent.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getNodeName().toLowerCase().equals("action")) {
                    nodeListArrayList.add(element);
//                    printChildNames();
                } else {
//                    System.out.println("Element (getNodeName)" + element.getNodeName() + " HAS child nodes");
//                    System.out.println("Child tag val: " + element.getChildNodes().item(0).getNodeValue());
                    analyseNode(nodeListArrayList, element.getChildNodes());
                }
            }
        }
    }//end of method

    /**
     * Processes action element tags to create an Action subclass obj and
     * to store it in deque
     */
    private ArrayList<ArrayList<String>> printChildNames(ArrayList<Element> elementArrayList) {
        ArrayList<ArrayList<String>> paramsForActions = new ArrayList<>();
        ArrayList<String> actionArrayList = null;

        for (Element tmp : elementArrayList) {
            NodeList nodeList = tmp.getChildNodes();
            actionArrayList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String s = element.getChildNodes().item(0).getNodeValue();
                    System.out.println("Received string: " + s);
                    actionArrayList.add(s);
                }
            }
            System.out.println("========Here are parameters: ");
            for(String param: actionArrayList){
                System.out.println(param);
            }
            System.out.println("=========");
            paramsForActions.add(actionArrayList);
            actionArrayList = null;
        }//end of outer loop

//        Action action = a.createAction(actionArrayList);
//        actionDeque.putAction(action);

        return paramsForActions;
    }//end of method printChildNames()

}//end of class
