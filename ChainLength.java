/*
    You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. 
    A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
    Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which 
    can be formed from a given set of pairs. 

    Input:
    The first line of input contains an integer T denoting the no of test cases then T test cases follow .
    Then T test cases follow. The first line of input contains an integer N denoting the no of pairs.
    In the next line are 2*N space separated values denoting N pairs.

    Output:
    For each test case output will be the length of the longest chain formed.
    
    Constraints:
    1<=T<=100
    1<=N<=100

    Example(To be used only for expected output):
    Input
    2
    5
    5  24 39 60 15 28 27 40 50 90
    2
    5 10 1 11 

    Output
    3
    1

    Explanation
    (i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
    (ii) The max length chain possible is only of length one.

*/
import java.util.*;
import java.lang.*;
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
class ChainLength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            Main g = new Main();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

class Main
{
    int maxCount = 0;

    void get(int ind, int [] first, int [] second){
        int a = first[0], b= second[0];
        int count = 1;
        for(int i=ind; i<first.length; i++){            
            if(first[i] == -1111)
                continue;
            if(first[i] < b)
                continue;

            if(first[i] > b){
                count++;
                a = first[i];
                b = second[i];
                first[i] = -1111;
                second[i] = -1111;
            }
        }        
        if(count > maxCount)
            maxCount = count;
    }
    void myFunc(int [] first, int [] second){
        for(int i=0; i<first.length; i++){
            get(i+1, first, second);
        }
    }
    void sortMeFirst(int [] first, int [] second){
        for(int i=1; i<first.length; i++){
            int j = i-1;
            int k = first[i];
            int k1 = second[i];

            while(j >= 0 && first[j] >= k){
                first[j+1] = first[j];
                second[j+1] = second[j];
                --j;
            }
            first[j+1] = k;
            second[j+1] = k1;
        }
    }
    int maxChainLength(Pair arr[], int n)
    {

       int [] first = new int[arr.length];
       int [] second = new int[arr.length];
       
       for(int i=0; i<first.length; i++){
            first[i] = arr[i].x;
            second[i] = arr[i].y;
       }

       sortMeFirst(first, second);

       for(int i=0; i<first.length; i++){
            System.out.println(first[i] +" " +second[i]);            
       }

       myFunc(first, second);
       return maxCount;
    }
}