package com.game.src.main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.libs.Animation;

public class Player extends GameObject implements EntityA{
		
	private double velX = 0;
	private double velY = 0;
	private Textures tex;
	
	Animation anim;
	Game game;
	Controller controller;
	
	public Player(double x, double y, Textures tex, Game game, Controller controller){
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.controller = controller;
		
		anim = new Animation(5, tex.player[0], tex.player[1], tex.player[2]);
	}
	
	public void GameOver(){
		Component frame = null;
		JOptionPane.showMessageDialog(frame, "Game Over");
		System.exit(0);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		if (x <= 0)
			x = 0;
		if (x >= 618)
			x = 618;
		if (y <= 0)
			y = 0;
		if (y >= 452)
			y = 452;
		
		for(int i = 0; i < game.eb.size(); i++){
			EntityB tempEnt = game.eb.get(i);
			if(Physics.Collision(this, tempEnt)){
				controller.removeEntity(tempEnt);
				Game.HEALTH -= 10;
				if(Game.HEALTH == 0)
					this.GameOver();
				game.setEnemy_killed(game.getEnemy_killed() + 1);
			}
		}
		
		anim.runAnimation();
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}

	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}
}
