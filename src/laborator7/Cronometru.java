package laborator7;

public class Cronometru  extends Thread{
	private long [] vectorTimpi;
	private Plansa pl;
	
	Cronometru (long [] vect,Plansa pl)
	{
		this.vectorTimpi=vect;
		this.pl=pl;
	}
	
	public void run()
	{
		boolean ruleaza =true;
		String str="";
		
		while(ruleaza)
		{
			pl.getClonaTImpVector()[1] = System.currentTimeMillis();
			
			 str = pl.CitesteDinPipe();
			 
			if(str.equals("null"))
			{
				//firul traieste
			}
			else
				ruleaza=false;
		}
		
			
		System.out.println(str+" s-a terminat-->Oprim timerul");
	}	
}
