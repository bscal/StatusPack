package me.bscal;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_13;
import com.github.fierioziy.particlenativeapi.core.ParticleNativeCore;
import me.bscal.effects.BleedEffect;
import me.bscal.effects.FractureEffect;
import me.bscal.logcraft.LogCraft;
import me.bscal.statuses.BleedStatus;
import me.bscal.statuses.FractureStatus;
import me.bscal.statuses.Statuses;
import me.bscal.statuses.triggers.EntityDamagedTrigger;
import me.bscal.statuses.triggers.PlayerDamageRecievedTrigger;
import org.bukkit.plugin.java.JavaPlugin;

public class StatusPack extends JavaPlugin
{

	private static StatusPack m_singleton;

	private ParticleNativeAPI m_particleAPI;
	private Particles_1_13 m_particles;

	@Override
	public void onEnable()
	{
		m_singleton = this;

		m_particleAPI = ParticleNativeCore.loadAPI(this);

		// Uses Plugin?
		//		if (!ParticleNativePlugin.isValid())
		//		{
		//			LogCraft.Log("ParticleNativePlugin is not valid. Did you install the ParticleNativeAPI plugin?");
		//			getServer().getPluginManager().disablePlugin(this);
		//		}

		Statuses.Get().GetStatusMgr().RegisterEffect(new BleedEffect());
		Statuses.Get().GetStatusMgr().RegisterEffect(new FractureEffect());

		Statuses.Get().GetStatusMgr().Register(new BleedStatus(), Statuses.Get().GetStatusMgr().GetTrigger(
				PlayerDamageRecievedTrigger.class.getSimpleName()));

		Statuses.Get().GetStatusMgr().Register(new FractureStatus(), Statuses.Get().GetStatusMgr().GetTrigger(
				EntityDamagedTrigger.class.getSimpleName()));

		LogCraft.Log("Loading Statuses module [StatusPack]");
	}

	public static StatusPack Get()
	{
		return m_singleton;
	}

	public ParticleNativeAPI GetParticleAPI()
	{
		return m_particleAPI;
	}

	public Particles_1_13 GetParticles()
	{
		return m_particles;
	}

}
