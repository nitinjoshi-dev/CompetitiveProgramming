package com.concept.practice.tree;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        createBinaryTree(Arrays.asList(30, 40, 10, 20, 50));
    }

    private static void createBinaryTree(List<Integer> elements) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.createBinaryTree(elements);
        System.out.println("InOrder ");
        binaryTree.inOrder();
        System.out.println("PreOrder ");
        binaryTree.preOrder();
        System.out.println("PostOrder ");
        binaryTree.postOrder();
        System.out.println("BFS ");
        binaryTree.bfs();
    }
}
