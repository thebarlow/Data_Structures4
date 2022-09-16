import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> {
	private PriorityQueue<T> myQueue;
	private int max_size;
	private List<T> myList;
	
	public KBestCounter(int k){
		max_size=k;
		myQueue=new PriorityQueue<T>();
	}
	
	//Process next element in set of data
	//Should run in O(logk) time at worst.
	public void count(T x){
		//FIRST WE MAKE SURE THAT WE ONLY TAKE REAL INPUT
		if(x!=null){
			//IF WE'VE YET TO HIT CAPACITY, WE ADD ANY KEY VALUE OF TYPE T
			if(myQueue.size()<max_size){
					myQueue.add(x);
			}
			//ALREADY AT CAPACITY?
			//IF X IS BIGGER THAN(OR EQUAL TO) THE SMALLEST CURRENT ELEMENT (THE ROOT) WE ADD IT, AND REMOVE THE ROOT
			//OTHERWISE WE DO NOT ADD IT
			else{
				if(x.compareTo(myQueue.peek())>=0){
					T temp=myQueue.peek();
					myQueue.add(x);
					myQueue.remove(temp);
				}
			}
			
		}
	}
	//Return sorted list of k largest elements. Run in O(klogk). Restore priority queue when its done
	//If run subsequently, it should return the same values.
	public List<T> kbest(){
		List<T> myArr = new ArrayList<T>(myQueue);
		myArr.sort(Collections.reverseOrder());
		return myArr;
	}
}
