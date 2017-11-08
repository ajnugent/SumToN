import java.util.*;

class Proj1 {

    public static void addNext(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list, int sum, int last, int target, boolean isFirst) {
        
        if (sum == target) {
        	results.add(list);
        	return;
        }
            
            
        while (sum + last > target) {
            last--;
        }

        int less = last - 1;
        
        if ( !isFirst && less > 0 && less + last < target ) {
        	ArrayList<Integer> copyList = new ArrayList<Integer>(list);
        	addNext(results, copyList, sum, less, target, false);
        }
        
        sum = sum + last;
        list.add(last);
        
        addNext(results, list, sum, last, target, false);
    }

    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in); 
		System.out.print("Enter a number: ");
		
		int n = reader.nextInt();
		
       
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> list;
        
        for (int i=1; i<n; i++) {
            list = new ArrayList<Integer>();
            addNext(results, list, 0, i, n, true);
        }

        print(results);
        System.out.println(n);
         
    }
    
    public static void print(ArrayList<ArrayList<Integer>> results) {
    	for (ArrayList<Integer> list: results) {
    		for (Integer i: list) {
    			System.out.print(String.format("%d ", i));
    		}
    		System.out.println("\n");
    		
    	}
    }
    
}