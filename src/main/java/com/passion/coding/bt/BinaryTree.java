package com.passion.coding.bt;


import java.util.*;

public class BinaryTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        return rootNode;
    }

    public TreeNode createBinaryTree2() {

        TreeNode rootNode = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        rootNode.left = node50;
        rootNode.right = node70;

        return rootNode;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }

    }

    public void preOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            System.out.printf("%s ", current.data);
            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }
    }


    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

    }

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void levelOrderTraversalP(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left!= null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void printZigZagTraversal(TreeNode rootNode) {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            TreeNode node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public void printLeafNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }


    public void printAllPaths(TreeNode root, int[] path, int len) {
        if (root == null) {
            return;
        }
        path[len++] = root.data;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < len; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        }
        printAllPaths(root.left, path, len);
        printAllPaths(root.right, path, len);
    }

    public int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public int levelOfNode(TreeNode root, int key, int level) {
        if (root == null) {
            return 0;
        }
        if (root.data == key) {
            return level;
        }
        int result = levelOfNode(root.left, key, level + 1);
        if (result != 0) {
            return result;
        }
        result = levelOfNode(root.right, key, level + 1);
        return result;
    }

    public int getMaximumRec(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int value = 0;
        int left, right;
        if (root != null) {
            value = root.data;
            left = getMaximumRec(root.left);
            right = getMaximumRec(root.right);

            if (left > right) {
                max = left;
            } else {
                max = right;
            }

            if (max < value) {
                max = value;
            }
        }

        return max;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return null;
        if (root.data == a.data || root.data == b.data)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        // If we get left and right not null , it is lca for a and b
        if (left != null && right != null)
            return root;
        if (left == null)
            return right;
        else
            return left;

    }

    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            return (root1.data == root2.data) && isIdentical(root1.left, root2.left) &&
                    isIdentical(root1.right, root2.right);
        }
        return false;
    }

    public boolean isSubTreeExist(TreeNode main, TreeNode sub) {
        if (sub == null) {
            return true;
        }

        if (main == null) {
            return false;
        }
        if (isIdentical(main, sub)) {
            return true;
        }
        return isSubTreeExist(main.left, sub) || isSubTreeExist(main.right, sub);
    }

    public TreeNode mirrorOfBT(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode mirror = new TreeNode(root.data);
        mirror.left = mirrorOfBT(root.right);
        mirror.right = mirrorOfBT(root.left);
        return mirror;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + root.data + sum(root.right);
    }

    //1.Sum of left & right node is equal to root node.
    //2.this rule applicable for left subtree and right subtree.
    public boolean isSumTree(TreeNode root) {
        if (root == null || root.left == null || root.right == null)
            return true;
        int ls, rs;
        ls = sum(root.left);
        rs = sum(root.right);
        return (ls + rs) == root.data && isSumTree(root.left) && isSumTree(root.right);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh, rh;
        lh = height(root.left);
        rh = height(root.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //height or depth ofa binary tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode rootNode = bt.createBinaryTree();
        System.out.println("In order:");
        bt.inOrder(rootNode);
        System.out.println();
        System.out.println("Pre order:");
        bt.preOrder(rootNode);
        System.out.println();
        System.out.println("Post order:");
        bt.postOrder(rootNode);
        System.out.println();
        System.out.println(" Level Order:");
        bt.levelOrderTraversal(rootNode);
        System.out.println();
        System.out.println(" Spiral/Zig-zag Order:");
        bt.printZigZagTraversal(rootNode);
        System.out.println();
        System.out.println(" Count Leaf Nodes:" + bt.countLeafNodes(rootNode));
        System.out.println();
        System.out.println(" Print Leaf Nodes:");
        bt.printLeafNodes(rootNode);
        System.out.println();
        System.out.println(" Print All Paths:");
        bt.printAllPaths(rootNode, new int[20], 0);
        System.out.println("Level of a node 70:" + bt.levelOfNode(rootNode, 70, 1));
        System.out.println("Level of a node 20:" + bt.levelOfNode(rootNode, 20, 1));
        System.out.println("Get Maximum values:" + bt.getMaximumRec(rootNode));
        System.out.println("LCA of 50 and 10:" + bt.lowestCommonAncestor(rootNode, new TreeNode(10), new TreeNode(50)).data);

        System.out.println("Is Two binary trees are identical1:" + bt.isIdentical(rootNode, rootNode));
        System.out.println("Is Two binary trees are identical2:" + bt.isIdentical(rootNode, bt.createBinaryTree2()));

        System.out.println("Is Sub tree exist in main binary tree:" + bt.isSubTreeExist(rootNode, bt.createBinaryTree2()));
        System.out.println("In order:");
        bt.inOrder(rootNode);
        System.out.println();
        System.out.println("Mirror Image inorder:");
        bt.inOrder(bt.mirrorOfBT(rootNode));
        System.out.println();
        System.out.println("IS bt is sum tree:" + bt.isSumTree(rootNode));
        System.out.println("IS bt is balanced tree:" + bt.isBalanced(rootNode));

    }
}
