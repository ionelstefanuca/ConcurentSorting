package laborator7;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


class Fereastra extends Frame {
	private static long timpStartAplicatie;
	
	public Fereastra ( String titlu ) throws IOException {
		super ( titlu ) ;
		
		timpStartAplicatie =  System.currentTimeMillis();
		
		this . addWindowListener (new WindowAdapter () {
		public void windowClosing ( WindowEvent e ) {
		System . exit (0) ;
		}
		}) ;
		
		VectorElem vect = new VectorElem(50);
		int v[] = vect.getVector();
		
		Plansa bubbleSort = new Plansa (new VectorElem(v),"bubbleSort") ;
		Plansa QuickSort = new Plansa (new VectorElem(v),"QuickSort") ;
		Plansa maxSort = new Plansa (new VectorElem(v),"maxSort") ;
		setLayout (new GridLayout (1 , 3) ) ;
		add ( bubbleSort ) ;
		add ( QuickSort ) ;
		add ( maxSort ) ;
		
		pack () ;
		
		new Thread ( bubbleSort ) . start () ;
		new Thread ( QuickSort ) . start () ;
		new Thread ( maxSort ) . start () ;	
	}
	
	static long getTimpStartAplicatie()
	{
		return timpStartAplicatie;
	}
}