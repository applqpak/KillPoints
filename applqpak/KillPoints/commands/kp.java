package applqpak.KillPoints.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.defaults.VanillaCommand;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.Player;

import applqpak.KillPoints.Main;

public class kp extends VanillaCommand
{

  public Main plugin;

  public kp(Main plugin)
  {

    super("killpoints", "killpoints.command", "/killpoints", new String[]{"kp"});

    this.setPermission("killpoints.command");

    this.plugin = plugin;

  }

  @Override

  public boolean execute(CommandSender sender, String label, String[] args)
  {

    if(this.plugin.config.exists(sender.getName().toLowerCase()))
    {

      sender.sendMessage(TextFormat.GREEN + "You have " + this.plugin.config.getString(sender.getName().toLowerCase()) + " KillPoints.");

    }
    else
    {

      sender.sendMessage(TextFormat.RED + "You have no KillPoints.");

    }

    return true;

  }

}
