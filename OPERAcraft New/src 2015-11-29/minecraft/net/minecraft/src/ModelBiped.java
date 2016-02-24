package net.minecraft.src;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.GL11;

public class ModelBiped extends ModelBase
{
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedCloak;

    /**
     * Records whether the model should be rendered holding an item in the left hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right hand, and if that item is a block.
     */
    public int heldItemRight;
    public boolean isSneak;

    /** Records whether the model should be rendered aiming a bow. */
    public boolean aimedBow;

    public ModelBiped()
    {
        this(0.0F);
    }

    public ModelBiped(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelBiped(float par1, float par2, int par3, int par4)
    {
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.isSneak = false;
        this.aimedBow = false;
        this.textureWidth = par3;
        this.textureHeight = par4;
        this.bipedCloak = new ModelRenderer(this, 0, 0);
        this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1);
        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
        this.bipedHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
        this.bipedBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + par2, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + par2, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + par2, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + par2, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        if (this.isChild)
        {
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
            GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
            this.bipedHead.render(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.bipedBody.render(par7);
            this.bipedRightArm.render(par7);
            this.bipedLeftArm.render(par7);
            this.bipedRightLeg.render(par7);
            this.bipedLeftLeg.render(par7);
            this.bipedHeadwear.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.bipedHead.render(par7);
            this.bipedBody.render(par7);
            this.bipedRightArm.render(par7);
            this.bipedLeftArm.render(par7);
            this.bipedRightLeg.render(par7);
            this.bipedLeftLeg.render(par7);
            this.bipedHeadwear.render(par7);
        }
    }


    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {    	
        this.bipedHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.bipedHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;  
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;

        if (this.isRiding)
        {
            this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
            this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
            this.bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
            this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
        }

        if (this.heldItemLeft != 0)
        {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
        }
       
        if (this.heldItemRight != 0)
        {
        	
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
        }

        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F;
        float var8;
        float var9;

        if (this.onGround > -9990.0F)
        {
            var8 = this.onGround;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * (float)Math.PI * 2.0F) * 0.2F;
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
            var8 = 1.0F - this.onGround;
            var8 *= var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            var9 = MathHelper.sin(var8 * (float)Math.PI);
            float var10 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
            this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;                        
        }

        if (this.isSneak)
        {
            this.bipedBody.rotateAngleX = 0.5F;
            this.bipedRightArm.rotateAngleX += 0.4F;
            this.bipedLeftArm.rotateAngleX += 0.4F;
            this.bipedRightLeg.rotationPointZ = 4.0F;
            this.bipedLeftLeg.rotationPointZ = 4.0F;
            this.bipedRightLeg.rotationPointY = 9.0F;
            this.bipedLeftLeg.rotationPointY = 9.0F;
            this.bipedHead.rotationPointY = 1.0F;
            this.bipedHeadwear.rotationPointY = 1.0F;
        }
        else
        {
            this.bipedBody.rotateAngleX = 0.0F;
            this.bipedRightLeg.rotationPointZ = 0.1F;
            this.bipedLeftLeg.rotationPointZ = 0.1F;
            this.bipedRightLeg.rotationPointY = 12.0F;
            this.bipedLeftLeg.rotationPointY = 12.0F;
            this.bipedHead.rotationPointY = 0.0F;
            this.bipedHeadwear.rotationPointY = 0.0F;
        }

        if (this.aimedBow)
        {
            var8 = 0.0F;
            var9 = 0.0F;
            this.bipedRightArm.rotateAngleZ = 0.0F;
            this.bipedLeftArm.rotateAngleZ = 0.0F;
            this.bipedRightArm.rotateAngleY = -(0.1F - var8 * 0.6F) + this.bipedHead.rotateAngleY;
            this.bipedLeftArm.rotateAngleY = 0.1F - var8 * 0.6F + this.bipedHead.rotateAngleY + 0.4F;
            this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            this.bipedRightArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
            this.bipedLeftArm.rotateAngleX -= var8 * 1.2F - var9 * 0.4F;
            this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
            this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        }
        
        // if we are the projector and are currently latched onto one of the cameras
        if (Vars.isProjector && Vars.cameraViewPortValue != 0 && Vars.commandSenderProjector != null /*&& Vars.getCameraByName(par7Entity.getEntityName()) == Vars.cameraViewPortValue */)
        {
        	
        	/*boolean found = false;
        	String projectorName = "";
        	for (String string : Vars.playerToRoles.keySet() )
        	{
        		if (Vars.playerToRoles.get(string).equals("projector"))
        		{
        			found = true;
        			projectorName = string;
        			break;
        		}
        	}
        	if (found)*/
        	if (!Vars.projectorName.equals(""))
    		{
        		//EntityPlayerMP projector = CommandBase.func_82359_c(Minecraft.getMinecraft().thePlayer, projectorName);
    			EntityPlayerMP projector = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(Vars.projectorName);
    			//EntityPlayer camera = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(par7Entity.getEntityName());
    			EntityPlayerMP camera = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(Vars.getCameraByValue(Vars.cameraViewPortValue));
	    		if (projector != null && camera!= null)
	    		{
	    			//System.out.println("!!!");
	    			projector.playerNetServerHandler.setPlayerLocation(camera.posX, camera.posY, camera.posZ, camera.rotationYaw, camera.rotationPitch);
	    		}    
    		}
		}
        
        // if we are a projector (host) and have spectators following projector
        String entityRole = Vars.playerToRoles.get(par7Entity.getEntityName());
        EntityPlayer player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(par7Entity.getEntityName());
        if (Vars.isProjector && Vars.spectatorsFollowingProjector.size() > 0) // we check if we have any spectator followers
        {
        	if (!Vars.projectorName.equals(""))
        	{
        		String spectatorUsername = "";
        		for (int i = 0; i < Vars.spectatorsFollowingProjector.size(); i++) {
        			spectatorUsername = Vars.spectatorsFollowingProjector.get(i);
    	    		//EntityPlayerMP spectator = CommandBase.func_82359_c(Minecraft.getMinecraft().thePlayer, spectatorUsername);
        			EntityPlayerMP spectator = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(spectatorUsername);
        			//EntityPlayer projector = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(Vars.projectorName);
        			EntityPlayerMP projector = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(Vars.projectorName);
    				//System.out.println("*** " + spectator + "\n  * " + projector);
    	    		if (spectator != null && projector!= null)
    	    		{    			
    	    			spectator.playerNetServerHandler.setPlayerLocation(projector.posX, projector.posY, projector.posZ, projector.rotationYaw, projector.rotationPitch);
    	    		}
        		}
        	}
        }
        
        if (Vars.doesOperaCraftPlayerExist(par7Entity.getEntityName()))
        {
        	this.handleArmMovement(par7Entity.getEntityName(), par3);        	    
        }            
        else
        {
        	if (!(par7Entity.getEntityName().equals("Skeleton") || par7Entity.getEntityName().equals("Zombie") || par7Entity.getEntityName().equals("Enderman")))
        	{
        		Vars.addNamesToDatabase(par7Entity.getEntityName());
        	}
        	else
        	{          	
                this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
	            this.bipedLeftArm.rotateAngleZ = 0.0F;
	            this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	            this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	            this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
	            this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        	}
        }
    }

    /**
     * Handles the arm movement of the player
     * 0 - Arms down
     * 1 - Left arm up
     * 2 - Left arm into body
     * 4 - Arms up
     * 5 - Left arm angled
     * 6 - Right arm angled
     * @param username The player to change arm position
     */
    private void handleArmMovement(String username, float value)
    {
    	//both arms are down
    	OperaCraftPlayer player = Vars.getOperaCraftPlayer(username);
    	if (player != null) {
	    	if (Vars.getOperaCraftPlayerArmState(username) == 0)
	    	{
	    		player.adjustArms(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    		//this.sway(value);
	    	}	
	    	
	    	//left arm out only
	    	else if (Vars.getOperaCraftPlayerArmState(username) == 1)
	    	{
	    		player.adjustArms(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
	    		//this.bipedLeftArm.rotateAngleX = -1.5F;  
	    		//this.bipedRightArm.rotateAngleZ = 0.0F;
	    		//this.bipedRightArm.rotateAngleX = 0.0F;
	    	}
	    	//right arm out only
	    	else if (Vars.getOperaCraftPlayerArmState(username) == 2)
	    	{
	    		player.adjustArms(0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F);
	    		//this.bipedRightArm.rotateAngleX = -1.5F;
	    		//this.bipedLeftArm.rotateAngleZ = 0.0F;
	    		//this.bipedLeftArm.rotateAngleX = 0.0F;
	    	}    	  
	    	//arms up
	    	else if (Vars.getOperaCraftPlayerArmState(username) == 3)
	    	{
	    		player.adjustArms(0.0F, 0.0F, -2.7F, 0.0F, 0.0F, 2.7F);
	    		//this.bipedLeftArm.rotateAngleZ = -2.7F;
	    		//this.bipedRightArm.rotateAngleZ = 2.7F;
	    		//this.sway(value);
	    	}  
	    	//left arm angled
	    	else if (Vars.getOperaCraftPlayerArmState(username) == 4)
	    	{
	    		player.adjustArms(-0.6F, 0.0F, -2.3F, 0.0F, 0.0F, 0.0F);
	    		/*
	    		this.bipedLeftArm.rotateAngleZ = -2.3F;
	    		this.bipedLeftArm.rotateAngleX = -0.6F;
	    		this.bipedRightArm.rotateAngleZ = 0.0F;
	    		this.bipedRightArm.rotateAngleX = 0.0F;
	    		*/
	    		//this.sway(value);
	    	} 
	    	//right arm angled
	    	else if (Vars.getOperaCraftPlayerArmState(username) == 5)
	    	{
	    		player.adjustArms(0.0F, 0.0F, 0.0F, -0.6F, 0.0F, 2.3F);
	    		/*
	    		this.bipedRightArm.rotateAngleZ = 2.3F;
	    		this.bipedRightArm.rotateAngleX = -0.6F;
	    		this.bipedLeftArm.rotateAngleZ = 0.0F;
	    		this.bipedLeftArm.rotateAngleX = 0.0F;
	    		*/
	    		//this.sway(value);
	    	}
	    	//System.out.println(player.leftArmRotX + " " + player.leftArmRotY + " " + player.leftArmRotZ + " " + player.rightArmRotX + " " + player.rightArmRotY + " " + player.rightArmRotZ);
    		this.bipedLeftArm.rotateAngleX = player.leftArmRotX;
    		this.bipedLeftArm.rotateAngleY = player.leftArmRotY;
    		this.bipedLeftArm.rotateAngleZ = player.leftArmRotZ;
    		this.bipedRightArm.rotateAngleX = player.rightArmRotX;
    		this.bipedRightArm.rotateAngleY = player.rightArmRotY;
    		this.bipedRightArm.rotateAngleZ = player.rightArmRotZ;
    		
    		if (Vars.getOperaCraftPlayerArmState(username) == 0 || Vars.getOperaCraftPlayerArmState(username) > 2) {
    			this.sway(value);
    		}
    	}	
    }
    
    private void sway(float value)
    {
    	if (value == 0)
    	{
    		this.bipedRightArm.rotateAngleZ += 0;
 	        this.bipedLeftArm.rotateAngleZ -= 0;
 	        this.bipedRightArm.rotateAngleX += 0;
 	        this.bipedLeftArm.rotateAngleX -= 0;	
    	}
    	else
    	{
    		this.bipedRightArm.rotateAngleZ += MathHelper.cos(value * 0.09F) * 0.05F + 0.05F;
	        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(value * 0.09F) * 0.05F + 0.05F;
	        this.bipedRightArm.rotateAngleX += MathHelper.sin(value * 0.067F) * 0.05F;
	        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(value * 0.067F) * 0.05F;
    	}
    }
    /**
     * renders the ears (specifically, deadmau5's)
     */
    public void renderEars(float par1)
    {
        this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedEars.rotationPointX = 0.0F;
        this.bipedEars.rotationPointY = 0.0F;
        this.bipedEars.render(par1);
    }

    /**
     * Renders the cloak of the current biped (in most cases, it's a player)
     */
    public void renderCloak(float par1)
    {
        this.bipedCloak.render(par1);
    }
}
