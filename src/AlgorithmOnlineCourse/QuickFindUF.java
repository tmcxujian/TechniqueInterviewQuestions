package AlgorithmOnlineCourse;

public class QuickFindUF {
	private static int[] id;

	public QuickFindUF(int N){
	      id = new int[N];
	      for (int i = 0; i < N; i++){
	    	  	id[i] = i;
	      }
	}

	public static boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public static void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}
	
	public static void main(String[] args){
		QuickFindUF q = new QuickFindUF(10);
		q.union(3, 0);
		q.union(5, 4);
		q.union(9, 2);
		q.union(7, 0);
		q.union(4, 6);
		q.union(2, 0);
		for(int i : id){
			System.out.print(i + " ");
		}
	}
}
