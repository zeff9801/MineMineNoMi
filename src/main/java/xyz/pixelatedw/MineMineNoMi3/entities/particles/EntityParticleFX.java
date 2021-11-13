package xyz.pixelatedw.MineMineNoMi3.entities.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityParticleFX extends EntityFX
{
	private ResourceLocation texture;
	private String partName;
	private boolean hasZoom = false;
	
	public EntityParticleFX(World world, ResourceLocation texture, double posX, double posY, double posZ, double motionX, double motionY, double motionZ)
	{
		super(world, posX, posY, posZ, motionX, motionY, motionZ);

		this.texture = texture;
		this.partName = texture.getResourcePath().replace("textures/particles/", "").replace(".png", "").replace("particle_", "");
		
		this.particleScale = 1.3F;
		this.particleGravity = 0F;		
		this.setRBGColorF(1.0F, 1.0F, 1.0F);
		this.particleMaxAge = 30 + this.rand.nextInt(10);
		this.particleAge = 0;
		
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
	}

	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float f2, float f3, float f4, float f5, float f6)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
	 
		GL11.glDepthMask(false);
		//GL11.glEnable(GL11.GL_BLEND);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		
		float scale = 0.1F * particleScale;
		float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		
		float ticks = particleAge;
		
		if(hasZoom)
		{
			if(ticks < 8)
				scale = ticks;
			else
				scale = this.particleMaxAge - ticks;
		}
		
		tess.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
		tess.addVertexWithUV(x - f2 * scale - f5 * scale, y - f3 * scale, z - f4 * scale - f6 * scale, 1, 1);
		tess.addVertexWithUV(x - f2 * scale + f5 * scale, y + f3 * scale, z - f4 * scale + f6 * scale, 1, 0);
		tess.addVertexWithUV(x + f2 * scale + f5 * scale, y + f3 * scale, z + f4 * scale + f6 * scale, 0, 0);
        tess.addVertexWithUV(x + f2 * scale - f5 * scale, y - f3 * scale, z + f4 * scale - f6 * scale, 0, 1);      
        
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 128.0F, 128.0F);		
		
		//GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}
	
    @Override
	public void onUpdate()
    {
    	if(Math.abs(Minecraft.getMinecraft().gameSettings.particleSetting - 2) == 0)
    		this.setDead();
    	
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if(this.particleGravity != 0)
        	this.motionY = -0.04D * this.particleGravity; 
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99D;
        this.motionY *= 0.99D;
        this.motionZ *= 0.99D;
        
        //float lifePercentage = (float)this.particleAge / this.particleMaxAge;
        
        //if(lifePercentage < 0.7)
        //	this.particleAlpha = (lifePercentage * 10) / 3;
                
        if (this.particleAge++ >= this.particleMaxAge || this.onGround)
            this.setDead();	
    }

    public EntityParticleFX setParticleScale(float f) { this.particleScale = f; return this; }
    public EntityParticleFX setParticleGravity(float f) { this.particleGravity = f; return this; }
    public EntityParticleFX setParticleAge(int i) { this.particleMaxAge = i + this.rand.nextInt(10); return this; }
    public EntityParticleFX setHasZoom() { this.hasZoom = true; return this; }
    public EntityParticleFX setParticleTexture(ResourceLocation res)
    {
		this.texture = res;
		this.partName = texture.getResourcePath().replace("textures/particles/", "").replace(".png", "").replace("particle_", "");
		return this;
    }
    
    public String getParticlePartName() { return this.partName; }
    public ResourceLocation getParticleTexture() { return this.texture; }
    public float getParticleScale() { return this.particleScale; }
    public float getParticleGravity() { return this.particleGravity; }
    public int getParticleAge() { return this.particleAge; }
    public boolean hasZoom() { return this.hasZoom; }
    
    public EntityParticleFX clone(double posX, double posY, double posZ)
    {
    	return clone(posX, posY, posZ, 0, 0, 0);
    }
    
    public EntityParticleFX clone(double posX, double posY, double posZ, double motionX, double motionY, double motionZ)
    {
    	EntityParticleFX clone = new EntityParticleFX(this.worldObj, this.texture,
    			posX, posY, posZ,
    			motionX, motionY, motionZ)
    			.setParticleScale(this.particleScale).setParticleGravity(this.particleGravity).setParticleAge(this.particleMaxAge);
    	
    	clone.setRBGColorF(this.particleRed, this.particleGreen, this.particleBlue);
    	
    	if(this.hasZoom)
    		clone.setHasZoom();

    	return clone;
    }
    
    @Override
	public int getFXLayer()
    {
    	int layer = 1;
    	
    	if(this.partName.equals("moku") || this.partName.equals("gasu2") || this.partName.equals("suna2") || this.partName.equals("goro2"))
    		layer = 2;
    	
    	if(this.partName.equals("goro3"))
    		layer = 0;
    	
        return layer;
    }
    
    @Override
	public void setParticleTextureIndex(int i)
    {

    }
}
