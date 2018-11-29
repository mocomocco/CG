/**
 * Listener for keyboard events
 */


import java.awt.event.*;
import com.jogamp.opengl.util.Animator;

public class CgKeyListener implements KeyListener {
	CgCanvas canvas;
	Animator animator;

	public CgKeyListener(CgCanvas c, Animator a) {
		canvas = c;
		animator = a;
	}


	/*public CgKeyListener(CgCanvas c) {
		canvas = c;
	}*/



   	/**
	 * Called when a key is pressed
	 */
	public void keyPressed(KeyEvent e) {/*長押しされた時*/
		int key = e.getKeyCode();
		switch (key) {

		// "Q": exit
		case KeyEvent.VK_Q:
			System.exit(0);
			break;

		// "R": reset
		case KeyEvent.VK_SHIFT:
			MyScene.resetMovement();
			canvas.display();
			break;

		case KeyEvent.VK_1://右手をあげる
      MyScene.armchange(0,1);
			canvas.display();
      break;

    case KeyEvent.VK_2://右手を下げる
      MyScene.armchange(0,-1);
			canvas.display();
      break;

		case KeyEvent.VK_3://左手をあげる
      MyScene.armchange(1,1);
			canvas.display();
      break;

		case KeyEvent.VK_4://左手を下げる
      MyScene.armchange(1,-1);
			canvas.display();
      break;

		case KeyEvent.VK_5://右手伸ばす
      MyScene.armchange(4,1);
			canvas.display();
      break;

		case KeyEvent.VK_6://左手伸ばす
      MyScene.armchange(4,-1);
			canvas.display();

		case KeyEvent.VK_7://右手のなんか回す
      MyScene.armchange(2,2);
			canvas.display();
      break;

		case KeyEvent.VK_8://左手のなんか回す
      MyScene.armchange(3,2);
			canvas.display();
      break;

		case KeyEvent.VK_9://右手のなんか回す
      MyScene.armchange(2,1);
			canvas.display();
      break;

		case KeyEvent.VK_0://左手のなんか回す
      MyScene.armchange(3,1);
			canvas.display();
      break;

		// "b": turn
		case KeyEvent.VK_B:
		MyScene.back();
		canvas.display();
		//animator.start();
		break;

		case KeyEvent.VK_R:
		MyScene.turn(2);
		canvas.display();
		break;

		case KeyEvent.VK_L:
			MyScene.turn(-2);
			canvas.display();
			break;

		case KeyEvent.VK_UP:
			canvas.up(1);
			canvas.display();
			break;

        case KeyEvent.VK_DOWN:
		    canvas.up(-1);
			canvas.display();
			break;

		case KeyEvent.VK_LEFT:
			canvas.left(1);
			canvas.display();
			break;

		case  KeyEvent.VK_RIGHT:
			canvas.left(-1);
			canvas.display();
			break;

		case KeyEvent.VK_C:
			canvas.close(-1);
			canvas.display();
      break;

		case KeyEvent.VK_F:
			canvas.close(1);
			canvas.display();
      break;
		}

	}

	/**
	 * Called when a key is released
	 */
	public void keyReleased(KeyEvent e) {/*長押し終了*/
		//animator.stop();
	}

	/**
	 * Called when a key is typed
	 */
	public void keyTyped(KeyEvent e) {/*一瞬おされた*/
		int key = e.getKeyCode();
		switch (key) {
		// "Q": exit
		case KeyEvent.VK_Q:
			System.exit(0);
		}
	}
}
