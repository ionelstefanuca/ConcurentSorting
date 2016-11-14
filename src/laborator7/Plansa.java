package laborator7;

import java.awt.*;
import java.io.*;

class Plansa extends Canvas  implements Runnable  {

	private String nume;
	private static int timp = 100; ///// timpul dintre desenari
	private VectorElem vectorElem;
	private long [] vectorTimpi;
	private long [] vectorClonaTimpi;

	private PipedOutputStream pipeOut;
	private PipedInputStream pipeIn;

		
	Plansa(VectorElem vectorElem,String nume) throws IOException
	{
		this.vectorElem=vectorElem;
		this.nume=nume;
		
		
		
		this.vectorTimpi= new long[2];
		this.vectorTimpi[0] = Fereastra.getTimpStartAplicatie();
		this.vectorTimpi[1] = Fereastra.getTimpStartAplicatie();
		

		 this.pipeOut = new PipedOutputStream();
		 this.pipeIn = new PipedInputStream(pipeOut);
	}	

public Dimension getPreferredSize () {
	int max = this.vectorElem.getVector()[0];
	
	for(int i=1;i<this.vectorElem.getVector().length;i++)
	{
		if(this.vectorElem.getVector()[i]>max)
		{
			max=this.vectorElem.getVector()[i];
		}
	}
	
	return  new Dimension (max *3 , this.vectorElem.getVector().length*11 + 50) ;
}

public synchronized  void paint ( Graphics g ) 
{	
	int valString =30;
	
	g.drawString("nume:"+this.nume, 20, 15);
	g.drawString("Timp: "+(vectorClonaTimpi[1]-vectorClonaTimpi[0]+" ms"), 20, 30);
	
	
	for(int i=0;i <this.vectorElem.getVector().length;i++)
	{
		g.fillRect(20, 10*i+i+valString+5, 2*this.vectorElem.getVector()[i], 10);
		g.drawString(this.vectorElem.getVector()[i]+"", 0, 10*i+i+valString+5 + 10);
	}
}



public void run()
{	
	this.vectorClonaTimpi = this.vectorTimpi.clone();
	
	Thread cronometru = new Cronometru(this.vectorClonaTimpi,this);
	cronometru.start();
	
	if(this.nume.equals("bubbleSort"))
	{
		Thread bb = new BubbleSort(this.vectorElem,this);
		bb.start();
		
		while(bb.isAlive())
		{
			this.scrieInPipe("null");
		}
		
		this.scrieInPipe("bubbleSort"); //oprim timerul	
	}
	
	if(this.nume.equals("QuickSort"))
	{
		Thread quicksort = new MyQuickSort(this.vectorElem,this);
		quicksort.start();
		
		while(quicksort.isAlive())
		{
			this.scrieInPipe("null");
		}
		this.scrieInPipe("QuickSort"); //oprim timerul	
	} 
	
	if(this.nume.equals("maxSort"))
	{
		Thread max = new MaxSort(this.vectorElem,this);
		max.start();	
		
		while(max.isAlive())
		{
			this.scrieInPipe("null");
		}
		this.scrieInPipe("maxSort"); //oprim timerul	
	}		
}


static int getTimp()
{
	return timp;
}
	
long[] getClonaTImpVector()
{
	return this.vectorClonaTimpi;
}


	void scrieInPipe(String str)
	{
		DataOutputStream out = new DataOutputStream(pipeOut);
		try {
			out.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	String CitesteDinPipe()
	{
		DataInputStream in = new DataInputStream(pipeIn);
		String str="null";
		try {
			 str=in.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}

}