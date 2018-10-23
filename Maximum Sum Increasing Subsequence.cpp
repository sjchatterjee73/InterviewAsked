/*
    Given an array A of N positive integers. Find the sum of maximum sum non-decreasing subsequence of the given array.
    Input:
    The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains array elements.

    Output:
    Print the sum of maximum sum sub-sequence of the given array.

    Example:
    Input:
    2
    7
    1 101 2 3 100 4 5
    4
    10 5 4 3

    Output:
    106
    10

    Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100) has maximum sum,i.e., 106.

    Approaches:
    1. visit every node, keep on adding in a 'temp' variable.
    2. mark the visited node.
    3. when the current node is less than the prev node, break the loop and return result;
    4. if you reach to last node, print the resultant result.

    Question Asked in: Amazon, Flipcart.

    The following solutions will give result in O(n^2) complexity.
*/

#include<iostream>
#include<cstdlib>
using namespace std;
void getPut(int * array, int size, int *totalMax, int *ind){
    int count=array[0];
    int i=0;
    for(i=1; i<size; i++){
        // skip for visited node.
        if(array[i] == -1)
            continue;
        
        // break the loop, when current node is less than prev. node
        if(array[i] < array[i-1]){
            // mark the visited node.              
            array[i-1] = -1;
            *ind = i-1;
           // calculate, if the new total is greater or less than the prev total.
            if(*totalMax < count)
                *totalMax = count; 
                                   
            return;
        }
        // keep on adding into a 'temp' variable, 'count' for namesake
        count += array[i];
    }
    
    // calculate, if you reach the last node of array.
    if(count > *totalMax)
        *totalMax = count;
    
    *ind = i;
}
void getMaxTotal(int * array, int size, int * totalMax, int * ind){
    
    while(true){
        //break the loop, when you get all possible sub-sequence from array.
        if(*ind == size)
            break;
        
        getPut(array, size, totalMax, ind);        
    }      
}
int main(void){
    int t, size;    
    int * array;
    cin>>t;
        
    while(t-- > 0){
        cin>>size;
        array = (int *)malloc(size * sizeof(int));

        int totalMax = 0, ind =0;
        for(int i=0; i<size; i++){
            cin>>array[i];
        }

        getMaxTotal(array, size, &totalMax, &ind);
        cout<<totalMax<<endl;
        free(array);
    }
    return 0;
}