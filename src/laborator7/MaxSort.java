package laborator7;

public class MaxSort extends Thread{
	private Plansa plansa;
	private VectorElem vectorElem;
	
	MaxSort(VectorElem vectorElem, Plansa plansa)
	{
		super("Minim Sort");
		
		this.vectorElem=vectorElem;
		this.plansa=plansa;
	}
	
	public void run()
	{
		System.out.println("\n");
		
		Boolean amSchimbat = true;
		int insereazaLa = this.vectorElem.getVector().length-1;
		int pozitiaMaximului = 0;
		
		while(amSchimbat)
		{
			amSchimbat=false;
			int maxim = Integer.MIN_VALUE;
			
			for(int i=0;i<=insereazaLa;i++)
			{
				if(this.vectorElem.getVector()[i]>maxim)
				{
					maxim = this.vectorElem.getVector()[i];
					pozitiaMaximului = i;
					
					amSchimbat=true;
				}
			}
			
			if(amSchimbat)
			{				
				this.vectorElem.swap(pozitiaMaximului, insereazaLa);
				insereazaLa--;
			}
			
			System.out.println(this.getName()+"  "+this);
			
			try {
				Thread.sleep(Plansa.getTimp());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			this.plansa.repaint();
		}
	}
	
	
	public String toString()
	{
		String str ="";
			
		for(int i=0; i< this.vectorElem.getVector().length;i++)
		{
			str+=this.vectorElem.getVector()[i];
			str+=" ";
		}
		
		return str;
	}
	
	
}
