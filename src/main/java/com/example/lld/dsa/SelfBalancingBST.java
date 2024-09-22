package com.example.lld.dsa;

import org.apache.commons.math3.geometry.partitioning.BSPTree;

import java.util.List;

public class SelfBalancingBST {
    public static void main(String[] args) {
        BSTree root = new BSTree();
        root.value = 10;
        insert(root, 20);
        insert(root, 30);
        insert(root, 15);
        insert(root, 18);
        insert(root, 5);
        insert(root, 4);
        insert(root, 3);
        insert(root, 2);
        insert(root, 1);
        insert(root, 0);
    }
    public static class BSTree {
        int value;
        BSTree left;
        BSTree right;
        int height;
    }
    List<BSTree> inorder(BSTree root) {
        return null;
    }
    static void insert(BSTree root, int value) {
        if (root == null) {
            root = new BSTree();
            root.value = value;
            root.height = 1;
            return;
        }
        if (value < root.value) {
            insert(root.left, value);
        } else {
            insert(root.right, value);
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        balanceBSTree(root);
    }
    static int height(BSTree root) {
        return root == null ? 0 : root.height;
    }
    static void balanceBSTree(BSTree root) {
        if (root == null) {
            return;
        }
        if (height(root.left) - height(root.right) > 1) {
            if (height(root.left.left) < height(root.left.right)) {
                root.left = leftRotate(root.left);
            }
            root = rightRotate(root);
        } else if (height(root.right) - height(root.left) > 1) {
            if (height(root.right.right) < height(root.right.left)) {
                root.right = rightRotate(root.right);
            }
            root = leftRotate(root);
        }
    }

    private static BSTree leftRotate(BSTree root) {
        BSTree newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    private static BSTree rightRotate(BSTree root) {
        BSTree newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }
}
