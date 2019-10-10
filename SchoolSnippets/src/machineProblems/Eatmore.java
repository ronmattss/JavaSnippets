/*
 * Author: Rivera Ron Matthew R.
 * Eatmore solution
 * */

package machineProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Eatmore {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int p1,p2,p3,s1,s2,s3,h1,h2,h3;
		boolean choice = true;
		
		while(choice) {	

		System.out.println("Enter Quantity of food for Customer 1 p/s/h: ");
		p1 = sc.nextInt();
		s1 = sc.nextInt();
		h1 = sc.nextInt();
		System.out.println("Enter Quantity of food for Customer 2 p/s/h: ");
		p2 = sc.nextInt();
		s2 = sc.nextInt();
		h2 = sc.nextInt();
		System.out.println("Enter Quantity of food for Customer 3 p/s/h: ");
		p3 = sc.nextInt();
		s3 = sc.nextInt();
		h3 = sc.nextInt();
		
		Customer a = new Customer("1", p1,s1, h1);

		Customer b = new Customer("2",p2,s2,h2);

		Customer c = new Customer("3", p3,s3,h3);
		
		firstTrial(a, b, c);
		Customer d = new Customer("1", p1,s1, h1);

		Customer e = new Customer("2",p2,s2,h2);

		Customer f = new Customer("3", p3,s3,h3);
		System.out.println("\n\n");
		secondTrial(d, e, f);
		
		System.out.println("\nAgain (y/n): ");
		String ab = sc.next();
		if(ab.equalsIgnoreCase("y"))
			choice = true;
		else
			choice = false;
		
		}

	}


	// This algo traverses the queue after they finish ordering in one line
	static void firstTrial(Customer a, Customer b, Customer c) {
		// three queues for popcorn soda and hotdog
		Customer temp = new Customer(); // just to store the object being removed
		Queue<Customer> pq = new LinkedList<Customer>();
		Queue<Customer> sq = new LinkedList<Customer>();
		Queue<Customer> hq = new LinkedList<Customer>();
		
		// the serving time
		int hotdogServeTime = 4;
		int sodaServeTime = 2;
		int popcornServeTime = 1;
		int time = 0;
		int ctr = 0;
		// check if all orders of the three customers are completed
		boolean checkAllOrders = false;

		List<Customer> customers = new ArrayList<Customer>(); // just to initialize it to the queue

		customers.add(a);
		customers.add(b);
		customers.add(c);


		// full queue solution
		// check if a food is 0 
		for (int j = 0; j < 3; j++) {
			if (customers.get(j).hotdog == 0)
				customers.get(j).hotdogIsBeingServe = true;
			if (customers.get(j).popcorn == 0)
				customers.get(j).popcornIsBeingServe = true;
			if (customers.get(j).soda == 0)
				customers.get(j).sodaIsBeingServe = true;

		}
		
		// Queue them to the lines one customer for each queue
		for (int i = 0; i < 3; i++) {
			if (customers.get(i).popcorn > 0 && pq.isEmpty()) {
				customers.get(i).popcornServeTime = customers.get(i).popcorn * popcornServeTime;
				pq.add(customers.get(i));
				// pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
			}

			else if (customers.get(i).soda > 0 && sq.isEmpty()) {
				customers.get(i).sodaServeTime = customers.get(i).soda * sodaServeTime;
				sq.add(customers.get(i));
				// sq.peek().sodaServeTime = sq.peek().popcorn * sodaServeTime;
			} else if (customers.get(i).hotdog > 0 && hq.isEmpty()) {
				customers.get(i).hotdogServeTime = customers.get(i).hotdog * hotdogServeTime;
				hq.add(customers.get(i));
				// hq.peek().hotdogServeTime = hq.peek().hotdog * hotdogServeTime;
			} else { // add them to the popcorn queue
				pq.add(customers.get(i));
				// pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
			}
		}
		// This while loop
		// if current queue is finished
		// move to the next queue
		// until all orders are complete
		// if all is served, exit the loop
		System.out.println("popcorn    soda    hotdog");
		while (checkAllOrders == false /* time != 30 */) {
			time++;
			System.out.print(" " + time + " ");
			if (!pq.isEmpty())
				System.out.print("  " + pq.peek().customerName + " ");
			else
				System.out.print(" * ");
			if (!sq.isEmpty())
				System.out.print(" " + sq.peek().customerName + " ");
			else
				System.out.print(" * ");
			if (!hq.isEmpty())
				System.out.print("  " + hq.peek().customerName + "\n");
			else
				System.out.print(" * \n");

			//** POPCORN QUEUE **\\
			// all algos are same for each queue
			
			// If queue is not empty && it is not served check the serve time then set it
			if (!pq.isEmpty() && pq.peek().popcornIsBeingServe == false) {
				if (!pq.isEmpty() && pq.peek().popcornServeTime == 0) {
					// pq.peek().popcornIsBeingServe = true;
					pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
				}
				// ReSet serve time for the next customers 
				if (pq.peek().popcornServeTime < time) {
					// update servetime
					pq.peek().popcornServeTime = (pq.peek().popcorn * popcornServeTime) + time;
				}
				// if serving is finished, move to the next queue
				if (pq.peek().popcornServeTime == time && time != 0) {
					pq.peek().popcornIsBeingServe = true;
					pq.peek().fullpopcornServeTime = pq.peek().popcornServeTime;
					pq.peek().popcorn = 0;
					
					// temporarily store the customer object to temp
					temp = pq.remove();
					// System.out.println("popcorn Removed");
					
					// check if a food is not served
					// queue them to the next
					if (temp.soda > 0) {
						if (!sq.isEmpty())
							temp.sodaServeTime = (temp.soda * sodaServeTime) + sq.peek().sodaServeTime;
						else
							temp.sodaServeTime = (temp.soda * sodaServeTime) * sodaServeTime + time;

						sq.add(temp);
						
					} else if (temp.hotdog > 0) {
						temp.hotdogServeTime = (temp.hotdog * hotdogServeTime) + time;
						hq.add(temp);

					}
				}

			}

			//** SODA QUEUE **\\
			
			// if soda is empty
			if (!sq.isEmpty() && sq.peek().sodaIsBeingServe == false) {
				if (!sq.isEmpty() && sq.peek().sodaServeTime == 0) {
					// sq.peek().sodaIsBeingServe = true;
					sq.peek().sodaServeTime = sq.peek().soda * sodaServeTime;

				}
				if (sq.peek().sodaServeTime < time) {
					sq.peek().sodaServeTime = (sq.peek().soda * sodaServeTime) + time;

				}
				if (sq.peek().sodaServeTime == time && time != 0) {
					sq.peek().sodaIsBeingServe = true;
					sq.peek().soda = 0;
					sq.peek().fullSodaServeTime = sq.peek().sodaServeTime;
					temp = sq.remove();

					if (temp.hotdog > 0) {
						if (!hq.isEmpty())
							temp.hotdogServeTime = (temp.hotdog * hotdogServeTime) + hq.peek().hotdogServeTime;
						else
							temp.hotdogServeTime = (temp.hotdog * hotdogServeTime) + time;
						hq.add(temp);

					}

					else if (temp.popcorn > 0) {
						temp.popcornServeTime = (temp.popcorn * popcornServeTime) + time;
						pq.add(temp);

					}
				}

			}

			//** SODA QUEUE **\\
			
			// if hotdog is empty
			if (!hq.isEmpty() && hq.peek().hotdogIsBeingServe == false) {
				if (!hq.isEmpty() && hq.peek().hotdogServeTime == 0) {
					// hq.peek().hotdogIsBeingServe = true;
					hq.peek().hotdogServeTime = hq.peek().hotdog * hotdogServeTime;

				}
				if (hq.peek().hotdogServeTime < time) {
					hq.peek().hotdogServeTime = (hq.peek().hotdog * hotdogServeTime) + time;

				}

				if (hq.peek().hotdogServeTime == time && time != 0) {
					hq.peek().hotdogIsBeingServe = true;
					hq.peek().fullHotdogServeTime = hq.peek().hotdogServeTime;
					hq.peek().hotdog = 0;
					temp = hq.remove();
					// System.out.println("Hotdoq Remove");

					if (temp.popcorn > 0) {

						if (!pq.isEmpty())
							temp.popcornServeTime = (temp.popcorn * popcornServeTime) + pq.peek().popcornServeTime;
						else
							temp.popcornServeTime = (temp.popcorn * popcornServeTime) + time;
						pq.add(temp);

					} else if (temp.soda > 0) {
						temp.sodaServeTime = (temp.soda * sodaServeTime) + time;
						sq.add(temp);
					}
				}

			}
			
			
			// CHeck if all food is served
			if (a.popcornIsBeingServe == true && a.hotdogIsBeingServe == true && a.sodaIsBeingServe == true)
				a.isFullyServed = true;
			else
				a.queueTime++;
			if (b.popcornIsBeingServe == true && b.hotdogIsBeingServe == true && b.sodaIsBeingServe == true)
				b.isFullyServed = true;
			else
				b.queueTime++;
			if (c.popcornIsBeingServe == true && c.hotdogIsBeingServe == true && c.sodaIsBeingServe == true)
				c.isFullyServed = true;
			else
				c.queueTime++;
			// if all orders are completed break the loop
			if (a.isFullyServed && b.isFullyServed && c.isFullyServed) {
				checkAllOrders = true;
			}

		}
		// calculate the average time in QUeue
		System.out.println("Average: " + a.queueTime + " " + b.queueTime + " " + c.queueTime + " " + "/ 3 = "
				+ ((a.queueTime + b.queueTime + c.queueTime) / 3));
		System.out.println("average time: " + ((a.queueTime + b.queueTime + c.queueTime) / 3));
	}

	// prioritizes the longest serving time. (Hotdog)
	// The algo is same as above, with just one modification
	static void secondTrial(Customer a, Customer b, Customer c) {
		Customer temp = new Customer(); // just to store the object being removed
		Queue<Customer> pq = new LinkedList<Customer>();
		Queue<Customer> sq = new LinkedList<Customer>();
		Queue<Customer> hq = new LinkedList<Customer>();
		int hotdogServeTime = 4;
		int sodaServeTime = 2;
		int popcornServeTime = 1;
		int time = 0;
		int ctr = 0;
		boolean checkAllOrders = false;

		List<Customer> customers = new ArrayList<Customer>();

		customers.add(a);
		customers.add(b);
		customers.add(c);

		// solution to this queue
		// determine the lowest amount of food
		// prio the lowest food amount
		// add them to the queue
		//
		// full queue solution
		for (int j = 0; j < 3; j++) {
			if (customers.get(j).hotdog == 0)
				customers.get(j).hotdogIsBeingServe = true;
			if (customers.get(j).popcorn == 0)
				customers.get(j).popcornIsBeingServe = true;
			if (customers.get(j).soda == 0)
				customers.get(j).sodaIsBeingServe = true;

		}
		for (int i = 0; i < 3; i++) {
			if (customers.get(i).popcorn > 0 && pq.isEmpty()) {
				customers.get(i).popcornServeTime = customers.get(i).popcorn * popcornServeTime;
				pq.add(customers.get(i));
				// pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
			}

			else if (customers.get(i).soda > 0 && sq.isEmpty()) {
				customers.get(i).sodaServeTime = customers.get(i).soda * sodaServeTime;
				sq.add(customers.get(i));
				// sq.peek().sodaServeTime = sq.peek().popcorn * sodaServeTime;
			} else if (customers.get(i).hotdog > 0 && hq.isEmpty()) {
				customers.get(i).hotdogServeTime = customers.get(i).hotdog * hotdogServeTime;
				hq.add(customers.get(i));
				// hq.peek().hotdogServeTime = hq.peek().hotdog * hotdogServeTime;
			} else { // add them to the popcorn queue
				pq.add(customers.get(i));
				// pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
			}
		}

		System.out.println("popcorn    soda    hotdog");
		while (checkAllOrders == false /* time != 30 */) {
			time++;
			System.out.print(" " + time + " ");
			if (!pq.isEmpty())
				System.out.print("  " + pq.peek().customerName + " ");
			else
				System.out.print(" * ");
			if (!sq.isEmpty())
				System.out.print(" " + sq.peek().customerName + " ");
			else
				System.out.print(" * ");
			if (!hq.isEmpty())
				System.out.print("  " + hq.peek().customerName + "\n");
			else
				System.out.print(" * \n");

			// If popcorn is empty
			if (!pq.isEmpty() && pq.peek().popcornIsBeingServe == false) {
				if (!pq.isEmpty() && pq.peek().popcornServeTime == 0) {
					// pq.peek().popcornIsBeingServe = true;
					pq.peek().popcornServeTime = pq.peek().popcorn * popcornServeTime;
				}

				if (pq.peek().popcornServeTime < time) {
					// update servetime
					pq.peek().popcornServeTime = (pq.peek().popcorn * popcornServeTime) + time;
				}

				if (pq.peek().popcornServeTime == time && time != 0) {
					pq.peek().popcornIsBeingServe = true;
					pq.peek().fullpopcornServeTime = pq.peek().popcornServeTime;
					pq.peek().popcorn = 0;

					temp = pq.remove();
					// System.out.println("popcorn Removed");
					  if (temp.hotdog > 0) {
							temp.hotdogServeTime = (temp.hotdog * hotdogServeTime) + time;
							hq.add(temp);

						}

					else if (temp.soda > 0) {
							temp.sodaServeTime = (temp.soda * sodaServeTime) * sodaServeTime + time;

						sq.add(temp);

					}
				}

			}
			if (!hq.isEmpty() && hq.peek().hotdogIsBeingServe == false) {
				if (!hq.isEmpty() && hq.peek().hotdogServeTime == 0) {
					// hq.peek().hotdogIsBeingServe = true;
					hq.peek().hotdogServeTime = hq.peek().hotdog * hotdogServeTime;

				}
				if (hq.peek().hotdogServeTime < time) {
					hq.peek().hotdogServeTime = (hq.peek().hotdog * hotdogServeTime) + time;

				}

				if (hq.peek().hotdogServeTime == time && time != 0) {
					hq.peek().hotdogIsBeingServe = true;
					hq.peek().fullHotdogServeTime = hq.peek().hotdogServeTime;
					hq.peek().hotdog = 0;
					temp = hq.remove();
					// System.out.println("Hotdoq Remove");

					 if (temp.soda > 0) {
						temp.sodaServeTime = (temp.soda * sodaServeTime) + time;
						sq.add(temp);
					}
					else if (temp.popcorn > 0) {
							temp.popcornServeTime = (temp.popcorn * popcornServeTime) + time;
						pq.add(temp);

					} 
				}

			}

			// if soda is empty
			if (!sq.isEmpty() && sq.peek().sodaIsBeingServe == false) {
				if (!sq.isEmpty() && sq.peek().sodaServeTime == 0) {
					// sq.peek().sodaIsBeingServe = true;
					sq.peek().sodaServeTime = sq.peek().soda * sodaServeTime;

				}
				if (sq.peek().sodaServeTime < time) {
					sq.peek().sodaServeTime = (sq.peek().soda * sodaServeTime) + time;

				}
				if (sq.peek().sodaServeTime == time && time != 0) {
					sq.peek().sodaIsBeingServe = true;
					sq.peek().soda = 0;
					sq.peek().fullSodaServeTime = sq.peek().sodaServeTime;
					temp = sq.remove();
					
					 if (temp.popcorn > 0) {
						temp.popcornServeTime = (temp.popcorn * popcornServeTime) + time;
						pq.add(temp);

					}
					else if (temp.hotdog > 0) {

							temp.hotdogServeTime = (temp.hotdog * hotdogServeTime) + time;
						hq.add(temp);

					}


				}

			}

			// if hotdog is empty


			if (a.popcornIsBeingServe == true && a.hotdogIsBeingServe == true && a.sodaIsBeingServe == true)
				a.isFullyServed = true;
			else
				a.queueTime++;
			if (b.popcornIsBeingServe == true && b.hotdogIsBeingServe == true && b.sodaIsBeingServe == true)
				b.isFullyServed = true;
			else
				b.queueTime++;
			if (c.popcornIsBeingServe == true && c.hotdogIsBeingServe == true && c.sodaIsBeingServe == true)
				c.isFullyServed = true;
			else
				c.queueTime++;
			if (a.isFullyServed && b.isFullyServed && c.isFullyServed) {
				checkAllOrders = true;
			}

		}
		System.out.println("Average: " + a.queueTime + " " + b.queueTime + " " + c.queueTime + " " + "/3 = "
				+ ((a.queueTime + b.queueTime + c.queueTime) / 3));
		System.out.println("average time: " + ((a.queueTime + b.queueTime + c.queueTime) / 3));
	}

	// fill in the lines

	// customers is now in a line
	// begin system time
	// begin queueing
	// if queue is empty add a customer

}
