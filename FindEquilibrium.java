/*
    approach: 
        1. create an auxilary array,
            1.1 put 0 on first index,
            1.2 put last index's value of auxilary array + i-th value of main array, into i-th index of auxilary array
        2. create a varible (result) to hold and check value of both array meeting equal or not.
        3. traverse auxilary array from the last
            3.1 if 'result' and value of auxilary array are same, return -i (that is equlibrium point)
            3.2 else, add i-th value of main array to 'result' for next check.

*/
import java.util.*;
class FindEquilibrium{
    static Scanner inp = new Scanner(System.in);
    static int t;
    static int size;

    static int getFirstEquilibrium(int [] array){
        int [] temp = new int[array.length];

        temp[0] = 0;
        for(int i=1; i<array.length; i++){
            temp[i] = temp[i-1] + array[i-1];
        }

        int right = 0;
        for(int i=array.length-1; i>=0; i--){
            if(right == temp[i])
                return i+1;
            
            right += array[i];
        }

        return -1;
    }
    public static void main(String [] args){
        t = inp.nextInt();

        while(t-- > 0){
            size = inp.nextInt();
            int [] array = new int[size];
            
            for(int i=0; i<size; i++){
                array[i] = inp.nextInt();
            }
            if(array.length == 1){
                System.out.println("1");
                continue;
            }
            System.out.println(getFirstEquilibrium(array));
        }
    }
}