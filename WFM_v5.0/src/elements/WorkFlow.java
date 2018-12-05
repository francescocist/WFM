
package elements;

import java.io.File;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ui.NodePanel;
import ui.TransitionPanel;
import ui.WorkFlowPanel;

@XmlRootElement(name = "node_list")
@XmlAccessorType(XmlAccessType.FIELD)

public class WorkFlow implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlTransient
	public WorkFlowPanel panel;
	
	//nodes list
	@XmlElementWrapper(name="nodes")
	public ArrayList<Node> nodes = new ArrayList<Node>();
		
	//transitions list
	@XmlElementWrapper(name="transitions")
	public ArrayList<Transition> transitions = new ArrayList<Transition>();
	
	@XmlTransient
	File file;
	
	//node position and size
	private int startX=20;
	private int startY=20;
	
	//new transition elements
	@XmlTransient
	private Node start;
	@XmlTransient
	private boolean startTaken = false;
	@XmlTransient
	private Node end;
	@XmlTransient
	private boolean endTaken = false;
	
	
	/*
	 *  CONSTRUCTORS
	 */
	
	public WorkFlow() {
		super();
		this.panel = new WorkFlowPanel();
		this.panel.setLayout(null);
		this.file = null;
	}
		
	
	/*
	 *  PRINT WORKFLOW COMPONENTS
	 */

	public void printWorkFlow() {
		
		//print nodes
		for(Node n: nodes) {
			NodePanel newNodePanel = new NodePanel(n);
			panel.add(newNodePanel);
			n.setPanel(newNodePanel);
			n.setNodeWF(this);
		}
		
		//print transitions
		for(Transition t: transitions) {
			TransitionPanel newTransitionPanel = new TransitionPanel(t);
			panel.add(newTransitionPanel);
			t.setPanel(newTransitionPanel);
			t.setTranWF(this);
			t.paintTransition();
		}
	}
	
	public void deleteNode(String node_code) {
		for(Node n: nodes) {
			System.out.println(n);
			if(node_code.equals(n.getNodeCode()) || n.getNodeCode().equals("")) {
				nodes.get(nodes.indexOf(n)).getPanel().setVisible(false);
				nodes.remove(nodes.indexOf(n));
			}
		}
	}
	
	public int getNodeIndexByCode(String node_code) {
		int i=0;
		for(Node n: nodes) {
			if(node_code.equals(n.getNodeCode()) || n.getNodeCode().equals("")) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	
	/*
	 *  JAVA-XML TRANSLATION
	 */
	public String javaXmlTranslate() throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();
		marshaller.marshal(this, writer);
		return writer.toString();		
	}
	
	
	/*
	 *  XML-JAVA TRANSLATION -- valutarne l'utilità
	 */
	public WorkFlow xml_java_Translate(String xml) throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xml);
		return (WorkFlow) unmarshaller.unmarshal(reader);
	}
	
	/*
	 *  GETTERS AND SETTERS @XmlTransient
	 */

	public boolean isStartTaken() {
		return startTaken;
	}

	public void setStartTaken(boolean startTaken) {
		this.startTaken = startTaken;
	}

	public WorkFlowPanel getPanel() {
		return panel;
	}

	public void setPanel(WorkFlowPanel panel) {
		this.panel = panel;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public boolean isEndTaken() {
		return endTaken;
	}

	public void setEndTaken(boolean endTaken) {
		this.endTaken = endTaken;
	}


	

}
