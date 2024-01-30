#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
	int n;
	char seat[51];
	int cup = 1;

	scanf("%d", &n);
	scanf("%s", seat);

	for (int i = 0; i < strlen(seat); i++) {
		if (seat[i] == 'S') {
			cup++;
		}
		else if (seat[i] == 'L') {
			i++;
			cup++;
		}
	}

	if (cup > n) cup = n;
	printf("%d\n", cup);

}