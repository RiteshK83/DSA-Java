class Solution {

    class Node {
        long[] prefix;
        int product;

        Node(int k) {
            prefix = new long[k];
            product = 1;
        }
    }

    int n, k;
    int[] nums;
    Node[] tree;

    // Merge two nodes
    Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            result.prefix[r] += left.prefix[r];
        }

        // Prefixes which continue into right
        for (int r = 0; r < k; r++) {

            int newRemainder = (left.product * r) % k;

            result.prefix[newRemainder] += right.prefix[r];
        }

        // Product of complete segment
        result.product = (left.product * right.product) % k;

        return result;
    }

    // Build segment tree
    void build(int node, int start, int end) {

        if (start == end) {

            tree[node] = new Node(k);

            int rem = nums[start] % k;

            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Point update
    void update(int node, int start, int end, int index, int value) {

        if (start == end) {

            nums[index] = value;

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    // Range query
    Node query(int node, int start, int end, int left, int right) {

        // Completely outside
        if (right < start || end < left) {
            return null;
        }

        // Completely inside
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        Node leftNode = query(
            2 * node,
            start,
            mid,
            left,
            right
        );

        Node rightNode = query(
            2 * node + 1,
            mid + 1,
            end,
            left,
            right
        );

        if (leftNode == null) {
            return rightNode;
        }

        if (rightNode == null) {
            return leftNode;
        }

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.nums = nums;
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        // Build initial tree
        build(1, 0, n - 1);

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // 1. Permanent update
            update(1, 0, n - 1, index, value);

            // 2. Query from start to end
            Node result = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            // 3. Number of prefixes with remainder x
            answer[q] = (int) result.prefix[x];
        }

        return answer;
    }
}