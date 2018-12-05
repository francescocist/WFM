
package elements;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import ui.NodePanel;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "node")

public class Node implements Serializable{

	private static final long serialVersionUID = 1L;

	//position 
	private int posX;
	private int posY;
	
	@XmlTransient
	public WorkFlow nodeWF;

	//node values
	private String nodeCode;
	private String desc;
	private String language;
	
	@XmlTransient
	private NodePanel panel;
	
	
	public Node() {
		super();
		this.panel = new NodePanel(this);
		this.panel.revalidate();
		this.panel.setVisible(true);
	}
	
	public Node(WorkFlow node_WF) {
		super();
		this.nodeWF = node_WF;
		this.posX = node_WF.getStartX();
		this.posY = node_WF.getStartY();
		this.nodeCode = "";
		this.panel = new NodePanel(this);
		
	}

	/*
	 *  GETTER AND SETTERS
	 */

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public WorkFlow getNodeWF() {
		return nodeWF;
	}
	public void setNodeWF(WorkFlow nodeWF) {
		this.nodeWF = nodeWF;
	}

	public String getNodeCode() {
		return nodeCode;
	}
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public NodePanel getPanel() {
		return panel;
	}
	public void setPanel(NodePanel panel) {
		this.panel = panel;
	}

	@Override
	public String toString() {
		return "Node [posX=" + posX + ", posY=" + posY + ", nodeWF=" + nodeWF + ", nodeCode=" + nodeCode + ", desc="
				+ desc + ", language=" + language + ", panel=" + panel + "]";
	}
	
	

	
}
