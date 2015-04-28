package AlgorithmOnlineCourse;

public class QuickUnionUF {

	private static int[] id;

	public QuickUnionUF(int N){
	      id = new int[N];
	      for (int i = 0; i < N; i++){
	    	  	id[i] = i;
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
		id[i] = j;
	}
	
	public static void main(String[] args) {
		QuickUnionUF q = new QuickUnionUF(10);
		q.union(8, 6);
		q.union(8, 7);
		q.union(5, 3);
		q.union(1, 2);
		q.union(4, 9);
		q.union(8, 5);
		q.union(1, 4);
		q.union(4, 8);
		q.union(3, 0);
		for(int i : id){
			System.out.print(i + " ");
		}
	}

}
