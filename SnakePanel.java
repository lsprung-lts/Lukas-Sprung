import java.awt.*;
import javax.swing.*;
/**
 * Im SnakePanel wird die Schlange bearbeitet(es wird geschaut ob das Futter gegessen wurde, wenn ja wird ein Element hinzugefügt) und gezeichnet.
 * Mit einer If Anweisung wird außerdem geschaut ob man verloren hat, wenn ja dann wird die Schlange rot und ein Timer wird gesetzt 
 * der nach 2 Sekunden dann den "Verloren Bildschirm" aufruft.
 * 
 * @author Lukas Sprung
 * @date 7-11-2013
 */
public class SnakePanel extends JPanel{
	SnakeModel m;
	Point lastPoint;
	int count = 0;
	int erstes = 1;
	JLabel verlLabel;
	int k = 0;
	verloren ver;
	public SnakePanel(SnakeModel m) {
		this.m = m;
		ver = new verloren(m);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(m.richtung != 0) {
			//Es wird geschaut ob das Futter "gegessen" wurde
			if(m.schlange.getLast().x == m.randomx && m.schlange.getLast().y == m.randomy || m.schlange.getLast().x+5 == m.randomx && m.schlange.getLast().y+5 == m.randomy || m.schlange.getLast().x-5 == m.randomx && m.schlange.getLast().y-5 == m.randomy || m.schlange.getLast().x+5 == m.randomx && m.schlange.getLast().y-5 == m.randomy || m.schlange.getLast().x-5 == m.randomx && m.schlange.getLast().y+5 == m.randomy) {
				m.randomneuX(); m.randomneuY();
				g.drawRect(m.randomx, m.randomy, 10,10);
				m.neuesEl(); m.neuesEl(); m.gefangen(); m.zeit++;
			}else {
				g.drawRect(m.randomx, m.randomy, 10,10);
			}   //Die Schlange wird aus Rechtecken gezeichnet
				for(int j = 0; j < m.schlange.size(); j++){
					if(erstes == 1){
						g.setColor(Color.ORANGE);
						g.fillRect(m.schlange.get(j).x, m.schlange.get(j).y, 12, 12);
					}
				g.setColor(Color.BLACK);
				g.fillRect(m.schlange.get(j).x, m.schlange.get(j).y, 10, 10);
				g.setColor(Color.ORANGE);
				g.drawRect(m.schlange.get(j).x, m.schlange.get(j).y, 10, 10);
				erstes++;
			this.repaint(); // refresh
		}
	    g.setColor(Color.ORANGE);
		g.fillRect(m.getX()+1, m.getY()+1, 8,8);
		}else 
		if(m.verloren == true){
			m.endAnimation(ver); // 2 Sekunden ende Timer wird gestartet (siehe Klassenbeschreibung)
			for(int j = 0; j < m.schlange.size(); j++){
			g.setColor(Color.RED);
			g.fillRect(m.schlange.get(j).x, m.schlange.get(j).y, 10, 10);
			g.setColor(Color.BLACK);
			g.drawRect(m.schlange.get(j).x, m.schlange.get(j).y, 10, 10);
			g.setColor(Color.BLACK);
			g.fillRect(m.schlange.getLast().x, m.schlange.getLast().y, 10, 10);
			erstes++;
		    this.repaint();
		    }
		}
	}
}





	
