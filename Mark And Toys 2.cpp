/*
    Note:
    Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some.
    There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, 
    and he wants to maximize the number of toys he buys with this money.

    Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if prices = [1,2,3,4] and Mark has k=7 to spend, 
    he can buy items [1,2,3] for 6, or [3,4] for 7 units of currency. He would choose the first group of 3 items.

    Tag: HackerRank
    url: https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

    Approach:
    1. sort the array of toys in ascending order.
    2. keep on adding all i-th toys to 'sum' until the sum become greater than the 'value'
        2.1 count number of toys, after each adding.
    3. break counting, if sum becomes greater than 'value';
    4. return the 'number of toys' you got.

    Note: this solution will give you the result in O(n) RTC + RTC of Sorting.
*/

#include<iostream>
#include<cstdlib>

using namespace std;
void sortItems(int * array, int size){
    int count=0, toys=0;
    for(int i=0; i<size; i++){
        int m = i;
        for(int j=i+1; j<size; j++){
            if(array[j] < array[m])
                m = j;
        }

        int t = array[i];
        array[i] = array[m];
        array[m] = t;
    }    
}

void getToys(int * array, int size, int val){
    int count =0, toys=0;
    for(int i=0; i<size; i++){
        if(count <= val){
            count += array[i];
            toys++;
        }
        if(count>=val)
            break;
    }
    cout<<toys-1;
}
int main(int argc, char const *argv[])
{
    int size, val;
    cin>>size;
    int * array = (int *)malloc(size * sizeof(int));
    cin>>val; int count=0;
    for(int i=0; i<size; i++){
        cin>>array[i];
    }
    sortItems(array, size);
    getToys(array, size, val);
    return 0;
}
