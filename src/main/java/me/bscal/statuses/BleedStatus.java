package me.bscal.statuses;

import me.bscal.statuses.effects.BleedEffect;
import me.bscal.statuses.statuses.StatusBase;
import me.bscal.statuses.statuses.StatusGroup;
import me.bscal.statuses.triggers.StatusTrigger;
import org.bukkit.entity.Player;

public class BleedStatus extends StatusBase
{

	public BleedStatus()
	{
		super("Bleed", StatusGroup.BLEEDS.toString(), 10);
		effects.add(Statuses.Get().GetStatusMgr().GetEffect(BleedEffect.class.getSimpleName()));
	}

	@Override
	public boolean ShouldApply(StatusTrigger trigger, Player p)
	{
		return true;
	}
	
	@Override
	public String GetKey(StatusTrigger trigger, Player p)
	{
		return "";
	}

}
