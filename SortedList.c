#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct Node{
  int data;
  struct Node * next;
};
void insert(int data, struct Node ** head){
  struct Node * newNode = (struct Node *)malloc(sizeof(struct Node));
  newNode->next = NULL;
  newNode->data = data;

  if(*head == NULL){
    newNode->next = *head;
    *head = newNode;
    return;
  }
  bool last = false, first = false, middle = false;
  struct Node * temp = * head;
  struct Node * current = NULL;

  while(temp != NULL){
    if(temp->next == NULL && temp!= NULL){
      last = true;
      break;
    }
    current = temp;

    if(temp->data == data){
      middle = true;
      break;
    }

    if((temp->data < data) && (temp->next->data > data)){
      middle = true;
      break;
    }

    if(temp->data > data){
      first = true;
      break;
    }
    temp = temp->next;
  }

  if(first){
    newNode->next = * head;
    * head = newNode;
    return;
  }

  if(middle){
    newNode->next = current->next;
    current->next = newNode;
    return;
  }

  if(last){
    if(temp->data > data){
      newNode->next = * head;
      * head = newNode;
      return;
    }

    temp->next = newNode;
    return;
  }
}
void display(struct Node * head){
  while(head != NULL){
    printf("%i ->",head->data);
    head = head->next;
  }
  printf("\n");
}
int main(void){
    struct Node * head = NULL;
    int num;
    while(true){
      printf("enter item:");
      scanf("%i",&num);
      insert(num, &head);
      display(head);
    }
}
