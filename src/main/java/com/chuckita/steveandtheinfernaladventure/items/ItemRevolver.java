package com.chuckita.steveandtheinfernaladventure.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemRevolver extends Item {

	public ItemRevolver(Properties properties) {
		super(properties);
	}
	
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
	    
		//recupero l'istanza del revolver
		ItemStack revolver = playerIn.getHeldItem(handIn);
		
		if(!worldIn.isRemote) {
			//se il revolver non ha un compo8und lo creo, altrimenti uso quello che già esiste per quell'istanza
			if (revolver.getTag()==null) {
				revolver.setTag(new CompoundNBT());
			}
			
			//recupero il compound dell'istanza del revolver
			CompoundNBT compound_revolver = revolver.getTag();
			
			//se nel compound l'attributo bullets ha più di zero proiettili spara, altrimenti ricarica
			if(compound_revolver.getInt("bullets")>0) {
				compound_revolver.putInt("bullets", compound_revolver.getInt("bullets")-1 );
				//sparo
				playerIn.sendMessage(new StringTextComponent("BANG!"), playerIn.getUniqueID());
				
				Vector3d vec = playerIn.getLookVec();
				Vector3d vecDir = vec.add(playerIn.getRNG().nextGaussian()*.1, playerIn.getRNG().nextGaussian()*.1, playerIn.getRNG().nextGaussian()*.1);
				playerIn.sendMessage(new StringTextComponent(vecDir.toString()), playerIn.getUniqueID());
				
			}else {
				//vuoto
				playerIn.sendMessage(new StringTextComponent("Caricatore vuoto!"), playerIn.getUniqueID());
			}
			
			//ricarico se mi abbasso
			if(playerIn.isSneaking()) {
				//ricarica
				compound_revolver.putInt("bullets", 6 );
				playerIn.sendMessage(new StringTextComponent("Ricaricato!"), playerIn.getUniqueID());
			}
			
			
		}
		return new ActionResult<>(ActionResultType.SUCCESS, revolver);
    }
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	    super.addInformation(stack, worldIn, tooltip, flagIn);
	    
	    //Screen.func_231172_r_() CONTROL
	    //Screen.func_231173_s_() SHIFT
	    //Screen.func_231174_t_() ALT
	    
	    ItemStack revolver = stack;
	    
	    if( revolver.hasTag() ) {
		    boolean isShiftPressed = Screen.func_231173_s_();
		    if(!isShiftPressed) {
		    	tooltip.add(new StringTextComponent("Premi shift per controllare il caricatore"));
		    }else{
		    	tooltip.add(new StringTextComponent( revolver.getTag().getInt("bullets")+" proiettili rimasti" ));
		    }
	    }
	}

}
