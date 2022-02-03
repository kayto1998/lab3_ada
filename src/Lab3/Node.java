package Lab3;

public class Node<E> {
	protected E data;
	protected Node<E> left, right;
	
	public Node(E data) {
		this (data,null,null);
	}
	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
}
