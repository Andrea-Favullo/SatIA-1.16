package com.chuckita.steveandtheinfernaladventure.blocks;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;
import com.chuckita.steveandtheinfernaladventure.tileentity.CrateTileEntity;
import com.chuckita.steveandtheinfernaladventure.util.SoundRegistrator;
import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockCrate extends FallingBlock {

	// metodo costruttore
	public BlockCrate(AbstractBlock.Properties builder) {
		super(builder.hardnessAndResistance(0.5f, 0.5f)

				.sound(new SoundType(1.0F, // volume
						1.0F, // intonazione (pitch)
						SoundRegistrator.CRATE_BREAK, // distruzione blocco
						SoundEvents.BLOCK_WOOD_STEP, // calpesto il blocco
						SoundRegistrator.CRATE_PLACING, // piazzo il blocco
						SoundRegistrator.CRATE_BREAKING, // colpisco il blocco
						SoundEvents.BLOCK_WOOD_FALL) // ???
				)
				.harvestLevel(0).harvestTool(ToolType.AXE));
	}

	// quando faccio tasto destro sulla cassa
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			if (!player.isSneaking()) {
				
				//recupero l' item che tiene in mano il giocatore
				ItemStack itemOnHand = player.getHeldItemMainhand();
				
				//recupero la tile entity della cassa
				CrateTileEntity crate = (CrateTileEntity)worldIn.getTileEntity(pos);
				//recupero il compound della cassa
				CompoundNBT crate_compound = crate.getUpdateTag();
				//recupero le informazioni
				crate.read(state, crate_compound);
				
				//stampo le informazioni
				player.sendMessage(new StringTextComponent("[1] Compound recuperato:\n" + crate_compound.toString()), player.getUniqueID());

				
				if(!crate_compound.hasUniqueId("item")) {

					//chat warning
					player.sendMessage(new StringTextComponent("[2] Esiste un campo item!"), player.getUniqueID());
					
					//prima di inserire item faccio dei controlli
					if ((itemOnHand.getCount() > 0) ) {

						//chat warning
						player.sendMessage(new StringTextComponent("[3] Hai inserito un oggetto ..."), player.getUniqueID());
						/*
						compound.putString("id", itemOnHand.serializeNBT().getString("id"));
						compound.putInt("count", itemOnHand.serializeNBT().getInt("Count"));
						*/
						
						//aggiungo l' item
						crate_compound.put("item", itemOnHand.serializeNBT());
						//aggiorno il compound
						crate_compound = crate.write(crate_compound);
						
						//chat warning
						player.sendMessage(new StringTextComponent("[4] Compound aggiornato:\n" + crate_compound.toString()), player.getUniqueID());
						
						// tolgo un item dalla mano del giocatore
						itemOnHand.setCount(itemOnHand.getCount() - 1);
						
					}
				}else {
					
					//recupero le informazioni
					crate.read(state, crate_compound);
					
					//stampo le informazione
					player.sendMessage(new StringTextComponent("[3] Contenuti:\n" + crate_compound.toString()), player.getUniqueID());
				}
			}
			return ActionResultType.CONSUME;
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return SIATileEntityTypes.CRATE.get().create();
	}

	/**
	 * il blocco viene distrutto se un' entità cade sul blocco da abbastanza in alto
	 */
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.onLivingFall(fallDistance, 0.0F);
		if( fallDistance > 4.0f ) {
			worldIn.destroyBlock(pos, false);
		}
	}
	/**
	* il blocco viene distrutto se viene colpito da una freccia
	 */
	@Override
	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
		worldIn.destroyBlock(hit.getPos(), false);
	}
	/**
	 * il blocco viene distrutto se cade dall'alto
	 */
	@Override
	public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
		worldIn.destroyBlock(pos, false);
	}
}
