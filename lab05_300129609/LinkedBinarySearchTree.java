/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * LinkedBinarySearchTree for tree traversal lab
 * @author Lachlan Plant
 * @param <E>
 */
public class LinkedBinarySearchTree<E extends Comparable> implements Iterable<E>{
 
    private class Node<E>{
        E elem;
        Node<E> left;
        Node<E> right;
        public Node(E e, Node<E> l, Node<E> r){
            elem = e;
            left = l;
            right = r;
        }
    }
 
    private Node<E> root;
    private int size;
 
    /**
     *
     */
    public LinkedBinarySearchTree(){
        root = null;
        size = 0;
    }
 
    /**
     * Adds elem into BST
     * @param elem
     * @return
     */
    public boolean add(E elem){
        if(root == null){
            root = new Node<>(elem, null, null);
            size ++;
            return true;
        }
        else{
            root = insert(elem, root);
            return true;
        }
    }
 
    /**
     * Recursive BST insertion
     * @param elem
     * @param curr
     * @param from
     * @return
     */
    private Node<E> insert(E elem, Node<E> curr){
        if(curr == null){
            curr = new Node<>(elem, null, null);
            size ++;
            return curr;
        }
        if( elem.compareTo(curr.elem)<0){
            curr.left = insert(elem, curr.left);
        }
        if( elem.compareTo(curr.elem)>0){
            curr.right = insert(elem, curr.right);
        }
        return curr;
    }
 
 
 
    /*****************************************************************
     *
     * Recursive Printing Functions
     *
     *
     *****************************************************************/
 
    /**
     * Caller method for preorder recursive printing
     */
    public void printPreorderRecursive(){
        System.out.print("Recursive Preorder Printing: ");
        preorderRecursive(root);
    }
 
    /**
     * preorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void preorderRecursive(Node<E> curr){
        System.out.print(curr.elem + ", ");
        if (curr.left != null) {
            preorderRecursive(curr.left);
        }
        if (curr.right != null) {
            preorderRecursive(curr.right);
        }
    }
 
    /**
     * Caller method for inorder recursive printing
     */
    public void printInorderRecursive(){
        System.out.print("Recursive Inorder Printing: ");
        inorderRecursive(root);
    }
 
    /**
     * inorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void inorderRecursive(Node<E> curr){
        if (curr.left != null) {
            inorderRecursive(curr.left);
        }
        System.out.print(curr.elem + ", ");
        if (curr.right != null) {
            inorderRecursive(curr.right);
        }
    }
 
 
    /**
     * Caller method for postorder recursive printing
     */
    public void printPostorderRecursive(){
        System.out.print("Recursive Postorder Printing: ");
        postorderRecursive(root);
    }
 
    /**
     * postorder tree traversal, prints(curr.elem + ", ")
     * @param curr
     */
    private void postorderRecursive(Node<E> curr){
        if (curr.left != null) {
            postorderRecursive(curr.left);
        }
        if (curr.right != null) {
            postorderRecursive(curr.right);
        }
        System.out.print(curr.elem + ", ");
    }
 
 
 
    /*****************************************************************
     *
     * Iterator Functions
     *
     *
     *****************************************************************/
 
 
    public Iterator iterator(){
        return new InorderIterator();
    }
 
    public Iterator inorderIterator(){
        return new InorderIterator();
    }
 
    public Iterator preorderIterator(){
        return new PreorderIterator();
    }
 
 
    /*****************************************************************
     *
     * Iterators
     *
     *
     *****************************************************************/
 
 
 
 
    /**
     * Tree Iterator using preorder traversal for ordering
     */
    private class PreorderIterator implements Iterator<E>{
        Stack<Node<E>> stack = new Stack<Node<E>>();
 
        public PreorderIterator(){
            push(root);
        }
 
    private void push(Node<E> curr) {
      if(curr != null) {
        stack.push(curr);
      }
    }
 
        public boolean hasNext(){
            return !this.stack.empty();
        }
 
        public E next(){
      Node<E> curr = stack.pop();
      push(curr.right);
      push(curr.left);
      return curr.elem;
        }
 
        public void remove(){
            // not implemented
        }
    }
 
    /**
     * Tree Iterator using inorder traversal for ordering
     */
    private class InorderIterator implements Iterator<E>{
        Stack<Node<E>> stack = new Stack<Node<E>>();
 
        public InorderIterator(){
            push(root);
        }
 
    private void push(Node<E> curr) {
      if(curr != null) {
        this.stack.push(curr);
        push(curr.left);
      }
    }
 
        public boolean hasNext(){
            return !this.stack.empty();
        }
 
        public E next(){
      Node<E> curr = stack.pop();
      push(curr.right);
      return curr.elem;
        }
 
        public void remove(){
            // not implemented
        }
    }
}