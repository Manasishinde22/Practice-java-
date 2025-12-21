**Purpose:** Core DSA + Backend Logic practice for Java Backend / SDE interviews

---

## 🟦 QUESTION SET 1 – GRAPH PROBLEMS

---

### 1️⃣ `TaskScheduler.java`

**Pattern:** Graph – Cycle Detection (Directed Graph)
**Core Idea:**

* Tasks depend on each other → directed graph
* If a cycle exists → tasks can’t be completed

**Logic:**

* Use **DFS with recursion stack** OR **Kahn’s Algorithm**
* If we cannot process all nodes → cycle exists

**Key Concepts Used:**

* Graph adjacency list
* Indegree array
* Queue (BFS)

---

### 2️⃣ `TopoSort.java`

**Pattern:** Topological Sort (Kahn’s Algorithm)

**Logic:**

1. Count indegree of every node
2. Push nodes with indegree 0 into queue
3. Remove node → reduce indegree of neighbors
4. If all nodes processed → valid order

**Why it works:**

* DAG guarantees ordering
* Used in scheduling, build systems, pipelines

---

### 3️⃣ `ReachableServer.java`

**Pattern:** Graph Traversal – BFS

**Logic:**

* Model servers as nodes
* Connections as edges
* Use BFS to check reachability

**Why BFS:**

* Level-wise traversal
* Guaranteed shortest path in unweighted graph

---

### 4️⃣ `LongestPathDAG.java`

**Pattern:** Graph + DP on DAG

**Logic:**

1. Perform topological sort
2. DP[node] = longest path till that node
3. For every edge u → v:

   ```
   dp[v] = max(dp[v], dp[u] + 1)
   ```

**Why DAG is important:**

* No cycles → no infinite paths

---

### 5️⃣ `LargestColorValue.java`

**Pattern:** Graph + DP (DP on DAG with Cycle Detection)

**Logic:**

* If cycle exists → return -1
* Else:

  * dp[node][color] = max count of that color till node
  * Propagate DP in topological order

**Key Insight:**

* Combine **topo sort + DP**
* Track color frequency instead of path length

---

## 🟦 QUESTION SET 2 – DYNAMIC PROGRAMMING

---

### 6️⃣ `Knapsack.java`

**Pattern:** 0/1 Knapsack

**Logic:**

* dp[i][w] = max value using first i items within weight w
* Choice:

  * Take item
  * Skip item

**Transition:**

```
dp[i][w] = max(dp[i-1][w],
               value[i] + dp[i-1][w-weight[i]])
```

---

### 7️⃣ `MinCostCut.java`

**Pattern:** Interval DP

**Logic:**

* Add boundaries: 0 and n
* dp[i][j] = min cost to cut stick between cuts[i] and cuts[j]
* Try every possible cut k between i and j

**Why interval DP:**

* Problem splits into left & right subproblems

---

### 8️⃣ `MinCostCuts.java`

**Pattern:** Interval DP (Optimized variant)

**Logic:**

* Same as MinCostCut
* Uses sorted cuts and memoization

**Key Insight:**

* Order of cuts affects cost
* Try all possibilities, choose minimum

---

### 9️⃣ `MinCostClimbing.java`

**Pattern:** DP – Climbing Stairs

**Logic:**

* dp[i] = min cost to reach step i
* Can climb 1 or 2 steps

**Transition:**

```
dp[i] = cost[i] + min(dp[i-1], dp[i-2])
```

---

### 🔟 `AssignmentDP.java`

**Pattern:** DP with State Compression (Bitmask DP)

**Logic:**

* Use bitmask to represent completed tasks
* dp[mask] = minimum cost to reach this state
* Try assigning next unpicked task

**Why Bitmask:**

* Efficient when N ≤ 15–20
* Replaces nested loops

---

## 🟦 QUESTION SET 3 – BACKEND / HASHMAP / GREEDY

---

### 1️⃣1️⃣ `HighValueUsers.java`

**Pattern:** HashMap + Aggregation (SQL GROUP BY equivalent)

**Logic:**

* userId → totalOrderAmount
* Filter users where total > threshold

**SQL Equivalent:**

```sql
SELECT userId
FROM orders
GROUP BY userId
HAVING SUM(amount) > 1000;
```

---

### 1️⃣2️⃣ `MostFrequentAPI.java`

**Pattern:** HashMap Frequency Count

**Logic:**

* Count API calls
* Return API with max frequency

**Why HashMap:**

* O(1) insertion and lookup

---

### 1️⃣3️⃣ `MaxAPICaller.java`

**Pattern:** HashMap + Max Tracking

**Logic:**

* Track API → count
* Maintain maxCount variable
* Return API with highest usage

---

### 1️⃣4️⃣ `TopKFrequent.java`

**Pattern:** Heap (PriorityQueue) + HashMap

**Logic:**

1. Count frequency using HashMap
2. Use min-heap of size K
3. Remove smaller frequency when heap exceeds K

**Why Heap:**

* Efficient top-K retrieval
* Time: O(n log k)

---

## 🟦 QUESTION SET 4 – SQL

---

### 1️⃣5️⃣ `orders.sql`

**Pattern:** SQL Aggregation

**Logic:**

* GROUP BY customer/user
* SUM order amounts
* Filter using HAVING

**Key Difference:**

* WHERE → filters rows
* HAVING → filters groups
