package be.imss.powerminer.MineDaCopperOre;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class ClearInventory extends Node {
    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Item item : Inventory.getAllItems(false)) {
            if (item != null) {
                item.getWidgetChild().interact("Drop");
            }
        }
    }
}
