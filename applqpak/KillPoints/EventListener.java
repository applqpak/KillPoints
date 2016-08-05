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

  public void onEntityDamage(EntityDamageEvent event)
  {

    if(event instanceof EntityDamageByEntityEvent && event.getDamager() instanceof Player)
    {

      Player attacker = event.getDamager();

      Player victim = event.getEntity();

      if(victim.getHealth() == 0)
      {

        attacker.sendMessage(TextFormat.GREEN + "You have earned +1 KillPoints.");

        if(this.plugin.config.exists(attacker.getName().toLowerCase())
        {

          this.plugin.config.set(attacker.getName().toLowerCase(), this.plugin.config.getInt(attacker.getName().toLowerCase()) + 1);

          victim.sendMessage(TextFormat.RED + "You have lost -1 KillPoints.");

          if(this.plugin.config.exists(victim.getName().toLowerCase()))
          {

            this.plugin.config.set(victim.getName().toLowerCase(), this.plugin.config.getInt(victim.getName().toLowerCase()) - 1);

          }
          else
          {

            this.plugin.config.set(victim.getName().toLowerCase(), 0);

          }

        }
        else
        {

          this.plugin.config.set(attacker.getName().toLowerCase(), 1);

        }

      }

    }

  }

}
