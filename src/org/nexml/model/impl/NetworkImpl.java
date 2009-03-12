package org.nexml.model.impl;

import java.util.HashSet;
import java.util.Set;

import org.nexml.model.Edge;
import org.nexml.model.Network;
import org.nexml.model.NetworkObject;
import org.nexml.model.Node;
import org.w3c.dom.Document;

abstract class NetworkImpl<E extends Edge> extends SetManager<NetworkObject> implements Network<E> {


	public NetworkImpl(Document document) {
		super(document);
		// TODO Auto-generated constructor stub
	}

	@Override
	String getTagName() {
		return "network";
	}

	abstract public E createEdge(Node source, Node target);

	public Node createNode() {
		NodeImpl node = new NodeImpl(getDocument());
		addThing(node);
		getElement().insertBefore(node.getElement(),getElement().getFirstChild());
		return node;
	}

	public Set<E> getEdges() { 
		Set<E> edges = new HashSet<E>();
		for (NetworkObject networkObject : getThings()) { 
			if (networkObject instanceof Edge) { 
				@SuppressWarnings("unchecked")
				E edge = (E)networkObject;
				edges.add(edge);
			}
		}
		return edges;
	}
	
	public void removeEdge(E edge) {
		removeThing(edge);
		getElement().removeChild(((EdgeImpl)edge).getElement());
	}

	public Set<Node> getNodes() { 
		Set<Node> nodes = new HashSet<Node>();
		for (NetworkObject networkObject : getThings()) { 
			if (networkObject instanceof Node) { 
				nodes.add((Node)networkObject);
			}
		}
		return nodes;
	}
	
	
	public void removeNode(Node node) {
		removeThing(node);
		getElement().removeChild(((NodeImpl)node).getElement());
	}

}
