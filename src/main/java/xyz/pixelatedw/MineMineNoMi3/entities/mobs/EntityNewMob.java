package xyz.pixelatedw.MineMineNoMi3.entities.mobs;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.debug.WyDebug;
import xyz.pixelatedw.MineMineNoMi3.api.math.WyMathHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAIGeppo;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAIRankyaku;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAISoru;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.ai.abilities.rokushiki.EntityAITekkai;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketEntityNBTSync;

public class EntityNewMob extends EntityMob implements IDynamicRenderer, INBTEntity
{
	protected String[] textures;
	private int doriki, belly, textureId, state;
	private boolean hasBusoHaki;
	private EntityAIBase currentAI, previousAI;
	protected int threat;
	
	public EntityNewMob(World worldIn) 
	{
		this(worldIn, null);
	}
	
	public EntityNewMob(World worldIn, String[] textures) 
	{
		super(worldIn);
		this.addRandomArmor();
		this.textures = textures;
	}

    @Override
	protected void addRandomArmor() {}
	
    @Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data)
    {
        super.onSpawnWithEgg(data);
        this.addRandomArmor();
		if(this.textures != null && this.textures.length > 0)
			this.setTexture(this.rand.nextInt(this.textures.length));

		return data;
    }

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(15, this.textureId);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setInteger("Texture", this.getTextureId());		
		nbt.setInteger("Doriki", this.doriki);
		nbt.setInteger("Belly", this.belly);
		
		nbt.setBoolean("HasBusoHaki", this.hasBusoHaki);
	}
	
	@Override
	public void readEntityFromExtraNBT(NBTTagCompound nbt)
	{
		this.readEntityFromNBT(nbt);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		this.setTexture(nbt.getInteger("Texture"));
		this.doriki = nbt.getInteger("Doriki");
		this.belly = nbt.getInteger("Belly");

		this.hasBusoHaki = nbt.getBoolean("HasBusoHaki");
	}
	
	public void updateNBT()
	{
		NBTTagCompound nbtClone = new NBTTagCompound();
		this.writeEntityToNBT(nbtClone);
		
		if(!this.worldObj.isRemote)
			WyNetworkHelper.sendToAll(new PacketEntityNBTSync(this.getEntityId(), nbtClone));
	}

	@Override
	protected boolean isValidLightLevel()
	{return true;} 
    
	@Override
	protected boolean canDespawn()
	{return true;}
    
	@Override
	public boolean isAIEnabled()
	{return true;}
	
	@Override
	public boolean getCanSpawnHere()
	{return true;}

	public String getTexture() { return textures[this.getTextureId()]; }
	public int getTextureId() { return this.dataWatcher.getWatchableObjectInt(15); }
	protected void setTexture(int texture) { this.dataWatcher.updateObject(15, texture); }	
	
	public int getDoriki()
	{
		return this.doriki;
	}
	
	public void setDoriki(int value)
	{
		this.doriki = value;
	}
	
	public int getBelly()
	{
		return this.belly;
	}
	
	public void setBelly(int value)
	{
		this.belly = value;
	}
	
	public boolean hasBusoHaki()
	{
		return this.hasBusoHaki;
	}
	
	public void setBusoHaki(boolean value)
	{
		this.hasBusoHaki = value;
	}
	
	public EntityAIBase getCurrentAI()
	{
		return this.currentAI;
	}
	
	public EntityAIBase getPreviousAI()
	{
		return this.previousAI;
	}
	
	public void setCurrentAI(EntityAIBase ai)
	{
		this.currentAI = ai;
	}
	
	public void setPreviousAI(EntityAIBase ai)
	{
		this.previousAI = ai;
	}

	public void addRokushikiAbilities(int max)
	{
		if(this.worldObj.isRemote)
			return;
		
		int rokushikiCount = 0;
		boolean hasSoru = false;
		boolean hasTekkai = false;
		boolean hasRankyaku = false;
		boolean hasGeppo = false;
		
		while(rokushikiCount < max)
		{
			if(!hasSoru && WyMathHelper.randomWithRange(1, 10) >= 8)
			{
				this.tasks.addTask(1, new EntityAISoru(this));
				this.threat += 2;
				rokushikiCount++;
				hasSoru = true;
				continue;
			}
	
			if(!hasTekkai && WyMathHelper.randomWithRange(1, 10) >= 8)
			{
				this.tasks.addTask(1, new EntityAITekkai(this));
				this.threat += 5;
				rokushikiCount++;
				hasTekkai = true;
				continue;
			}
			
			if(!hasRankyaku && WyMathHelper.randomWithRange(1, 10) >= 5)
			{
				this.tasks.addTask(1, new EntityAIRankyaku(this));
				this.threat += 20;
				rokushikiCount++;
				hasRankyaku = true;
				continue;
			}
			
			if(!hasGeppo && WyMathHelper.randomWithRange(1, 10) >= 5)
			{
				this.tasks.addTask(1, new EntityAIGeppo(this));
				this.threat += 10;
				rokushikiCount++;
				hasGeppo = true;
				continue;
			}

			rokushikiCount++;
		}
		
		if(WyDebug.isDebug())
		{
			System.out.println("Soru : " + hasSoru);
			System.out.println("Tekkai : " + hasTekkai);
			System.out.println("Rankyaku : " + hasRankyaku);
			System.out.println("Geppo : " + hasGeppo);
		}
	}
	
	@Override
	public String getMobTexture()
	{ return this.getTexture(); }

	@Override
	public double[] itemOffset() 
	{
		return new double[] {0, 0, 0};
	}

	@Override
	public double[] itemScale() 
	{
		return new double[] {1, 1, 1};
	}

}
