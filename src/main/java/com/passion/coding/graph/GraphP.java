package com.passion.coding.graph;

import java.util.*;

public class GraphP {

    public static class Node {
        int data;
        List<Node> adjacentNodes;
        boolean visited;

        public Node(int data) {
            this.data = data;
            this.adjacentNodes= new ArrayList<>();
            this.visited=false;
        }

        public void addAdjacentNode(Node node){
            adjacentNodes.add(node);
        }

        public List<Node> getAdjacentNodes() {
            return adjacentNodes;
        }
    }

    public void dfs(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.visited=true;
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data+" ");

            for (Node adjacentNode:node.getAdjacentNodes()){
                if(!adjacentNode.visited){
                    stack.push(adjacentNode);
                    adjacentNode.visited=true;
                }
            }
        }
    }

    public void bfs(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        root.visited=true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+" ");

            for (Node adjacentNode:node.getAdjacentNodes()){
                if(!adjacentNode.visited){
                    queue.add(adjacentNode);
                    adjacentNode.visited=true;
                }
            }
        }
    }


    public void bfsP(Node root) {
        if(root== null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.visited= true;
        while (!queue.isEmpty()) {
            Node temp= queue.poll();
            System.out.print(temp.data+" ");
            for(Node adjacentNode: temp.getAdjacentNodes()){
                if(adjacentNode != null && !adjacentNode.visited) {
                    queue.add(adjacentNode);
                    adjacentNode.visited=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphP.Node node40 = new GraphP.Node(40);
        GraphP.Node node10 = new GraphP.Node(10);
        GraphP.Node node20 = new GraphP.Node(20);
        GraphP.Node node30 = new GraphP.Node(30);
        GraphP.Node node60 = new GraphP.Node(60);
        GraphP.Node node50 = new GraphP.Node(50);
        GraphP.Node node70 = new GraphP.Node(70);

        node40.addAdjacentNode(node10);
        node40.addAdjacentNode(node20);
        node10.addAdjacentNode(node30);
        node20.addAdjacentNode(node10);
        node20.addAdjacentNode(node30);
        node20.addAdjacentNode(node60);
        node20.addAdjacentNode(node50);
        node30.addAdjacentNode(node60);
        node60.addAdjacentNode(node70);
        node50.addAdjacentNode(node70);
        System.out.println("The BFS traversal of the graph is ");
        GraphP graph = new GraphP();
        graph.bfs(node40);
        node40.visited=false;
        node10.visited=false;
        node20.visited=false;
        node30.visited=false;
        node60.visited=false;
        node50.visited=false;
        node70.visited=false;
        System.out.println();
        System.out.println("The DFS traversal of the graph is ");
        graph.dfs(node40);
    }
}
