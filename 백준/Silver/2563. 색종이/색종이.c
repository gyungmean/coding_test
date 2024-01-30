#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	int white[100][100] = { 0 };
	int count, x, y;
	int area = 0;
	
	scanf("%d", &count);
	for (int i = 0; i < count; i++) {
		scanf("%d %d", &x, &y);
		for (int j = x; j < x + 10; j++)
			for (int k = y; k < y + 10; k++)
				white[j][k] = 1;
	}

	for (int i = 0; i < 100; i++)
		for (int j = 0; j < 100; j++)
			if (white[i][j] == 1)
				area++;

	printf("%d\n", area);

}