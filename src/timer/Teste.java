/**
 * 
 */
package timer;

public class Teste {
public  static void main(String[] args) {
	 	
	 int a[] = new int[2];
	 a[0]=0;
	 a[1] =1;
	 
	 int b[] = a.clone();
	 int aux;
	 aux =b[0];
	 b[0]=b[1];
	 b[1]=aux;
	 
	 
	 System.out.println(a[0]+"      "+b[0]);
	 
	}

}
