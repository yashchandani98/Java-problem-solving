public class CountNumberOfOccurence {
    public static int count(String stringToCheck, char a){
        char arr[]=stringToCheck.toCharArray();
        int count=0;
        for(char i: arr){
            if(i == a){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
      int count = count("Java",'a');
      System.out.println(count);
    }
}
