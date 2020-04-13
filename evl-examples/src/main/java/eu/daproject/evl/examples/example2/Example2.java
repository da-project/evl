/*******************************************************************************
 * Copyright 2019 The EVL authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package eu.daproject.evl.examples.example2;

import java.util.Arrays;
import java.util.Collection;

import eu.daproject.evl.Cases;
import eu.daproject.evl.Method2;

/**
 * A simple example of multimethod of dimension 2.
 *
 */
public class Example2 {

	public static void run() throws Throwable {
		
		Method2<Void> test = new Method2<Void>().add(new Cases() {
				
			void match(Integer i, Integer j) {
				System.out.println("We are the integers " + i + " and " + j);
			}
			
			void match(String s, String t) {
				System.out.println("We are the strings " + s + " and " + t);
			}
			
			void match(Collection<?> c, String s) {
				System.out.println("We are a collection of size " + c.size() + " and a string " + s);
			}
		});
		
		test.invoke(12, -25);
		test.invoke("beautiful", "day");
		test.invoke(Arrays.asList("awesome" , "weather"), "today");
		
		try {
			test.invoke(new String("string"), 2);
		}
		catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
