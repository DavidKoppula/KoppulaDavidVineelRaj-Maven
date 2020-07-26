package Maven.Chocolate;


import java.util.*;

class Sweets
{
	static int no_of_chocolates;
	static int no_of_candies;
	public Sweets() {}
	
	public Sweets(int choco,int candi)
	{
		no_of_chocolates=choco;
		no_of_candies=candi;
	}

}

class Chocolates extends Sweets{
	
	String choco_names[] = new String[no_of_chocolates];

	public void name_choco() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<no_of_chocolates;i++) {
			System.out.println("Enter name of the Chocolate:");
			choco_names[i] = sc.next();
		}
		sc.close();
	}
	

	public void sort_choco_names(String order) {
		String temp;
		for(int i=0; i<no_of_chocolates; i++)
      {
          for(int j=1; j<no_of_chocolates; j++)
          {
              if(choco_names[j-1].compareTo(choco_names[i])<0)
              {
                  temp = choco_names[j-1];
                  choco_names[j-1] = choco_names[i];
                  choco_names[i]=temp;
              }
          }
      }
		if(order.compareTo("a")<0) {
			for(int i=0;i<no_of_chocolates;i++)
			    System.out.println(choco_names[i]);
		}
		else {
			 for(int i=(no_of_chocolates-1);i>=0;i--)
				    System.out.println(choco_names[i]);
		}
	}
		
}

class Candies extends Sweets{
	public void count_candies(){
		if(no_of_candies<=50 && no_of_candies>0)
			System.out.println("No. of candies between 1 and 50 " + no_of_candies);
		else if(no_of_candies<=100 && no_of_candies>50)
			System.out.println("No. of candies between 50 and 100 " + no_of_candies);
		else
			System.out.println("No. of candies" + no_of_candies);
	}
}
//main class
public class App{	
	public static void main(String args[]){	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of Gifts:");
		int no_of_gifts = sc.nextInt();
		int nchoco,ncandy,i;
		for(i=0;i<no_of_gifts;i++) {
			System.out.println("Fill the boxes with candies and chocolates");
			System.out.println("Enter no of chocos:");
			nchoco = sc.nextInt();
			System.out.println("Enter no of candies:");
			ncandy = sc.nextInt();
			new Sweets(nchoco,ncandy);
			while(true) {
				System.out.println("1.Total weight\n2.Sort Choclates by name\n3.No. of Candies\n4.Exit");
				int ch = sc.nextInt();
				if (ch == 1) {
					System.out.println(nchoco + ncandy);
				}
				else if(ch == 2) {
					Chocolates c=new Chocolates();
				    c.name_choco();
				    System.out.println("Enter 'a' for ascending order\n enter 'd' for descending order:");
				    String a=sc.next();
				    c.sort_choco_names(a);
				}
				else if(ch == 3) {
					if(ncandy == 0)
						System.out.println("Oops! No candies");
					else {
						Candies cd = new Candies();
						cd.count_candies();
					}
				}
				else {
					break;
				}
				
			}
			System.out.println((i+1) + "nd Gift completed");
		}
		
		sc.close(); 
	}
}