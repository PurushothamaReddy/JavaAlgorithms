package com.passion.coding.array;

public class ElementFrequencyInsortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        //approach 2 use hashmap
        int prev=arr[0],curr=arr[0];
        int freqcount = 0;
        for (int i=0;i<arr.length;i++){
            curr=arr[i];
            if(prev != curr){
                System.out.println("frequency of "+prev+" is:"+freqcount);
                freqcount=1;
            }else {
                freqcount++;
            }
            prev=curr;
            if(i== arr.length-1){
                System.out.println("frequency of "+prev+" is:"+freqcount);
            }

        }
    }
}
