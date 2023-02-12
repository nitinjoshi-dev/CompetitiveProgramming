package com.concept.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> rootNode = null;

    private int size;

    public BinaryTree() {

    }

    public BinaryTree(List<T> elements) {
        createBinaryTree(elements);
    }

    public Node<T> createBinaryTree(List<T> elements) {
        size = elements.size();
        for (T element : elements) {
            Node<T> node = new Node<>(element);
            if (rootNode == null) {
                rootNode = node;
            } else {
                addNode(rootNode, node);
            }
        }
        return rootNode;
    }

    public void inOrder() {
        inOrder(rootNode);
    }
    public void preOrder() {
        preOrder(rootNode);
    }
    public void postOrder() {
        postOrder(rootNode);
    }

    public void bfs() {
        List<Node<T>> nodes = new ArrayList<>(size);
        nodes.add(rootNode);
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            System.out.println(node.getElement());
            if (node.getLeftNode() != null)
                nodes.add(node.getLeftNode());
            if (node.getRightNode() != null)
                nodes.add(node.getRightNode());
        }
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getLeftNode());
            System.out.println(node.getElement());
            inOrder(node.getRightNode());
        }
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node.getElement());
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.getLeftNode());
            postOrder(node.getRightNode());
            System.out.println(node.getElement());
        }
    }


    public void addNode(Node<T> rootNode, Node<T> nodeToAdd) {
        if (rootNode.getElement().compareTo(nodeToAdd.getElement()) >= 0) {
            if (rootNode.getLeftNode() == null) {
                rootNode.setLeftNode(nodeToAdd);
            } else {
                addNode(rootNode.getLeftNode(), nodeToAdd);
            }
        } else {
            if (rootNode.getRightNode() == null) {
                rootNode.setRightNode(nodeToAdd);
            } else {
                addNode(rootNode.getRightNode(), nodeToAdd);
            }
        }
    }

    static class Node<T> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T element;

        public Node(T element) {
            super();
            this.element = element;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

    }
}
