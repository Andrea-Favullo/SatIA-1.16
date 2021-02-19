package com.chuckita.steveandtheinfernaladventure.blocks;

import com.chuckita.steveandtheinfernaladventure.init.SIATileEntityTypes;
import com.chuckita.steveandtheinfernaladventure.util.SoundRegistrator;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class BlockCrate extends Block {

	// COSTRUTTORE
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

	// QUANDO FACCIO TASTO DESTRO SULLA CASSA
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		// PER GLI ALTRI GIOCATORI VERRÀ SEGNATA COME AZIONE ESEGUITA
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			// INVIO UN MESSAGGIO IN CHAT
			if (!player.isSneaking()) {

				player.sendMessage(new StringTextComponent("Hai inserito un oggetto"), player.getUniqueID());
				ItemStack itemOnHand = player.getHeldItemMainhand();

				if (itemOnHand.getCount() > 0) {

					// tolgo un item
					itemOnHand.setCount(itemOnHand.getCount() - 1);
					

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

	// FEATURES
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.onLivingFall(fallDistance, 0.0F);
		if( fallDistance > 4.0f) {
			//worldIn.destroyBlock(pos, false);
			worldIn.func_241212_a_(pos, false, entityIn, 4);
		}
		
	}

}
