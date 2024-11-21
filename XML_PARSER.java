import javax.swing.*;
import java.awt.*;

public class XMLTreeViewer {

    public void displayTree(DefaultMutableTreeNode rootNode) {
        JTree tree = new JTree(rootNode);
        JScrollPane scrollPane = new JScrollPane(tree);
        
        JFrame frame = new JFrame("XML Tree Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        TreeNodeBuilder treeNodeBuilder = new TreeNodeBuilder();
        
        Node rootNode = xmlParser.parseXML("path/to/your/file.xml");
        if (rootNode != null) {
            DefaultMutableTreeNode treeRoot = treeNodeBuilder.buildTree(rootNode);
            XMLTreeViewer viewer = new XMLTreeViewer();
            viewer.displayTree(treeRoot);
        }
    }
}
