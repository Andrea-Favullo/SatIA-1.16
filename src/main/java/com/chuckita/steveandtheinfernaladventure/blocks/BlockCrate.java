package com.chuckita.steveandtheinfernaladventure.blocks;

import com.chuckita.steveandtheinfernaladventure.util.RegistryHandler;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockCrate extends Block{

	//COSTRUTTORE
	public BlockCrate(AbstractBlock.Properties builder) {
		super(builder
				.hardnessAndResistance(2.5f, 2.5f)
				.sound(SoundType.WOOD)
				.harvestLevel(0)
				.harvestTool(ToolType.AXE));
	}

	//QUANDO FACCIO TASTO DESTRO SULLA CASSA
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		//PER GLI ALTRI GIOCATORI VERRÀ SEGNATA COME AZIONE ESEGUITA
		if (worldIn.isRemote) {
			return ActionResultType.SUCCESS;
		} else {
			//INVIO UN MESSAGGIO IN CHAT
			if(player.isSneaking()) {
				player.sendMessage(new StringTextComponent("Hai cliccato sulla cassa in modalità stealth"), player.getUniqueID());
			}else{
				player.sendMessage(new StringTextComponent("Hai cliccato sulla cassa"), player.getUniqueID());
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
		RegistryHandler.CRATE_TILE_ENTITY.get().create();
	}

}
