/*
You may have been using Programming for a while. Do you think a simple array question
can be a challenge? Let’s use the following problem to test.

Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7
and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different ways
do you know to solve this problem?
*/
#include<iostream>
using namespace std;
void makeRotation(int * array, int size, int k){
  int f = array[0];
  for(int i=1; i<size; i++){
    array[i-1] = array[i];
  }
  array[size-1] = f;
}
int main(void){
  std::cout << "enter size of array:" << '\n';
  int size; std::cin>>size;

  std::cout << "enter array element:" << '\n';
  int * array = NULL;
  array = new int[size];
  for(int i=0; i<size; i++){
    std::cin >>array[i];
  }
  std::cout << "enter k:" << '\n';
  int k; cin>>k;
  for(int i=0; i<k; i++)
    makeRotation(array, size, 1);
  std::cout << "array after rotation is:" << '\n';
  for (size_t i = 0; i < size; i++) {
    std::cout << array[i] << " ";
  }
}
