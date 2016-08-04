package applqpak.KillPoints;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

import applqpak.KillPoints.commands.kp;

import java.io.File;

public class Main extends PluginBase implements CommandExecutor
{

  public Config config;

  @Override

  public void onEnable()
  {

    this.getDataFolder().mkdirs();

    if(!(new File(this.getDataFolder(), "config.yml").exists()))
    {

      saveResource("config.yml");

    }

    this.config = config;

    this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

    this.getServer().getCommandMap().register("killpoints", new kp(this));

    this.getLogger().info(TextFormat.GREEN + "Enabled.");

  }

  @Override

  public void onDisable()
  {

    this.getLogger().info(TextFormat.RED + "Disabled.");

  }

}
