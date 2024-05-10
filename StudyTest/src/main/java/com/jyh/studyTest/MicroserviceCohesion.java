package com.jyh.studyTest;

import java.util.*;

public class MicroserviceCohesion {

    // 找到所有的环
    private static List<List<Integer>> findAllCycles(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> cycles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            Set<Integer> currentPath = new HashSet<>();
            int currentNode = i;

            while (!visited[currentNode]) {
                visited[currentNode] = true;
                currentPath.add(currentNode);
                currentNode = edges[currentNode];
            }

            if (currentPath.contains(currentNode)) {
                List<Integer> cycle = new ArrayList<>();
                int startNode = currentNode;
                do {
                    cycle.add(currentNode);
                    currentNode = edges[currentNode];
                } while (currentNode != startNode);

                Collections.sort(cycle);
                cycles.add(cycle);
            }
        }

        return cycles;
    }

    // 找到访问到环的节点数量
    private static int countAccessibleNodes(int start, int[] edges, Set<Integer> cycleNodes) {
        int count = 0;
        int currentNode = start;

        while (!cycleNodes.contains(currentNode)) {
            count++;
            currentNode = edges[currentNode];
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = sc.nextInt();
        }

        List<List<Integer>> cycles = findAllCycles(edges);
        List<CohesionGroup> cohesionGroups = new ArrayList<>();

        // 计算每个环的L和V
        for (List<Integer> cycle : cycles) {
            int l = cycle.size();
            Set<Integer> cycleNodes = new HashSet<>(cycle);

            int v = 0;
            for (int i = 0; i < n; i++) {
                if (!cycleNodes.contains(i)) {
                    int accessibleCount = countAccessibleNodes(i, edges, cycleNodes);
                    v += accessibleCount > 0 ? 1 : 0;
                }
            }

            int h = l - v;

            cohesionGroups.add(new CohesionGroup(cycle, h));
        }

        // 按照内聚值和环中最大的数字排序
        cohesionGroups.sort((a, b) -> {
            if (a.h != b.h) {
                return Integer.compare(b.h, a.h);  // H值大的优先
            } else {
                return Integer.compare(Collections.max(b.cycle), Collections.max(a.cycle));  // 环中最大的数字
            }
        });

        // 输出最优的环
        List<Integer> bestCycle = cohesionGroups.get(0).cycle;
        for (int node : bestCycle) {
            System.out.print(node + " ");
        }
    }

    static class CohesionGroup {
        List<Integer> cycle;
        int h;

        CohesionGroup(List<Integer> cycle, int h) {
            this.cycle = cycle;
            this.h = h;
        }
    }
}
