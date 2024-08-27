package opgave08.Flettesortering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFlettesortering {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<Integer>();
		Random r=new Random();
		for (int i=0;i<1000000;i++) {
			list.add(Math.abs(r.nextInt()%10000));
		};
		
		//System.out.println(list);

		FletteSortering sort = new FletteSortering();
		long l1,l2;
		l1 = System.nanoTime();
		sort.mergesort(list,0,list.size()-1);
		l2 = System.nanoTime();
		//System.out.println();
		System.out.println("Køretiden var " + (l2-l1)/1000000);
		//System.out.println();
		//System.out.println(list);

		//----------------------------------------------------------

		List<Integer> list1 = new ArrayList<Integer>();
		Random r1=new Random();
		for (int i=0;i<1000000;i++) {
			list1.add(Math.abs(r1.nextInt()%10000));
		};

		FletteSortering sort1 = new FletteSortering();
		long l3, l4;
		MergesortThread t1 = new MergesortThread(sort1, list1, 0, (list1.size() - 1) / 2);
		MergesortThread t2 = new MergesortThread(sort1, list1, (list1.size() - 1) / 2 + 1, list1.size() - 1);
		l3 = System.nanoTime();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		sort1.merge(list1,0, (list1.size()-1) / 2,list1.size()-1);
		l4 = System.nanoTime();
		//System.out.println();
		System.out.println("Køretiden med threads var " + (l4 -l3)/1000000);
		//System.out.println();
		//System.out.println(list1);
	}

}
