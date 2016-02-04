// top k frequent elements
import java.util.*;

class Pair{
	int value;
	int count;
	Pair(int value, int count){
		this.value = value;
		this.count = count;
	}
}

public class solution {
		public static int[] topKElements(int[] arr, int k) {
//            corner case
			if (arr==null || arr.length<=1) return arr;
			HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
			for (int i : arr) {
				if (hs.containsKey(i)) {
					hs.put(i, hs.get(i)+1);
				}
				else {
					hs.put(i, 1);
				}
			}
//			override compare method
			Comparator<Pair> cmp = new Comparator<Pair>() {
				public int compare(Pair a, Pair b) {
					return a.count - b.count;
				}
			};
//			create a size k min heap
			PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, cmp);
			for(Map.Entry<Integer, Integer> entry : hs.entrySet()) {
				if(minHeap.size()<k) {
					minHeap.add(new Pair(entry.getKey(), entry.getValue()));
				}
				else{
					if(minHeap.peek().count<entry.getValue()) {
						minHeap.poll();
						minHeap.add(new Pair(entry.getKey(), entry.getValue()));
					}
				}
			}
			int[] res = new int[minHeap.size()];
			for (int i=0; i<res.length; i++) {
				res[i] = minHeap.poll().value;
			}
			return res;
		}
		
		public static String reverseString(String s) {
			char[] c = s.toCharArray();
			int len = c.length;
			for(int i=0; i<len/2; i++){
				char temp = c[i];
				c[i] = c[len-i-1];
				c[len-i-1] = temp;
			}
			return new String(c);
		}
		
		public static String ItoString(List<Integer> i) {
			Integer[] k = new Integer[i.size()];
			k = i.toArray(k);
			return Arrays.toString(k);
			
		}
		
		public static String StoString(List<String> i) {
			String[] k = new String[i.size()];
			k = i.toArray(k);
			return Arrays.toString(k);
			
		}
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        int[] a = {1,1,1,2,2,2,3,3,3,4,4,4,4,4,5,6,6};
	        int k = 2;
	        int[] res = topKElements(a, k);
	        System.out.println(Arrays.toString(res));
		}
	
		
	
}
