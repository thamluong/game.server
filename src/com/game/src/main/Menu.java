package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu{
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 250, 100, 50);
	
	//public Rectangle registerButton = new Rectangle(Game.WIDTH / 2 + 120, 200, 150, 50);
	//public Rectangle loginButton = new Rectangle(Game.WIDTH / 2 + 120, 300, 150, 50);
	
	public void render (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("bookman old style", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.lightGray);
		g.drawString("SPACE GAME", Game.WIDTH / 2, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		//g.drawString("Register", registerButton.x + 16, registerButton.y + 36);
		//g2d.draw(registerButton);
		//g.drawString("Login", loginButton.x + 36, loginButton.y + 36);
		//g2d.draw(loginButton);
		g.drawString("Play", playButton.x + 22, playButton.y + 36);		
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x + 22, quitButton.y + 36);
		g2d.draw(quitButton);
	}
}
