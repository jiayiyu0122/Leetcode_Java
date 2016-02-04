class Pair{
	int value;
	int count;
	Pair(int value, int count){
		this.value = value;
		this.count = count;
	}
}


public class Solution {
	public static int[] calculateQuantiles(Pair[] pair, int Q, int M){
		int N = 0;
		for(Pair p : pair){
			N += p.count;
			System.out.println(N);
		}
		Arrays.sort(pair, new Comparator<Pair>(){
			public int compare(Pair a, Pair b){
				return a.value - b.value;
			}
		});
		int[] res = new int[Q-1];
		for(int i=1; i<=Q-1; i++){
			int index = (int)Math.ceil((N*i)/(Q*1.0));
			for(Pair p : pair){
				if(p.count>=index){
					res[i-1] = p.value; 
					break;
				}
				else{
					index -= p.count;
				}
			}
			
		}
		
		return res;
	}

    public static void main(String[] args){
    	Pair p1 = new Pair(5,1);
    	Pair p2 = new Pair(6,1);
    	Pair p3 = new Pair(3,1);
    	Pair[] p = {p1,p2,p3};
    	int[] res = calculateQuantiles(p,2,3);
    	System.out.println(Arrays.toString(res));
    	
    	Pair[] p4 = {new Pair(2,1),new Pair(3,2),new Pair(5,3),new Pair(6,1),new Pair(8,1),new Pair(11,1),new Pair(12,1),new Pair(15,2),new Pair(18,2),new Pair(19,1)};
    	int[] res1 = calculateQuantiles(p4,5,10);
    	System.out.println(Arrays.toString(res1));
    	
    }

}