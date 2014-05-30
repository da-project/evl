package org.bitbucket.evl.tutorial5;

import org.bitbucket.evl.Method2;
import org.bitbucket.evl.SymmetricComparator;
import org.bitbucket.evl.classes.A;
import org.bitbucket.evl.classes.B;
import org.bitbucket.evl.classes.J;
import org.bitbucket.evl.classes.K;
import org.bitbucket.evl.util.Parameter;

/**
 * Symmetric and asymmetric dispatch.
 * @author yan
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		B b = new B(1, 4);
		K k = new K(3, 7);
		
		Copier copier = new Copier();
		
		Method2<Void> copy1 = new Method2<Void>()
						.add(Copier.class, "copy", Parameter.types(A.class, K.class), copier)
						.add(Copier.class, "copy", Parameter.types(B.class, J.class), copier);
		
		copy1.invoke(b, k);
		
		System.out.println(b.getB() + " == " + k.getJ());
		
		
		Method2<Void> copy2 = new Method2<Void>()
				.comparator(new SymmetricComparator())
				.add(Copier.class, "copy", Parameter.types(A.class, K.class), copier)
				.add(Copier.class, "copy", Parameter.types(B.class, J.class), copier);

		try {
			copy2.invoke(b, k);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Method2<Void> copy3 = new Method2<Void>()
				.comparator(new SymmetricComparator())
				.add(Copier.class, "copy", Parameter.types(A.class, K.class), copier)
				.add(Copier.class, "copy", Parameter.types(B.class, J.class), copier)
				.add(Copier.class, "copy", Parameter.types(B.class, K.class), copier);

		copy3.invoke(b, k);

		System.out.println(b.getA() + " == " + k.getK());
	}
}
