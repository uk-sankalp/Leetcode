class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    Node root;
    List<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        int n = board.length, m = board[0].length;
        root = new Node();

        for (String s : words) {
            insert(s);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (root.mp.containsKey(board[i][j])) {
                    boolean[][] vis = new boolean[n][m];
                    vis[i][j] = true;
                    sol(board, vis, i, j, "" + board[i][j], root.mp.get(board[i][j]), n, m);
                }
            }
        }
 
        return ans;
    }

    void sol(char[][] board, boolean[][] vis, int i, int j, String s, Node root, int n, int m) {
        if (root.isEnd) {
            ans.add(s);
            root.isEnd = false;
        }

        for (int[] d : dir) {
            int a = i + d[0], b = j + d[1];
            if (a >= 0 && b >= 0 && a < n && b < m && !vis[a][b] && root.mp.containsKey(board[a][b])) {
                vis[a][b] = true;
                sol(board, vis, a, b, s + board[a][b], root.mp.get(board[a][b]), n, m);
                // System.out.println(root.mp);
                if (root.mp.get(board[a][b]).mp.isEmpty()) {
                    root.mp.remove(board[a][b]);
                }
                vis[a][b] = false;
            }
        }
    }

    void insert(String s) {
        Node tmp = root;

        for (char c : s.toCharArray()) {
            if (!tmp.mp.containsKey(c)) {
                tmp.mp.put(c, new Node());
            }

            tmp = tmp.mp.get(c);
        }

        tmp.isEnd = true;
    } 
}

class Node {
    Map<Character, Node> mp;
    boolean isEnd;

    Node() {
        mp = new HashMap<>();
        isEnd = false;
    }
}