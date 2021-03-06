package me.bscal.statuses;

import me.bscal.effects.FractureEffect;
import me.bscal.statuses.statuses.StatusBase;
import me.bscal.statuses.statuses.StatusGroup;
import me.bscal.statuses.triggers.EntityDamagedTrigger;
import me.bscal.statuses.triggers.StatusTrigger;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FractureStatus extends StatusBase
{

	public FractureStatus()
	{
		super("Fracture", StatusGroup.FRACTURE.toString(), 30);
		triggers.add(Statuses.Get().GetStatusMgr().GetTrigger(EntityDamagedTrigger.class.getSimpleName()));
		effects.add(new FractureEffect());
	}

	@Override public boolean ShouldApply(StatusTrigger trigger, Player p)
	{
		EntityDamageEvent e = (EntityDamageEvent) trigger.GetEvent();
		return e.getCause() == DamageCause.FALL && e.getDamage() > 5.0;
	}

	@Override public String GetKey(StatusTrigger trigger, Player p)
	{
		return "leg_fracture";
	}

}