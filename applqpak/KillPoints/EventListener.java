package applqpak.KillPoints;

import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.entity.EntityDamageEvent;
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

  public void onPlayerDeath(EntityDamageEvent event)
  {

    if(event instanceof EntityDamageByEntityEvent && event.getEntity() instanceof Player && event.getDamager() instanceof Player)
    {

      Player victim = event.getEntity();

      Player damager = event.getDamager().getPlayer();

      if(!(victim.isAlive()))
      {

        damager.sendMessage(TextFormat.GREEN + "You have earned +1 KillPoint(s).");

        this.plugin.config.set(damager.getName().toLowerCase(), this.plugin.config.getInt(damager.getName().toLowerCase()) + 1);

        victim.sendMessage(TextFormat.RED + "You have lost -1 KillPoint(s).");

        this.plugin.config.set(victim.getName().toLowerCase(), this.plugin.config.getInt(victim.getName().toLowerCase()) - 1);

      }

    }

  }

}
