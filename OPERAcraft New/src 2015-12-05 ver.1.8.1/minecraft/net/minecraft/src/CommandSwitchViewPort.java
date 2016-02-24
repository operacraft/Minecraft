package net.minecraft.src;

import net.minecraft.client.Minecraft;

/**
 * @author Cody Cahoon
 * @version 2013.11.07
 *
 */
public class CommandSwitchViewPort extends CommandBase {

	/**
	 * The x, y, z coordinates to switch to
	 */
	private double x, y, z;
	/**
	 * The yaw and pitch to switch to
	 */
	private float yaw, pitch;
	/**
	 * Sets the command word for this command to 'view'
	 */
	public String getCommandName() {
		return "view";
	}

	/**
	 * Returns true if the given command sender is allowed to use this command.
	 */
	public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
		if (!Vars.playerToRoles.containsKey(par1ICommandSender.getCommandSenderName()))
			return false;
		return true;
	}

	/**
	 * Processes the command
	 * @param var1 The player sending the command
	 * @param var2 The words which go along with the command (player to switch view to)
	 */
	public void processCommand(ICommandSender var1, String[] var2) {	
		Vars.commandSenderProjector = var1;
		//EntityPlayer changeViewTo = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(var2[0]);
		if (Vars.isProjector)
		{
			EntityPlayer changeViewTo = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(var2[0]);
			if (!var2[0].equals("freeroam") && changeViewTo != null)
			{
				EntityPlayerMP projector;
				projector = func_82359_c(var1, var1.getCommandSenderName());
				if (projector != null)
				{
					Vars.cameraViewPortValue = Vars.getCameraByName(var2[0]);
					this.x = changeViewTo.posX;
					this.y = changeViewTo.posY;
					this.z = changeViewTo.posZ;
					this.yaw = changeViewTo.rotationYaw;
					this.pitch = changeViewTo.rotationPitch;
					projector.playerNetServerHandler.setPlayerLocation(this.x, this.y, this.z, this.yaw, this.pitch);
				}	
			}
			else
			{
				if (var2[0].equals("freeroam"))
				{
					Vars.cameraViewPortValue = 0;
					Vars.viewTimeDelta = 0;
				}
			}
		}		
	}
}