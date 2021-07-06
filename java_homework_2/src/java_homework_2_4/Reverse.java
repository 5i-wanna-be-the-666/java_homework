package java_homework_2_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Reverse {
	public static <T> List<T> reverse(List<T> xs)
	{
		Collections.reverse(xs);
		return  xs;
		
	}
	public <T> void print(List<T> xs)
	{
		int i=0;
		for(i=0;i<xs.size();i++)
		{
			System.out.print(xs.get(i)+" ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("static-access")
	public static void main(String []arug)
	{
		 Reverse k=new  Reverse();
		 
		 List<String> list1 = new ArrayList<>();
	        for (int i = 0; i < 10; i++) 
	        {
	            list1.add(i + " ");
	        }
	        System.out.println("ArrayList£º");
	        k.print(list1);
	        k.reverse(list1);
	        k.print(list1);
	        
	        
	    List<String> list2 = new Vector<>();
	    
	    for (int i = 0; i < 10; i++) 
        {
            list2.add(i + " ");
        }
	    System.out.println("Vector£º");
	    k.print(list2);
        k.reverse(list2);
        k.print(list2);
        
        
        
	    List<String> list3 = new LinkedList<>();
	    for (int i = 0; i < 10; i++) 
        {
            list3.add(i + " ");
        }
	    System.out.println("LinkedList£º");
	    k.print(list3);
        k.reverse(list3);
        k.print(list3);
        
	}
}
