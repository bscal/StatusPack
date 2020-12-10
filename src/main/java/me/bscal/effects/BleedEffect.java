package me.bscal.effects;

import me.bscal.StatusPack;
import me.bscal.statuses.core.StatusInstance;
import me.bscal.statuses.effects.TickEffect;
import me.bscal.utils.SpigotUtils;
import org.bukkit.ChatColor;
import org.bukkit.Color;

public class BleedEffect extends TickEffect
{

	@Override
	public void OnTick(int tick, StatusInstance instance)
	{
		SpigotUtils.Damage(instance.sPlayer.player, 1);
		instance.GetPlayer().sendMessage(ChatColor.RED + "You are bleeding...");

		Object bloodPacket = StatusPack.Get().GetParticles().DUST().color(Color.RED, 2.0f)
				.packet(false, instance.GetPlayer().getEyeLocation());

		StatusPack.Get().GetParticles().sendPacket(instance.GetPlayer(), bloodPacket);
	}
}
