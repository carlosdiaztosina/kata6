
package app;

import view.BlockDisplay;
import model.Block;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BlockPanel extends JPanel implements BlockDisplay {
    private static final int SIZE = 100;
    private Block block;
    @Override
    public void paint(Graphics j) {
        j.setColor(Color.white);
        j.fillRect(0, 0, getWidth(), getHeight());
        int d = Block.MAX * SIZE;
        j.setColor(Color.red);
        for (int i=0; i<= Block.MAX; i++){
            int c = i*SIZE;
            j.drawLine(0,c,d,c);
            j.drawLine(c, 0, c, d);
        }
        if(block == null) return;
        j.setColor(Color.blue);
        j.fillRect((block.x()-1) * SIZE, (Block.MAX - block.y()) * SIZE, SIZE, SIZE);
    }

    @Override
    public void display(Block block) {
       this.block = block;
       repaint();
    }
    @Override
    public void changed() {
        repaint();
    }
    
}

