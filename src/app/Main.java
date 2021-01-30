
package app;

import control.Command;
import control.DownCommand;
import control.LeftCommand;
import control.RightCommand;
import control.UpCommand;
import java.util.Map;
import model.Block;
import javax.swing.JFrame;
import view.BlockDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class Main  extends JFrame{
    public static void main(String[] args) {
        new Main().execute();
    }
    private Block block;
    private BlockDisplay blockDisplay;
    private Map<String, Command> commands;
    
    public Main() {
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
    }
    private void execute() {
        this.block = new Block(4,4);
        this.blockDisplay.display(block);
        this.block.register(blockDisplay);
        this.commands= createCommands();
        this.setVisible(true);
    }
    private BlockPanel blockPanel() {
         BlockDisplay blockPanel = new BlockPanel();
         this.blockDisplay = blockPanel;
         return (BlockPanel) blockPanel;
    }
    
    private HashMap<String,Command> createCommands() {
        HashMap<String,Command> comm = new HashMap<>();
        comm.put("Left",new LeftCommand(block));
        comm.put("Rigth",new RightCommand(block));
        comm.put("Up",new UpCommand(block));
        comm.put("Down",new DownCommand(block));
        return comm;
    }
    
    private Component toolbar(){
        JMenuBar bar = new JMenuBar();
        bar.setLayout(new FlowLayout(FlowLayout.CENTER));
        bar.add(button("Left"));
        bar.add(button("Up"));
        bar.add(button("Down"));
        bar.add(button("Rigth"));
        return bar;
    }
    
    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                commands.get(name).execute();
            }
        });
        return button;
    }
    
}
