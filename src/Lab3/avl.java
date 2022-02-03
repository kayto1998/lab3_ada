package Lab3;

import java.util.ArrayList;

public class avl<E extends Comparable<E>>{
	
	class Node {
		protected E data;
		protected Node left, right;
		protected int bf;
		
		public Node(E data) {
			this (data,null,null);
		}
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.bf = 0;
		}
	}
	
	protected Node root;
	private boolean height;
	
	public boolean isEmpty() { 
	
		return this.root == null; 
	
	}
	
	public void insert(E x) {
		this.height = false;
		this.root = insert(x, this.root);
	}
	
	protected Node insert(E x, Node node) {
		Node r = node;
		if (node == null) {
			this.height = true;
			r = new Node (x);
		}
		else {
			int rC = node.data.compareTo(x);
			if(rC < 0) {
				r.right = insert(x, node.right);
				if(this.height)
					switch(r.bf) {
					case -1: r.bf = 0;
						this.height = false;
						break;
					case 0: r.bf = 1;
						this.height = true;
						break;
					case 1: r = balanceToLeft(r);
						this.height = false;
						break;
					}
			}
			else { 
				r.left = insert(x, node.left);
				if(this.height)
					switch(r.bf) {
					case 1: r.bf = 0;
						this.height = false;
						break;
					case 0: r.bf = -1;
						this.height = true;
						break;
					case -1: r = balanceToRight(r);
						this.height = false;
						break;
					}
			
			}
		}
		return r;
	}
	
	private Node balanceToRight(Node node){
		
		Node x = node.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = node;
        node.left = T2;

        // Update heights
        node.bf = Math.max(height(node.left), height(node.right))+1;
        x.bf = Math.max(height(x.left), height(x.right))+1;

        // Return new root
        return x;
	}
	
	
	private Node balanceToLeft(Node node){
		Node hijo = node.right;
		switch(hijo.bf) {
		case 1: 
			node.bf = 0;
			hijo.bf = 0;
			node = rotateSL(node);
			break;
		case -1:
			Node nieto = hijo.left;
			switch(nieto.bf) {
			case -1: node.bf = 0;hijo.bf = -1; break;
			case 0: node.bf = 0; hijo.bf = 0; break;
			case 1: node.bf = 1; hijo.bf = 0; break;
			
			}
			nieto.bf =0;
			
			node.right = rotateSR(hijo);
			node = rotateSL(node);
		}
		return node;
	}
	
	
	private Node rotateSL(Node node){
		Node p = node.right;
		node.right = p.left;
		p.left = node;
		node = p;
		return node;
	}
	
	private Node rotateSR(Node node){
		Node p = node.left;
		node.left = p.right;
		p.right = node;
		node = p;
		return node;
	}

	protected void dfs(Node actual, ArrayList<Integer> lista){
		lista.add((Integer) actual.data);
		if (actual.left != null) 
			dfs(actual.left, lista);
		
		if (actual.right != null) 
			dfs(actual.right,lista);
	}
	
	protected void bfs(Node actual, ArrayList<Integer> lista){
		ArrayList<Node> arr = new ArrayList<Node>();
		arr.add(actual);
		while(arr.size()>0) {
			Node pivot = arr.get(0);
			arr.remove(0);
			lista.add((Integer) pivot.data);
			if(pivot.left != null)
				arr.add(pivot.left);
			if(pivot.right != null)
				arr.add(pivot.right);
		}
		
	}
	
	private int height (Node N) {
        if (N == null)
            return 0;
        return N.bf;
    }
}

