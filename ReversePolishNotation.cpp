/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid op-
erators are +, -, *, /. Each operand may be an integer or another expression. For
example:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/
#include<iostream>
#include<string>
#include<stdbool.h>

using namespace std;
int * stack, top=-1;
void initStack(int size){
  stack = new int[size];
}
void push(int i){
  stack[++top] = i;
}
int pop(){
  return stack[top--];
}
int getResult(char * exp){
    int digit = 0;
    for(int i=0; exp[i]!='\0'; i++){
      if(exp[i]>=48 && exp[i]<=57)
        digit++;
    }
    initStack(digit);
    for(int i=0; exp[i]!='\0'; i++){
        if(exp[i] != '+' && exp[i] != '-' && exp[i] != '/' && exp[i] != '*'){
          digit = exp[i] - '0';
          push(digit);
        }else{
          int a = pop();
          int b = pop();
          switch(exp[i]){
            case '+':
              push(a+b);
              break;
            case '*':
              push(a*b);
              break;
            case '/':
              if(a == 0)
                continue;

              push(b/a);
              break;
            case '-':
              push(b-a);
              break;
          }
        }
    }
    return pop();
}

int main(void){
  std::cout << "enter expression:" << '\n';
  char exp[500] ={};  cin.get(exp, 500);
  std::cout << getResult(exp) << '\n';
}
