package scot.davidhunter.gameprogramming;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display extends Canvas
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3D Game Programming in Java";
	
	public static void main( String[] args )
	{
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add( game );
		frame.pack();
		frame.setTitle( TITLE );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( WIDTH, HEIGHT );
		frame.setLocationRelativeTo( null );
		frame.setResizable( false );
		frame.setVisible( true );
	}
}
