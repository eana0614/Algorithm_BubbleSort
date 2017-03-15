#define _CRT_SECURE_NO_DEPRECATE

#include "rwchead.h"

int* bubblesort(int* inputArray, int length);
void swap(int *i, int *j);

int main(void) {

	char* inputFileName = "random.txt";
	char* outpuFileName = "c bubble sort.txt";

	int count = countElement(inputFileName);

	int* readfile = readTxtfile(inputFileName, count);

	int* sortedArray = bubblesort(readfile, count);

	writeTxtFile(sortedArray, outpuFileName, count);

	printf("!] Sucess! \n");

}

int* bubblesort(int* inputArray, int length) {
	int i, j;
	for (i = 1; i < length; i++) {
		for (j = 0; j < length - 1; j++) {
			if (inputArray[j] > inputArray[j + 1]) {
				swap(&inputArray[j], &inputArray[j + 1]);
			}
			
		}
	}

	return inputArray;
}

void swap(int* i, int* j) {
	int temp = *i;

	*i = *j;
	*j = temp;

}