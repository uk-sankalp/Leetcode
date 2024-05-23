import java.util.*;

class point {
    int x;
    boolean start;
    int height;

    public point(int x, boolean start, int height) {
        this.x = x;
        this.start = start;
        this.height = height;
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        point[] points = new point[buildings.length*2];
        for (int i = 0; i < buildings.length; i++) {
            point start = new point(buildings[i][0], true, buildings[i][2]);
            point end = new point(buildings[i][1], false, buildings[i][2]);
            points[2*i] = start;
            points[2*i + 1] = end;
        }
        Arrays.sort(points, new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if (o1.x != o2.x)
                    return (o1.x-o2.x);
                else {
                    if (o1.start && o2.start) // Both are start points
                        return o2.height - o1.height; // Larger height first
                    else if (!o1.start && !o2.start) // Both are end points
                        return o1.height - o2.height; // Smaller height first
                    else // One is start, another is end
                        return o1.start ? -1 : 1; // Start point first
                }
            }
        });
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        maxHeap.put(0,1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < points.length; i++) {
            point current = points[i];
            if (current.start) {
                int maxH = maxHeap.firstKey();
                if (current.height > maxH) {
                    maxHeap.put(current.height, 1);
                    result.add(new ArrayList<>(Arrays.asList(current.x, current.height)));
                } else {
                    if (maxHeap.keySet().contains(current.height)) maxHeap.put(current.height,maxHeap.get(current.height)+1);
                    else maxHeap.put(current.height,1);
                }
            } else {
                if (current.height == maxHeap.firstKey()) {
                    maxHeap.put(current.height,maxHeap.get(current.height)-1);
                    if (maxHeap.get(current.height) <= 0) maxHeap.remove(current.height);
                    if (current.height != maxHeap.firstKey()) result.add(new ArrayList<>(Arrays.asList(current.x, maxHeap.firstKey())));
                } else {
                    maxHeap.put(current.height,maxHeap.get(current.height)-1);
                    if (maxHeap.get(current.height) <= 0) maxHeap.remove(current.height);
                }
            }
        }
        return result;
    }
}