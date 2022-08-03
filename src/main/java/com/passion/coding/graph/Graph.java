package com.passion.coding.graph;

import java.util.*;

public class Graph {


    public Graph() {
    }

    static class Node {
        int data;
        List<Node> adjacentNodes;
        boolean visited;

        public Node(int data) {
            this.data = data;
            this.adjacentNodes = new ArrayList<>();
        }

        public List<Node> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void addAdjacentNode(Node adjacentNode) {
            this.adjacentNodes.add(adjacentNode);
        }

        public void setAdjacentNodes(List<Node> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
    }

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            System.out.print(element.data + " ");
            for (Node adjacentNode : element.getAdjacentNodes()) {
                if (adjacentNode != null && !adjacentNode.visited){
                    queue.add(adjacentNode);
                adjacentNode.visited = true;
            }
        }
    }}

    public void dfsUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited=true;
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + " ");
            for (Node adjacentNode : element.getAdjacentNodes()) {
                if (adjacentNode != null && !adjacentNode.visited){
                    stack.add(adjacentNode);
                    adjacentNode.visited = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

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
        Graph graph = new Graph();
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
        graph.dfsUsingStack(node40);
    }
}
