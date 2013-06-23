package be.imss.powerminer.MineDaCopperOre;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Timer;


public class Utils {
    public interface Condition {
        public boolean validate();
    }

    public static void waitFor(Condition condition, long timeout) {
        Timer timer = new Timer(timeout);

        while (!condition.validate() && timer.isRunning()) {
            if (Players.getLocal().isMoving()) timer.reset();
            Task.sleep(150, 250);
        }
    }
}
