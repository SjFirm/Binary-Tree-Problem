package main.BnaryTree;

import java.util.ArrayList;

public class Program {

	private static int _lastInt = 0;
	private static String ab = "";

	public static void main(String[] args) {

		int[][] jagged = new int[][] {
				new int[] { 215 },
				new int[] { 192, 124 },
				new int[] { 117, 269, 442 },
				new int[] { 218, 836, 347, 235 },
				new int[] { 320, 805, 522, 417, 345 },
				new int[] { 229, 601, 728, 835, 133, 124 },
				new int[] { 248, 202, 277, 433, 207, 263, 257 },
				new int[] { 359, 464, 504, 528, 516, 716, 871, 182 },
				new int[] { 461, 441, 426, 656, 863, 560, 380, 171, 923 },
				new int[] { 381, 348, 573, 533, 448, 632, 387, 176, 975, 449 },
				new int[] { 223, 711, 445, 645, 245, 543, 931, 532, 937, 541,
						444 },
				new int[] { 330, 131, 333, 928, 376, 733, 017, 778, 839, 168,
						197, 197 },
				new int[] { 131, 171, 522, 137, 217, 224, 291, 413, 528, 520,
						227, 229, 928 },
				new int[] { 223, 626, 034, 683, 839, 052, 627, 310, 713, 999,
						629, 817, 410, 121 },
				new int[] { 924, 622, 911, 233, 325, 139, 721, 218, 253, 223,
						107, 233, 230, 124, 233 },

		};
		int nextNodeA = 0, nextNodeB = 0, result = 0;
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < jagged.length; i++) {
			for (int j = 0; j < jagged[i].length; j++) {
				
				if (jagged[i].length == 1) {
					_lastInt = Compare(jagged[i][nextNodeA], jagged[i][nextNodeB]);
					result += _lastInt;
					lst.add(_lastInt);
					
					nextNodeA = j;
					nextNodeB = j+1;
				} else {
					 _lastInt = Compare(jagged[i][nextNodeA], jagged[i][nextNodeB]);
					lst.add(_lastInt);
					result += _lastInt;
					 if (ab == "a")
                     {
                         // nextNodeA = nextNodeA;
                         nextNodeB = nextNodeA + 1;
                         break;
                     }
                     else
                     {
                         nextNodeA = nextNodeB;
                         nextNodeB = nextNodeB + 1;
                         break;
                     }
					
					
					 
				}
				
			}
			
		}
		System.out.println("Max sum: " + result);
		 

        int last = lst.get(lst.size() - 1);;
        
        System.out.print("Path:  ");
        String str = "";
        for (Integer i : lst) {
        	if (i.equals(last))
                str += i;
            else
                str += i + ", ";
		}
        
        System.out.print(str);
	}
	 private static int Compare(int a, int b)
     {
         int[] arr = new int[2];
         if (_lastInt % 2 == 0)
         {
             if (!IsEven(a))
                 arr[0] = a;
             if (!IsEven(b))
                 arr[1] = b;
             int result = Max(arr[0], arr[1]);
             ab = result == a ? "a" : "b";
             return result;
         }
         else
         {
             if (IsEven(a))
                 arr[0] = a;
             if (IsEven(b))
                 arr[1] = b;
             int result = Max(arr[0], arr[1]);
             ab = result == a ? "a" : "b";
             return result;
         }
     }


     private static boolean IsEven(int a)
     {
         return a % 2 == 0;
     }
     
     private static int Max(int a, int b)
     {
         return (a > b)? a: b;
     }
}
