package com.neet.gamestates;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.neet.managers.GameStateManager;

import Logic.AlgoDeBrese;
import Logic.Clipping;
import Logic.Reta;

public class PlayState extends GameState {

	ArrayList<Reta> retas;

	ShapeRenderer shapeRenderer;
	AlgoDeBrese algoDeBrese;
	Clipping clip;
	Random NumeroRandomico;

	Vector2 retanguloP1;
	Vector2 retanguloP2;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		retanguloP1 = new Vector2(200, 200);
		retanguloP2 = new Vector2(400, 400);
		shapeRenderer = new ShapeRenderer();
		algoDeBrese = new AlgoDeBrese();
		clip = new Clipping(retanguloP1, retanguloP2);
		NumeroRandomico = new Random();
		retas = new ArrayList<Reta>();

		for (int i = 0; i < 50; i++) {

			int x1 = NumeroRandomico.nextInt(800);
			int y1 = NumeroRandomico.nextInt(600);
			int x2 = NumeroRandomico.nextInt(800);
			int y2 = NumeroRandomico.nextInt(600);
			retas.add(new Reta(x1, y1, x2, y2));
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
		
		shapeRenderer.setColor(0, 1, 0, 1);
		algoDeBrese.quadrado(shapeRenderer, retanguloP1, retanguloP2);
		//
		for (Reta reta : retas) {
			reta.CInicio = clip.Codificar(reta.inicio);
			reta.CFim = clip.Codificar(reta.fim);
			clip.Mx = (reta.fim.y - reta.inicio.y) / (reta.fim.x - reta.inicio.x);
			clip.My = (reta.fim.x - reta.inicio.x) / (reta.fim.y - reta.inicio.y);
			if (!(reta.CInicio == 0 && reta.CFim == 0) && !( ((reta.CInicio / 1000) == 1 && (reta.CFim / 1000) == 1)
					|| (((reta.CInicio % 1000) / 100) == 1 && ((reta.CFim % 1000) / 100) == 1)
					|| (((reta.CInicio % 100) / 10) == 1 && ((reta.CFim % 100) / 10) == 1)
					|| ((reta.CInicio % 10 == 1 && reta.CFim % 10 == 1)))) {

				if (reta.CInicio != 0) {
					reta.inicio = clip.Clip(reta.inicio, reta.CInicio);
					reta.CInicio = clip.Codificar(reta.inicio);
				}
				if(reta.CFim != 0) {
					reta.fim = clip.Clip(reta.fim, reta.CFim);
					reta.CFim = clip.Codificar(reta.fim);
				}

			}
			
			if (reta.CInicio == 0 && reta.CFim == 0) {
				shapeRenderer.setColor(0, 0, 1, 1);
				algoDeBrese.Bresenham(shapeRenderer, reta.inicio, reta.fim);
			}
		}
		//

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
