package be.imss.powerminer.MineDaCopperOre;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

import java.awt.*;


@Manifest(name = "MineDaCopperOre", authors = "IMSS", description = "Mines copper ores @ any location")
public class MineDaCopperOre extends ActiveScript implements PaintListener  {
    private Tree nodeTree;


    @Override
    public void onStart() {
        nodeTree = new Tree(new Node[]{new Mine(), new ClearInventory()});
    }      long expHour = 0;
           long startTime = 0;
           int expGained;


    @Override
    public int loop() {
        if (nodeTree != null) {
            final Node job = nodeTree.state();

            if (job != null) {
                nodeTree.set(job);
                getContainer().submit(job);
                job.join();
            }
        }

        return Random.nextInt(150, 250);
    }




private final Color color1 = new Color(51, 102, 255);
private final Color color2 = new Color(0, 102, 255);
private final Color color3 = new Color(255, 255, 255);

private final BasicStroke stroke1 = new BasicStroke(1);
private final Font font1 = new Font("Arial", 0, 14);
private final Font font2 = new Font("Arial", 0, 30);

    public void onRepaint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        expHour = (long) ((3600000.0 / (System.currentTimeMillis() - startTime)) * expGained);
        g.setColor(color1);
        g.fillRoundRect(10, 401, 480, 103, 16, 16);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRoundRect(10, 401, 480, 103, 16, 16);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString("XP hour:"+expHour, 19, 425);
        g.drawString("XPGained:"+expGained, 20, 448);
        g.drawString("Time ran:"+ Time.format(System.currentTimeMillis() - startTime), 19, 472);
        g.setFont(font2);
        g.drawString("MineDaOre By IMSS", 141, 439);
    }


}