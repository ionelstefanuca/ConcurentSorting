package laborator7;

import java.awt.Dimension;

public class BubbleSort extends Thread {
	private Plansa plansa;
	private VectorElem vectorElem;
	
	BubbleSort(VectorElem vect, Plansa pl)
	{
		super("Bubble sort");
		this.plansa=pl;
		this.vectorElem=vect;
	}
	
	public void run()
	{
		for(int i=0;i<this.vectorElem.getVector().length;i++)
		{
			for(int j=0;j<this.vectorElem.getVector().length;j++)
			{
				int aux;
				if(this.vectorElem.getVector()[i]<this.vectorElem.getVector()[j])
				{				
					this.vectorElem.swap(i, j);	
				}
				
				this.plansa.repaint();	
			}
			System.out.println(this.getName()+" "+this);
			
			try {
				Thread.sleep(Plansa.getTimp());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
				
	}
	
	
	public String toString()
	{
		String str="";
		
		for(int i=0;i<this.vectorElem.getVector().length;i++)
		{
			str+=this.vectorElem.getVector()[i];
			str+="  ";
		}
		return str;
	}
	
	public Dimension getPreferredSize () {
		return  new Dimension (300 , 300) ;
	}

}
