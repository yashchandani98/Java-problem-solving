
/* 
Coding Ninjas

Microsoft Question

Aahad and Harshit always have fun by solving problems. Harshit took a sorted array and rotated it clockwise by unknown amount.
For example, he tool a sorted array = [1, 2, 3, 4, 5] and if he rotates it by 2, then the array becomes: [4, 5, 1, 2, 3].
After rotating a sorted array, Harshit gave Aahad a number which Harshit wanted him to search in the array. 
If he founds it, he had to shout the index of the number, otherwise he had to shout -1.
*/
import java.util.Scanner;

public class ArrayProblem1 {

	
	public static void main(String[] args) {
        int size,searchElement,temp,index,position=-1;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Size of an Array(Greater than 1):");
        size=sc.nextInt();
        if(size>1){
            int[] array = new int[size];
            int[] array2 = new int[size];
            System.out.println("Enter Elements of an Array:");
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println("Enter Search Element:");
            searchElement = sc.nextInt();
            for (int k = 0; k < size; k++) {
                temp = array[k];
                index = k + 2;
                if (index < size) {
                    array2[index] = temp;
                } else {
                    index = index - size;
                    array2[index] = temp;
                }
            }
            for (int j = 0; j < size; j++) {
                if (array2[j] == searchElement) {
                    position = j;
                    break;
                }
            }
            System.out.println("Position:" + position);
        }
        else{
            System.out.println("Size should be greater than 1:");
        }
	}

}