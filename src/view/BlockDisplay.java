
package view;

import model.Block;

public interface BlockDisplay extends Block.Observer {
    public void display(Block block);
}
