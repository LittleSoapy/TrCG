package com.neet.gamestates;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.neet.managers.GameStateManager;

import Logic.AlgoDeBrese;
import Logic.Reta;

public class PlayState extends GameState {
	
	int NumeroDeRetas = 10;
	
	ArrayList<Reta> retas  = new ArrayList<Reta>();
	
	ShapeRenderer shapeRenderer;
	AlgoDeBrese algoDeBrese;
	Random NumeroRandomico;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		shapeRenderer = new ShapeRenderer();
		algoDeBrese = new AlgoDeBrese();
		NumeroRandomico = new Random();
		
		for (int i = 0; i < NumeroDeRetas; i++) {
			
		}
		
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		Gdx.gl30.glClearColor(0, 0, 0, 1);
		Gdx.gl30.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Line);
		Vector2 v1 = new Vector2(200, 200);
		Vector2 v2 = new Vector2(400, 400);
		algoDeBrese.quadrado(shapeRenderer, v1, v2);


		//shapeRenderer.line(v0, v1);
		
		shapeRenderer.end();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
		
	}

}
