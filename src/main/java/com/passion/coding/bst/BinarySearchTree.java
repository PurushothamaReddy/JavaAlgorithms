package com.passion.coding.bst;


import com.passion.coding.bt.BinaryTree;
import com.passion.coding.linkedlist.DoubleLinkedList;

public class BinarySearchTree {
    public static class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int data) {
            this.data = data;
        }
    }


    public BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            System.out.println("Duplicates are not allowed");
        }
        return root;
    }

    // Iterative function to insert a key into a BST
    public static BSTNode insertIterative(BSTNode root, int key)
    {
        // start with the root node
        BSTNode curr = root;

        // pointer to store the parent of the current node
        BSTNode parent = null;

        // if the tree is empty, create a new node and set it as root
        if (root == null) {
            return new BSTNode(key);
        }

        // traverse the tree and find the parent node of the given key
        while (curr != null)
        {
            // update the parent to the current node
            parent = curr;

            // if the given key is less than the current node,
            // go to the left subtree; otherwise, go to the right subtree.
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        // construct a node and assign it to the appropriate parent pointer
        if (key < parent.data) {
            parent.left = new BSTNode(key);
        }
        else {
            parent.right = new BSTNode(key);
        }

        return root;
    }


    public boolean search(BSTNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) {
            return search(root.left, data);
        } else if (data > root.data) {
            return search(root.right, data);
        }

        return false;
    }

    public BSTNode insertP(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        }
        if (data < root.data) {
            root.left = insertP(root.left, data);
        } else if (data > root.data) {
            root.right = insertP(root.right, data);
        } else {
            System.out.println("Duplicates not allowed");
        }
        return root;
    }

    // leftmost element in binary search tree is minimum
    public static BSTNode minimumElement(BSTNode root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    // rightmost element in binary search tree is maximums
    public static BSTNode maximumElement(BSTNode root) {
        if (root.right == null)
            return root;
        else {
            return maximumElement(root.right);
        }
    }

    public void inOrder(BSTNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

    }

    // if inorder is not sorted then it is not BST
    public boolean isBST(BSTNode root, BSTNode previous) {

        if (root == null) {
            return true;
        }
        if (!isBST(root.left, previous)) {
            return false;
        }
        if (previous != null && root.data < previous.data) {
            return false;
        }
        previous = root;
        return isBST(root.right, previous);
    }

    public boolean isBSTP(BSTNode root, BSTNode previous) {
        if (root == null) {
            return true;
        }
        if (!isBSTP(root.left, previous)) {
            return false;
        }
        if (previous != null && previous.data > root.data) {
            return false;
        }
        previous = root;
        return isBSTP(root.right, previous);
    }
//https://medium.com/@rupeshmalkar/convert-a-binary-search-tree-to-a-balanced-binary-tree-2c9a59e766d2
    //    Initialise two variables start and end with 0 and arr.length -1.
//    Find middle element of array using start and end.
//    Make middle element root element of tree.
//    Recursively traverse left array, find middle and make it root node of left subtree
//    Recursively traverse right array, find middle and make it root node of right subtree.
    public BSTNode createBSTFromSortedArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode bstNode = new BSTNode(arr[mid]);
        bstNode.left = createBSTFromSortedArray(arr, start, mid - 1);
        bstNode.right = createBSTFromSortedArray(arr, mid + 1, end);
        return bstNode;
    }

//    In this method, we construct from leaves to root. The idea is to insert nodes in BST in the same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
//    While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
//    public BSTNode createBSTFromSortedLinkedList(int n){
//        if(n<=0){
//            return null;
//        }
//
//        BSTNode left = createBSTFromSortedLinkedList(n/2);
//        BSTNode root= new BSTNode(head.data);
//head=head.next;
//root.left=left;
//
//        root.right = createBSTFromSortedLinkedList(n-n/2-1);
//        return root;
//    }


//    public TreeNode sortedListToBST(ListNode head, ListNode end) {
//        if (end.next == head) { //basically same ideas as start > end; occurs when one node left so head > midPrev and mid.next > end
//            return null;
//        }
//        ListNode midPrev = findMidPrev(head, end);
//        ListNode mid = midPrev.next;
//        TreeNode node = new TreeNode(mid.val);
//        node.left = sortedListToBST(head, midPrev);
//        node.right = sortedListToBST(mid.next, end);
//
//        return node;
//    }
//    //return node previous to mid
//    public ListNode findMidPrev(ListNode head, ListNode end) {
//        ListNode slowPrev = new ListNode(0);
//        slowPrev.next = head;
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast.next != end && fast != end && fast.next != null && fast != null) {
//            slowPrev = slowPrev.next;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slowPrev;
//    }

    public BSTNode lowestCommonAncestorForBinarySearchTree(BSTNode root, BSTNode a, BSTNode b) {
        if (root == null)
            return null;
        ;
        if (root.data > a.data && root.data > b.data) {
            return lowestCommonAncestorForBinarySearchTree(root.left, a, b);
        } else if (root.data < a.data && root.data < b.data) {
            return lowestCommonAncestorForBinarySearchTree(root.right, a, b);
        }
        // if you reach at this place, then it is LCA for given two nodes because a and b are on either side of root.
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode rootNode = new BSTNode(40);
        bst.insert(rootNode, 20);
        bst.insert(rootNode, 30);
        bst.insert(rootNode, 10);
        bst.insert(rootNode, 60);
        bst.insert(rootNode, 50);
        bst.insert(rootNode, 70);
        bst.insert(rootNode, 70);
        bst.inOrder(rootNode);
        System.out.println();
        System.out.println("search node 10:" + bst.search(rootNode, 10));
        System.out.println("Minimum element in BST:" + bst.minimumElement(rootNode).data);
        System.out.println("Maximum element in BST:" + bst.maximumElement(rootNode).data);
        System.out.println("Is banary tree is BST:" + bst.isBST(rootNode, null));

        System.out.println("BST from sorted Array");
        int arr[] = {10, 20, 30, 40, 50, 60, 70};
        BSTNode rootNew = bst.createBSTFromSortedArray(arr, 0, arr.length - 1);
        bst.inOrder(rootNew);
        System.out.println();
        System.out.println("LCA of 50 and 70:" + bst.lowestCommonAncestorForBinarySearchTree(rootNode, new BSTNode(70), new BSTNode(50)).data);
    }
}
