//#include<stdio.h>

int add(int a, int b){
     return a+b;
}

int fun(int a, int b, int c, int d){
    return a+b+c+d;
}

int main(){
    int x = 3;
    int y = 2;
    y = x;
    int z = add(add(x,y),2);
    printf("%d + %d = %d\n",x,y,z);
}