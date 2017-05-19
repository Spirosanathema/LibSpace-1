package gr.ls1;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor{

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP){
			MyInputs.setMyKey(MyInputs.UP_MYKEY, true);
		}
		if(keycode == Keys.DOWN){
			MyInputs.setMyKey(MyInputs.DOWN_MYKEY, true);
		}
		if(keycode == Keys.LEFT){
			MyInputs.setMyKey(MyInputs.LEFT_MYKEY, true);
		}
		if(keycode == Keys.RIGHT){
			MyInputs.setMyKey(MyInputs.RIGHT_MYKEY, true);
		}
		if(keycode == Keys.SPACE){
			MyInputs.setMyKey(MyInputs.SPACE_MYKEY, true);
		}
		if(keycode == Keys.ESCAPE){
			MyInputs.setMyKey(MyInputs.ESC_MYKEY, true);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP){
			MyInputs.setMyKey(MyInputs.UP_MYKEY, false);
		}
		if(keycode == Keys.DOWN){
			MyInputs.setMyKey(MyInputs.DOWN_MYKEY, false);
		}
		if(keycode == Keys.LEFT){
			MyInputs.setMyKey(MyInputs.LEFT_MYKEY, false);
		}
		if(keycode == Keys.RIGHT){
			MyInputs.setMyKey(MyInputs.RIGHT_MYKEY, false);
		}
		if(keycode == Keys.SPACE){
			MyInputs.setMyKey(MyInputs.SPACE_MYKEY, false);
		}
		if(keycode == Keys.ESCAPE){
			MyInputs.setMyKey(MyInputs.ESC_MYKEY, false);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}

}
