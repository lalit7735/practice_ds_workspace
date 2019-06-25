import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ZeroRangeArray {

	public static void main(String[] args) {
		int[] arr={2,4,-2,-2,5,6,-2,-1,-8,3,-3};
		
		for(int i=0;i<arr.length;i++){
			int sum=0;
			sum=sum+arr[i];
			for(int j=i+1;j<arr.length;j++){
				sum=sum+arr[j];
				if(sum == 0){
					System.out.println(" range :"+i+" to "+j);
				}
			}
		}
		array();
		findSum();
	}
	
	private static void findSum() {
		int sum=12;
		int[] array={1,2,3,4,5,6,7,8,9,10};
		int i=0;
		int j=array.length-1;
		while(i<j){
			Integer tempSum=array[i]+array[j];
			if(sum == tempSum){
				System.out.println(" pairs:"+array[i]+"---"+array[j]);
				break;
			}else if(sum < tempSum){
				j--;
			}else{
				i++;
			}
		}
	}

	public static void array(){
		Integer sum=0;
		Map<Integer,Integer> preserve=new HashMap<>();
		int[] arr={2,4,-2,-2,5,6,-2,-1,-8,3,-3};
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
			if(preserve.get(arr[i])!=null){
				System.out.println(" Range :"+preserve.get(arr[i])+" to "+i);
			}
			preserve.put(sum,i);	
		}
	}
}
