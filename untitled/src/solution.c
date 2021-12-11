#include <stdio.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

int cycle(int n){
    int count = 1;
    int res = n;
    while(res != 1){
        if (res % 2 == 1){
            res = (3*res + 1)/2;
            count+=2;
        }else {
            res = res/2;
            count++;
        }
    }

    return count;

}

int largestCycleLength(int i, int j) {
    int largestCycleCount = 0;
    int res;
    int k;

    for (k = MIN(i, j); k <= MAX(i, j) ; k++) {
        res = cycle(k);

        if (res > largestCycleCount) {
            largestCycleCount = res;
        }
    }

    return largestCycleCount;
}


int main()
{
    int m,n,f,s;
    while (scanf("%d %d\n",&m,&n)==2){

    	f = m;
    	s = n;

    	printf("%d %d %d\n",f,s,largestCycleLength(f,s));
    }

    return 0;
}
