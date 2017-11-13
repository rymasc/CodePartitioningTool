//#include<stdio.h>

int add(int a, int b){
    return a+b;
}

int main(){
    int x = 3;
    int y = 2;

    int z = add(x,y);

    printf("%d + %d = %d\n",x,y,z);
}