package 上机考试.今日头条;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return o.x - this.x;
        }
    }

    private static void cal(Node[] node) {
        Arrays.sort(node);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int number = in.nextInt();
            Node[] nodes = new Node[number];
            for (int i = 0; i < number; i++) {
                nodes[i] = new Node(in.nextInt(), in.nextInt());
            }
            cal(nodes);
            StringBuilder sb = new StringBuilder();
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < number; i++) {
                if (nodes[i].y > temp) {
                    temp = nodes[i].y;
                    sb.insert(0, nodes[i].x + " " + nodes[i].y + "\r\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
