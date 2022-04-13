/** 
 * @author delftstack
 * @source https://www.delftstack.com/fr/howto/java/java-draw-triangle/#:~:text=Dessiner%20un%20triangle%20en%20utilisant%20drawLine()%20en%20Java,-Dans%20la%20classe&text=Nous%20appelons%20la%20m%C3%A9thode%20drawLine,m%C3%A9thode%20drawLine()%20trois%20fois.
 */
package Geometrie;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class DrawFigure extends JComponent {
	private Figure figure;

	public DrawFigure(Figure figure) {
    	this.figure = figure;
    	this.dessine(this);
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Segment s : figure.getSegments()) {
        	g.drawLine((int)s.getPoints().get(0).getX(), (int)s.getPoints().get(0).getY(), (int)s.getPoints().get(1).getX(), (int)s.getPoints().get(1).getY());
		}
    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    public void dessine(DrawFigure dessin) {
        JFrame jFrame = new JFrame();
        jFrame.add(dessin);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // empeche a saisie de s'arreté à la fermeture de la pop up du dessin
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
