package AlgorithmOnlineCourse;

public class QuickUnionWithWeighed {
	private static int[] id;
	private static int[] sz;

	public QuickUnionWithWeighed(int N){
	      id = new int[N];
	      for (int i = 0; i < N; i++){
	    	  	id[i] = i;
	      }
	      sz = new int[N];
	      for (int i = 0; i < N; i++){
	    	  	sz[i] = i;
	      }
	}

	private static int root(int i){
		while(i != id[i]){
			i = id[i];
		}
		return i;
	}
	
	public static boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public static void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i == j){
			return;
		}
		if(sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}
		else{
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	public static void main(String[] args) {
		QuickUnionWithWeighed q = new QuickUnionWithWeighed(10);
		q.union(5, 1);
		q.union(4, 7);
		q.union(8, 0);
		q.union(4, 6);
		q.union(1, 8);
		q.union(7, 3);
		q.union(2, 7);
		q.union(2, 9);
		q.union(3, 5);
		for(int i : id){
			System.out.print(i + " ");
		}
	}

}
