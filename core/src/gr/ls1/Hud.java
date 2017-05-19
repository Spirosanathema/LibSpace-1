package gr.ls1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hud {
	private OrthographicCamera hc;
	private SpriteBatch sb;
	private Texture tex;
	private BitmapFont myfont;
	private GlyphLayout gl;
	private int myCount;
	private float sccore;
	
	
	public Hud(){
		hc = new OrthographicCamera();
		hc.setToOrtho(false, 800, 600);
		sb = new SpriteBatch();
		tex = new Texture("ball.png");
		myfont = new BitmapFont(Gdx.files.internal("font2.fnt"));
		myfont.getData().setScale(.4f);
		myCount = 0;
		sccore = 0;
		gl = new GlyphLayout();
	}
	
	public void update(float dt){
		countUp(dt);
		hc.update();
	}
	
	public void render(){		
		sb.setProjectionMatrix(hc.combined);
		
		sb.begin();
		//sb.draw(tex, 0, 0);
		myfont.draw(sb, gl, 10, 580);
		sb.end();
	}
	
	public void dispose(){
		sb.dispose();
		tex.dispose();
		myfont.dispose();
	}
	
	public String toString(){
		return "Den eimai disposed!!!";
	}
	
	private void countUp(float dt){
		sccore += dt;
		gl.setText(myfont, ""+myCount);
		if(sccore >= 1f){
			
			myCount++;
			sccore = 0;
		}
	}

	
}
