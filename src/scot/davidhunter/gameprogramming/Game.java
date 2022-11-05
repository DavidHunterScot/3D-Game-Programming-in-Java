package scot.davidhunter.gameprogramming;

import java.awt.event.KeyEvent;

import scot.davidhunter.gameprogramming.input.Controller;

public class Game
{
	public int time;
	public Controller controls;
	
	public Game()
	{
		controls = new Controller();
	}
	
	public void tick( boolean[] key )
	{
		time++;
		
		boolean forward = key[ KeyEvent.VK_W ];
		boolean left = key[ KeyEvent.VK_A ];
		boolean back = key[ KeyEvent.VK_S ];
		boolean right = key[ KeyEvent.VK_D ];
		boolean jump = key[ KeyEvent.VK_SPACE ];
		boolean crouch = key[ KeyEvent.VK_CONTROL ];
		boolean run = key[ KeyEvent.VK_SHIFT ];
		
		controls.tick( forward, left, back, right, jump, crouch, run );
	}
}
