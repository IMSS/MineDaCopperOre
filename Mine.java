package be.imss.powerminer.MineDaCopperOre;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;





public class Mine extends Node {
    private static final int[] ORE_ID = {11954, 11955, 11956, 3229};
    private SceneObject ore;


    @Override
    public boolean activate() {
        return Inventory.getCount() < 28 && (ore = SceneEntities.getNearest(ORE_ID)) != null
                && Players.getLocal().getAnimation() != 625;
    }

    @Override
    public void execute() {
        if (ore.isOnScreen()) {
            if (ore.interact("Mine")) {
                Utils.waitFor(new Utils.Condition() {
                    @Override
                    public boolean validate() {
                        return ore == null;
                    }
                }, 1000);
            }
        } else {
            Camera.turnTo(ore);
        }
    }



}
