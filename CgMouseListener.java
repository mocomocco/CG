/**
 * Listener for mouse events
 */


import java.awt.event.*;
import com.jogamp.opengl.util.Animator;


public class CgMouseListener implements MouseListener, MouseMotionListener {
	CgCanvas canvas;
	Animator animator;

	public CgMouseListener(CgCanvas c, Animator a) {
		canvas = c;
		animator = a;
	}

    /**
     * カーソルを動かした
     */
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * カーソルがウィンドウ内部に入ってきた
     */
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * カーソルがウィンドウ外部に出た
     */
    public void mouseExited(MouseEvent e) {

    }

    /**
     * マウスボタンを一瞬押してウィンドウ内部の位置を指定した
     */
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * マウスボタンを長押ししながらカーソルを動かした
     */
    public void mouseDragged(MouseEvent e) {

    }

    /**
     *マウスボタンを押した(長押しした)
     */
    public void mousePressed(MouseEvent e) {
    	animator.start();
    }

    /**
     * 長押しを終了した
     */
    public void mouseReleased(MouseEvent e) {
    	animator.stop();
    }


}
