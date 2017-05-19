package gr.ls1;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen01 extends GraniteScreen{
	private Texture texture, spacecraftTexture;
	private Sprite sprite;
	private ArrayList<Bullets> bulletsList, bulletsListRemove;
	private float camX, camY;	// CAMERAS VIEWPORTS ACCORDING TO MY SCALE
	private Vector3 camPoint;	// THE POINT THAT CAMERA FOLLOWS EVERYTIME
	private float myViewportScale;	// MY SCALE ACCORDING TO ORIGINAL WINDOW SIZE
	private float lerp;
	private int lol = 0;
	
	public Screen01(MyScreenManager msm){
		super(msm);
		texture = new Texture("spacebk.jpg");
		spacecraftTexture = new Texture("spacecraft.png");
		sprite = new Sprite(spacecraftTexture);
		sprite.setPosition(350, 15);
		bulletsList = new ArrayList<Bullets>();
		bulletsListRemove = new ArrayList<Bullets>();
		//bulletsList.add(new Bullets(sprite));
		myViewportScale = 1/2f;
		lerp = .1f;
		camX = Gdx.graphics.getWidth() * myViewportScale;
		camY = Gdx.graphics.getHeight() * myViewportScale;
		camPoint = new Vector3();
		//vp = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
		//vp.apply();
		
		cam.setToOrtho(false, camX, camY);
		//cam.setToOrtho(false, cam.viewportWidth, cam.viewportHeight);
	}

	@Override
	public void dispose() {
		texture.dispose();
		
	}

	@Override
	public void update(float dt) {
		
		ArrayList<Bullets> bulletsToRemove = new ArrayList<Bullets>(); // TRICK to remove elements from ArrayList while updating the list
		
		for(Bullets b: bulletsList){
			b.bulletsUpdate(dt);
			if(b.getBulletsRemoveFlag() == true){
				bulletsToRemove.add(b);
			}
		}
		bulletsList.removeAll(bulletsToRemove);
		
		camPoint.set(sprite.getX() + sprite.getWidth()/2, sprite.getY() + sprite.getHeight()/2, 0);
		
		
//		cam.position.x = camPoint.x;
//		cam.position.y = camPoint.y;
		
//		lerp:
//			a + (b - a) * lerp;
//			a = curent camera's position
//			b = target's position
		
		cam.position.x += (camPoint.x - cam.position.x) * lerp;
		cam.position.y += (camPoint.y - cam.position.y) * lerp;
		
	// Logic behind camera following a target but NEVER gets out of boundaries
		if(cam.position.x <= camX/2)
			cam.position.x = camX/2;
		if(cam.position.x >= Gdx.graphics.getWidth() - camX/2)
			cam.position.x = Gdx.graphics.getWidth() - camX/2;
		if(cam.position.y <= camY/2)
			cam.position.y = camY/2;
		if(cam.position.y >= Gdx.graphics.getHeight() - camY/2)
			cam.position.y = Gdx.graphics.getHeight() - camY/2;
		
		
//		if(cam.position.x <= Gdx.graphics.getWidth()/2)
//			cam.position.x = Gdx.graphics.getWidth()/2;
//		if(cam.position.x >= Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/2)
//			cam.position.x = Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/2;
//		if(cam.position.y <= Gdx.graphics.getHeight()/2)
//			cam.position.y = Gdx.graphics.getHeight()/2;
//		if(cam.position.y >= Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/2)
//			cam.position.y = Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/2;
			
			
		cam.update();		// VERY IMPORTANTm
	}

	@Override
	public void render() {
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		sb.draw(texture, 0, 0);
		
		for(Bullets b: bulletsList){
			b.getBulletSprite().draw(sb);
		}
		
		sprite.draw(sb);
		
		sb.end();
	}
	
	public void createBullet(){
		bulletsList.add(new Bullets(sprite));
	}
	
	
	
	///////////////////// GETTERS - SETTERS //////////////////////////////////////////////////
	public Texture getSpacecraftTexture(){ return spacecraftTexture; }
	public Sprite getSprite() { return sprite; }

}
