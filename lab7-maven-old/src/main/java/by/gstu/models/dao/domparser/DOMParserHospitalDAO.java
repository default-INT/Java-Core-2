package by.gstu.models.dao.domparser;

import by.gstu.models.dao.HospitalDAO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserHospitalDAO implements HospitalDAO {
    private Document document;

    public DOMParserHospitalDAO(Document document) {
        this.document = document;
    }

    @Override
    public String getHospitalName() {
        Node root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("name")) {
                return nodeList.item(i).getTextContent();
            }
        }
        return null;
    }
}
