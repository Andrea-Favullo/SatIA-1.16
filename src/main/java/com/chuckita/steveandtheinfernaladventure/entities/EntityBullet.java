package com.chuckita.steveandtheinfernaladventure.entities;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class EntityBullet extends AbstractArrowEntity {

	protected EntityBullet(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z,
			World worldIn) {
		super(type, x, y, z, worldIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ItemStack getArrowStack() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	private static final DataParameter<Optional<UUID>> SHOOTER_PARAMETER = EntityDataManager.createKey(EntityBullet.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	
	public EntityBullet(EntityType<? extends EntityBullet> type, World world)
	{
		super(type, world);
		this.pickupStatus = PickupStatus.DISALLOWED;
	}

	public EntityBullet(EntityType<? extends EntityBullet> type, World world, double x, double y, double z)
	{
		this(type, world);
		this.setLocationAndAngles(x, y, z, this.rotationYaw, this.rotationPitch);
		this.setPosition(x, y, z);
	}

	public EntityBullet(EntityType<? extends EntityBullet> type, World world, LivingEntity living, double ax, double ay, double az)
	{
		this(type, world, living, living.getPosX(), living.getPosY()+living.getEyeHeight(), living.getPosZ(), ax, ay, az);
	}

	public EntityBullet(EntityType<? extends EntityBullet> type, World world, LivingEntity living, double x, double y, double z, double ax, double ay, double az)
	{
		this(type, world);
		float yaw = living!=null?living.rotationYaw: 0;
		float pitch = living!=null?living.rotationPitch: 0;
		this.setLocationAndAngles(x, y, z, yaw, pitch);
		this.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
		setMotion(ax, ay, az);
		setShooter(living);
		this.setShooterSynced();
		Vector3d motion = getMotion();
		this.shoot(motion.x, motion.y, motion.z, 2*1.5F, 1.0F);
	}

	public void setShooterSynced()
	{
		this.dataManager.set(SHOOTER_PARAMETER, Optional.ofNullable(this.field_234609_b_));
	}
	
	@Nonnull
	@Override
	protected ItemStack getArrowStack(){
		return ItemStack.EMPTY;
	}*/

}
