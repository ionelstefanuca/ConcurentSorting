package laborator7;

import java.util.Random;

public class VectorElem {
	private int [] vector;
	
	VectorElem ( int nr)
	{
		this.vector= new int[nr];
		
		Random rn = new Random();
		
		for(int i=0;i<this.vector.length;i++)
		{
			this.vector[i]=  Math.abs(rn.nextInt() % (nr+nr));
		}
	}
	
	VectorElem(int [] vect)
	{
		this.vector=vect.clone();
	}
	
	
/*	public String toString()
	{
		String str="";
		
		for(int i=0; i< this.vector.length;i++)
		{
			str+=this.vector[i];
			str+=" ";
		}
		
		return str;
	}
	*/
	
	int [] getVector()
	{
		return this.vector;
	}
	
	synchronized void swap(int a, int b)
	{
		int aux;
		aux = this.vector[a];
		this.vector[a]=this.vector[b];
		this.vector[b]=aux;
	}
	
}
