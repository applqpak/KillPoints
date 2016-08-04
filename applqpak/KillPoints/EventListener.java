package applqpak.KillPoints;

import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.Player;

public class EventListener implements Listener
{

  public Main plugin;

  public EventListener(Main plugin)
  {

    this.plugin = plugin;

  }

  @EventHandler

  public void onPlayerDeath(PlayerDeathEvent event)
  {

    if(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent)
    {

      Player victim = event.getEntity();

      if(event.getEntity().getLastDamageCause().getDamager() instanceof Player)
      {

        Player killer = event.getEntity().getLastDamageCause().getDamager();

        killer.sendMessage(TextFormat.GREEN + "You have earned +1 KillPoint(s).");

        this.plugin.config.set(killer.getName().toLowerCase(), this.plugin.config.getInt(killer.getName().toLowerCase()) + 1);

        victim.sendMessage(TextFormat.RED + "You have lost -1 KillPoint(s).");

        this.plugin.config.set(victim.getName().toLowerCase(), this.plugin.config.getInt(victim.getName().toLowerCase()) - 1);

      }

    }

  }

}
