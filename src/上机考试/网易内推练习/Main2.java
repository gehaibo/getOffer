package 上机考试.网易内推练习;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Main2 {
    static class Point {
        int x, y;
        int step;
        boolean visited = false;
        boolean reachable = false;

        Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public Point() {
            // TODO Auto-generated constructor stub
        }

    }

    static int n, m; // map has n rows and m columns
    static int x0, y0; // start point
    static int stepTypes; // the ways to walk in each step
    static int dx[] = new int[50], dy[] = new int[50];// dx ,dy对应每一步可以走的移动量
    // dx=0,dy=1 为向右走一格。
    static Point map[][] = new Point[50][50];

    static {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Point();
            }
        }

    }

    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static boolean checkPosition(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m
                && map[x][y].reachable == true
                && map[x][y].visited == false);
    }

    public static int bfs() {
        //EscapeFromPrison e = new EscapeFromPrison();

        Queue<Point> queue = new LinkedList<Point>();
        Point startPoint = new Point(x0, y0, 0);
        map[x0][y0].visited = true;
        queue.add(startPoint);
        int maxSteps = 0;


        while (!queue.isEmpty()) {
            Point p = queue.poll();
            maxSteps = max(maxSteps, p.step);

            for (int i = 0; i < stepTypes; i++) {

                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (checkPosition(nextX, nextY))
                // next position is not visited and reachable
                {
                    Point q = new Point(nextX, nextY, p.step + 1);
                    map[nextX][nextY].visited = true;
                    queue.add(q);
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].reachable == true && map[i][j].visited != true) {
                    return -1;
                }

            }
        }

        return maxSteps;
    }

    public static void main(String[] args) {

        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            n = sin.nextInt();
            m = sin.nextInt();

            for (int i = 0; i < n; i++) {
                String dotLine = sin.next();
                // java does not support next char method
                for (int j = 0; j < m; j++) {
                    if (dotLine.charAt(j) == '.') {
                        map[i][j].reachable = true;
                    }

                }
            }
            x0 = sin.nextInt();
            y0 = sin.nextInt();

            stepTypes = sin.nextInt();

            for (int i = 0; i < stepTypes; i++) {
                dx[i] = sin.nextInt();
                dy[i] = sin.nextInt();
            }
        }

        int result = bfs();
        System.out.println(0);

    }
}
