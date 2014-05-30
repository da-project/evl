package org.bitbucket.evl.tutorial6;

import org.bitbucket.evl.Method2;
import org.bitbucket.evl.Method2D;
import org.bitbucket.evl.PrioritySymmetricComparator;
import org.bitbucket.evl.SymmetricComparator;
import org.bitbucket.evl.classes.A;
import org.bitbucket.evl.classes.B;
import org.bitbucket.evl.exception.InvocationException;
import org.bitbucket.evl.util.Parameter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		A b1 = new B(1, 2);
		A b2 = new B(2, -5);
		
		Agent agent = new Agent();
		
		Method2<Integer> process1 = new Method2<Integer>()
						.comparator(new SymmetricComparator())
						.addAll(Agent.class, "process", agent);

		try {
			System.out.println(process1.invoke(b1, b2));
		} catch (InvocationException e) {
			System.out.println("error : " + e.getMessage());
		}
		
		ExtendedAgent agent2 = new ExtendedAgent();
		
		Method2<Integer> process2 = new Method2<Integer>()
				.comparator(new SymmetricComparator())
				.addAll(ExtendedAgent.class, "process", agent2);

		System.out.println(process2.invoke(b1, b2));
		

		Method2D<Integer, Integer> process3 = new Method2D<Integer, Integer>()
				.comparator(new PrioritySymmetricComparator<Integer>())
				.add(Agent.class, "process", Parameter.types(A.class, B.class), agent, 1)
				.add(Agent.class, "process", Parameter.types(B.class, A.class), agent, 0);

		System.out.println(process3.invoke(b1, b2));

		
		Method2D<Integer, String> process4 = new Method2D<Integer, String>()
				.comparator(new PrioritySymmetricComparator<String>())
				.add(Agent.class, "process", Parameter.types(A.class, B.class), agent, "first")
				.add(Agent.class, "process", Parameter.types(B.class, A.class), agent, "second");

		// the test with String parameter does not provide consistent order
		// an exception is thrown because the minimum found is not the real minimum
		try {
			System.out.println(process4.invoke(b1, b2));
		} catch (InvocationException e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}
