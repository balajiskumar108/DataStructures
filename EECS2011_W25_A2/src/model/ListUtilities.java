package model;

import tests.Node;

public class ListUtilities {

     public static Node<String> getAllPrefixes(Node<Integer> input, int m, int n) {
         if (input == null || m > n || m < 1) return null;
         
         //Create an empty node
         Node<String> dummy = new Node<>(null, null);
         Node<String> tail = dummy; //Empty tail reference
         Node<Integer> current = input; //Copy the elements from the input node
         StringBuilder sb = new StringBuilder(); //Initialize the String Builder
         int count = 0;
         
         //Iterate the list as long as it is not null AND as long as the count is less than n
         while (current != null && count < n) {
             if (count > 0) sb.append(", ");
             sb.append(current.getElement());
             count++;
 
             if (count >= m) {
                 tail.setNext(new Node<>("[" + sb.toString() + "]", null));
                 tail = tail.getNext();
             }
             current = current.getNext();
         }
         return dummy.getNext();
     }
     
     
     public static Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {
         Node<Integer> dummy = new Node<>(null, null);
         Node<Integer> tail = dummy;
 
         while (leftChain != null && rightChain != null) {
             if (leftChain.getElement() <= rightChain.getElement()) {
                 tail.setNext(new Node<>(leftChain.getElement(), null));
                 leftChain = leftChain.getNext();
             } else {
                 tail.setNext(new Node<>(rightChain.getElement(), null));
                 rightChain = rightChain.getNext();
             }
             tail = tail.getNext();
         }
 
         while (leftChain != null) {
             tail.setNext(new Node<>(leftChain.getElement(), null));
             tail = tail.getNext();
             leftChain = leftChain.getNext();
         }
 
         while (rightChain != null) {
             tail.setNext(new Node<>(rightChain.getElement(), null));
             tail = tail.getNext();
             rightChain = rightChain.getNext();
         }
 
         return dummy.getNext();
     } 
 }
 