package net.minecraft.src;
/**
 * A class to hold the players' mouth states, arm states, arm movements, and usernames
 * @author Cody Cahoon
 * @author Ico Bukvic
 * @version 2013.11.20
 *
 */
public class OperaCraftPlayer {

	/**
	 * The user name of the Player
	 */
	private String name;
	
	/**
	 * The arm state of the Player
	 */
	private int armState;	
	
	/**
	 * The leg state of the Player
	 */
	private int legState;
	
	/**
	 * The shoulder state of the Player
	 */
	private int shoulderState;
	
	/**
	 * The mouth state of the Player
	 */
	private int mouthState;
	
	/**
	 * The left arm, x - rotation of the player
	 */
	public float leftArmRotX;
	
	/**
	 * The left arm, y - rotation of the player
	 */
	public float leftArmRotY;
	
	/**
	 * The left arm, z - rotation of the player
	 */
	public float leftArmRotZ;
	
	/**
	 * The right arm, x - rotation of the player
	 */
	public float rightArmRotX;
	
	/**
	 * The right arm, y - rotation of the player
	 */
	public float rightArmRotY;
	
	/**
	 * The right arm, z - rotation of the player
	 */
	public float rightArmRotZ;
	
	/**
	 * The left arm, x - rotation of the player
	 */
	public float leftLegRotX;
	
	/**
	 * The left arm, y - rotation of the player
	 */
	public float leftLegRotY;
	
	/**
	 * The left arm, z - rotation of the player
	 */
	public float leftLegRotZ;
	
	/**
	 * The right arm, x - rotation of the player
	 */
	public float rightLegRotX;
	
	/**
	 * The right arm, y - rotation of the player
	 */
	public float rightLegRotY;
	
	/**
	 * The right arm, z - rotation of the player
	 */
	public float rightLegRotZ;
	
	/**
	 * The left arm, x - rotation of the player
	 */
	public float leftShoulderRotX;
	
	/**
	 * The left arm, y - rotation of the player
	 */
	public float leftShoulderRotY;
	
	/**
	 * The left arm, z - rotation of the player
	 */
	public float leftShoulderRotZ;
	
	/**
	 * The right arm, x - rotation of the player
	 */
	public float rightShoulderRotX;
	
	/**
	 * The right arm, y - rotation of the player
	 */
	public float rightShoulderRotY;
	
	/**
	 * The right arm, z - rotation of the player
	 */
	public float rightShoulderRotZ;
	
	public float incrementAmount;
	/**
	 * Creates a new OperaCraftPlayer object
	 */
	public OperaCraftPlayer()
	{
		this.name = "notassigned";
		this.armState = 0;
		this.mouthState = 0;
		this.leftArmRotX = 0.0F;
		this.leftArmRotY = 0.0F;
		this.leftArmRotZ = 0.0F;
		this.rightArmRotX = 0.0F;
		this.rightArmRotY = 0.0F;
		this.rightArmRotZ = 0.0F;
		this.incrementAmount = 0.0F;
	}
	/**
	 * Creates a new OperaCraftPlayer object with a user name parameter
	 * @param username The user name of the OperaCraftPlayer
	 */
	public OperaCraftPlayer(String username)
	{
		this.name = username;
		this.armState = 0;
		this.mouthState = 0;
		this.leftArmRotX = 0.0F;
		this.leftArmRotY = 0.0F;
		this.leftArmRotZ = 0.0F;
		this.rightArmRotX = 0.0F;
		this.rightArmRotY = 0.0F;
		this.rightArmRotZ = 0.0F;
		this.incrementAmount = 0.0F;
	}	
	/**
	 * Gets the user name of the OperaCraftPlayer
	 * @return The user name
	 */
	public String getUsername()
	{
		return this.name;
	}
	
	/**
	 * Gets the arm state of the OperaCraftPlayer
	 * @return The current arm state value
	 */
	public int getArmState()
	{
		return this.armState;
	}
	
	/**
	 * Gets the shoulder state of the OperaCraftPlayer
	 * @return The current shoulder state value
	 */
	public int getShoulderState()
	{
		return this.shoulderState;
	}
	
	/**
	 * Gets the leg state of the OperaCraftPlayer
	 * @return The current leg state value
	 */
	public int getLegState()
	{
		return this.legState;
	}
	
	/**
	 * Gets the mouth state of the OperaCraftPlayer
	 * @return The current mouth state value
	 */
	public int getMouthState()
	{
		return this.mouthState;
	}
		
	/**
	 * Sets the user name to an inputed value
	 * @param value The name to change to
	 */
	public void setUsername(String value)
	{
		this.name = value;
	}
	
	/**
	 * Sets the arm state to an inputed value 
	 * @param value The arm state to change to
	 */
	public void setArmState(int value, double increment)
	{
		this.armState = value;
		float amount;
		if (increment < 0.5)
			amount = 0.2f;
		else if (increment < 1)
			amount = 0.1f;
		else if (increment < 1.5)
			amount = 0.05f;
		else if (increment < 2.0)
			amount = 0.025f;
		else
			amount = 0.0125f;
		this.incrementAmount = amount;
	}
	
	/**
	 * Adjusts the arms based on the inputed values
	 * @param XL The x - value for the left arm
	 * @param YL The y - value for the left arm
	 * @param ZL The z - value for the left arm
	 * @param XR The x - value for the right arm
	 * @param YR The y - value for the right arm
	 * @param ZR The z - value for the right arm
	 * @param increment how fast to increment the arm movement
	 */
	public void adjustArms(float XL, float YL, float ZL, float XR, float YR, float ZR)
	{
		//System.out.println("VARS: " + XL + " " + YL + " " + ZL + " " + XR + " " + YR + " " + ZR);
		/* left arm */
		float increment = this.incrementAmount;
		if (Math.abs(this.leftArmRotX - XL) >= increment)
		{
			if (this.leftArmRotX > XL)
			{
				this.leftArmRotX -= increment;
			}
			else
			{
				this.leftArmRotX += increment;
			}
		}
		else
		{
			this.leftArmRotX = XL;
		}
		
		if (Math.abs(this.leftArmRotY - YL) >= increment)
		{
			if (this.leftArmRotY > YL)
			{
				this.leftArmRotY -= increment;
			}
			else
			{
				this.leftArmRotY += increment;
			}
		}
		else
		{
			this.leftArmRotY = YL;
		}
		
		if (Math.abs(this.leftArmRotZ - ZL) >= increment)
		{
			if (this.leftArmRotZ > ZL)
			{
				this.leftArmRotZ -= increment;
			}
			else
			{
				this.leftArmRotZ += increment;
			}
		}
		else
		{
			this.leftArmRotZ = ZL;
		}
		
		/* right arm */
		if (Math.abs(this.rightArmRotX - XR) >= increment)
		{
			if (this.rightArmRotX > XR)
			{
				this.rightArmRotX -= increment;
			}
			else
			{
				this.rightArmRotX += increment;
			}
		}
		else
		{
			this.rightArmRotX = XR;
		}
		
		if (Math.abs(this.rightArmRotY - YR) >= increment)
		{
			if (this.rightArmRotY > YR)
			{
				this.rightArmRotY -= increment;
			}
			else
			{
				this.rightArmRotY += increment;
			}
		}
		else
		{
			this.rightArmRotY = YR;
		}
		
		if (Math.abs(this.rightArmRotZ - ZR) >= increment)
		{
			if (this.rightArmRotZ > ZR)
			{
				this.rightArmRotZ -= increment;
			}
			else
			{
				this.rightArmRotZ += increment;
			}
		}
		else
		{
			this.rightArmRotZ = ZR;
		}
		
		//KINECTODO reference new internal variables (kinectRightShoulder, etc.) and add them to the aforesaid variables for arms, or new vars for other parts
		
		//System.out.println("OUT: " + this.leftArmRotX + " " + this.leftArmRotY + " " + this.leftArmRotZ + " " + this.rightArmRotX + " " + this.rightArmRotY + " " + this.rightArmRotZ);
		//System.out.println("===================================");
	}

	/**
	 * Adjusts the arms based on the inputed values
	 * @param XL The x - value for the left arm
	 * @param YL The y - value for the left arm
	 * @param ZL The z - value for the left arm
	 * @param XR The x - value for the right arm
	 * @param YR The y - value for the right arm
	 * @param ZR The z - value for the right arm
	 * @param increment how fast to increment the arm movement
	 */
	public void adjustLegs(float XL, float YL, float ZL, float XR, float YR, float ZR)
	{
		//System.out.println("VARS: " + XL + " " + YL + " " + ZL + " " + XR + " " + YR + " " + ZR);
		/* left leg */
		float increment = this.incrementAmount;
		if (Math.abs(this.leftLegRotX - XL) >= increment)
		{
			if (this.leftLegRotX > XL)
			{
				this.leftLegRotX -= increment;
			}
			else
			{
				this.leftLegRotX += increment;
			}
		}
		else
		{
			this.leftLegRotX = XL;
		}
		
		if (Math.abs(this.leftLegRotY - YL) >= increment)
		{
			if (this.leftLegRotY > YL)
			{
				this.leftLegRotY -= increment;
			}
			else
			{
				this.leftLegRotY += increment;
			}
		}
		else
		{
			this.leftLegRotY = YL;
		}
		
		if (Math.abs(this.leftLegRotZ - ZL) >= increment)
		{
			if (this.leftLegRotZ > ZL)
			{
				this.leftLegRotZ -= increment;
			}
			else
			{
				this.leftLegRotZ += increment;
			}
		}
		else
		{
			this.leftLegRotZ = ZL;
		}
		
		/* right leg */
		if (Math.abs(this.rightLegRotX - XR) >= increment)
		{
			if (this.rightLegRotX > XR)
			{
				this.rightLegRotX -= increment;
			}
			else
			{
				this.rightLegRotX += increment;
			}
		}
		else
		{
			this.rightLegRotX = XR;
		}
		
		if (Math.abs(this.rightLegRotY - YR) >= increment)
		{
			if (this.rightLegRotY > YR)
			{
				this.rightLegRotY -= increment;
			}
			else
			{
				this.rightLegRotY += increment;
			}
		}
		else
		{
			this.rightLegRotY = YR;
		}
		
		if (Math.abs(this.rightLegRotZ - ZR) >= increment)
		{
			if (this.rightLegRotZ > ZR)
			{
				this.rightLegRotZ -= increment;
			}
			else
			{
				this.rightLegRotZ += increment;
			}
		}
		else
		{
			this.rightLegRotZ = ZR;
		}
		
		//KINECTODO reference new internal variables (kinectRightShoulder, etc.) and add them to the aforesaid variables for legs, or new vars for other parts
		
		//System.out.println("OUT: " + this.leftLegRotX + " " + this.leftLegRotY + " " + this.leftLegRotZ + " " + this.rightLegRotX + " " + this.rightLegRotY + " " + this.rightLegRotZ);
		//System.out.println("===================================");
	}
	
	
	/**
	 * Adjusts the arms based on the inputed values
	 * @param XL The x - value for the left arm
	 * @param YL The y - value for the left arm
	 * @param ZL The z - value for the left arm
	 * @param XR The x - value for the right arm
	 * @param YR The y - value for the right arm
	 * @param ZR The z - value for the right arm
	 * @param increment how fast to increment the arm movement
	 */
	public void adjustShoulders(float XL, float YL, float ZL, float XR, float YR, float ZR)
	{
		//System.out.println("VARS: " + XL + " " + YL + " " + ZL + " " + XR + " " + YR + " " + ZR);
		/* left shoulder */
		float increment = this.incrementAmount;
		if (Math.abs(this.leftShoulderRotX - XL) >= increment)
		{
			if (this.leftShoulderRotX > XL)
			{
				this.leftShoulderRotX -= increment;
			}
			else
			{
				this.leftShoulderRotX += increment;
			}
		}
		else
		{
			this.leftShoulderRotX = XL;
		}
		
		if (Math.abs(this.leftShoulderRotY - YL) >= increment)
		{
			if (this.leftShoulderRotY > YL)
			{
				this.leftShoulderRotY -= increment;
			}
			else
			{
				this.leftShoulderRotY += increment;
			}
		}
		else
		{
			this.leftShoulderRotY = YL;
		}
		
		if (Math.abs(this.leftShoulderRotZ - ZL) >= increment)
		{
			if (this.leftShoulderRotZ > ZL)
			{
				this.leftShoulderRotZ -= increment;
			}
			else
			{
				this.leftShoulderRotZ += increment;
			}
		}
		else
		{
			this.leftShoulderRotZ = ZL;
		}
		
		/* right shoulder */
		if (Math.abs(this.rightShoulderRotX - XR) >= increment)
		{
			if (this.rightShoulderRotX > XR)
			{
				this.rightShoulderRotX -= increment;
			}
			else
			{
				this.rightShoulderRotX += increment;
			}
		}
		else
		{
			this.rightShoulderRotX = XR;
		}
		
		if (Math.abs(this.rightShoulderRotY - YR) >= increment)
		{
			if (this.rightShoulderRotY > YR)
			{
				this.rightShoulderRotY -= increment;
			}
			else
			{
				this.rightShoulderRotY += increment;
			}
		}
		else
		{
			this.rightShoulderRotY = YR;
		}
		
		if (Math.abs(this.rightShoulderRotZ - ZR) >= increment)
		{
			if (this.rightShoulderRotZ > ZR)
			{
				this.rightShoulderRotZ -= increment;
			}
			else
			{
				this.rightShoulderRotZ += increment;
			}
		}
		else
		{
			this.rightShoulderRotZ = ZR;
		}
		
		//KINECTODO reference new internal variables (kinectRightShoulder, etc.) and add them to the aforesaid variables for shoulders, or new vars for other parts
		
		//System.out.println("OUT: " + this.leftShoulderRotX + " " + this.leftShoulderRotY + " " + this.leftShoulderRotZ + " " + this.rightShoulderRotX + " " + this.rightShoulderRotY + " " + this.rightShoulderRotZ);
		//System.out.println("===================================");
	}
	
	/**
	 * Sets the mouth state to an inputed value
	 * @param value The mouth state to change to
	 */
	public void setMouthState(int value)
	{
		this.mouthState = value;
	}	
}
