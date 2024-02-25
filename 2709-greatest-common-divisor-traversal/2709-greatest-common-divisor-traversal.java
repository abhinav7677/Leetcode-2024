class Solution {

    public List<Integer> get_factors(int N){

        List<Integer> factors = new ArrayList<Integer>();

        for(int i = 2 , end = ((int) Math.sqrt(N)) ; (i <= end) ; i++){

            while((N % i) == 0){
                factors.add(i);
                N /= i;
            }
        }
        if(N > 1){
            factors.add(N);
        }
        return factors;
    }

    public void dfs(int curr , Map<Integer , List<Integer>> adj , Set<Integer> visited){

        visited.add(curr);

        for(int neighbour : adj.getOrDefault(curr , (new ArrayList<Integer>()))){

            if(!visited.contains(neighbour)){

                dfs(neighbour , adj , visited);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] array){
        
        int N = array.length;

        Map<Integer , Integer> gcd_map = new HashMap();

        Map<Integer , List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; (i < N) ; i++){

            for(int factor : get_factors(array[i])){

                if(gcd_map.get(factor) != null){

                    int node_1 = i;

                    int node_2 = gcd_map.get(factor);

                    adj.computeIfAbsent(node_1 , (k -> (new ArrayList<Integer>()))).add(node_2);

                    adj.computeIfAbsent(node_2 , (k -> (new ArrayList<Integer>()))).add(node_1);
                }

                gcd_map.put(factor , i);
            }
        }

        Set<Integer> visited = new HashSet<Integer>();

        dfs(0 , adj , visited);

        return (visited.size() == N);
    }
}