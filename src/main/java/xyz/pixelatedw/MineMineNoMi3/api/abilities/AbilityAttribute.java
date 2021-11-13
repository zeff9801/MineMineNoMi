 package xyz.pixelatedw.MineMineNoMi3.api.abilities;

 import net.minecraft.client.model.ModelBase;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.MathHelper;
 import net.minecraft.util.ResourceLocation;
 import xyz.pixelatedw.MineMineNoMi3.ID;
 import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
 import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.EffectType;

 import java.awt.*;

public class AbilityAttribute 
{	
	// Attribute Key
	private String attributeName;
	
	// Ability related fields
	private String abilityDisplayName = "n/a", abilityTexture = "n/a";
	private boolean abilityExplosionHasFire = true, abilityExplosionCanBreakBlocks = true, abilityIsChargeable, abilityIsRepeater, abilityIsPassive, abilityIsPunch, abilityIsFreePassive, abilityStopCharging;
	private int abilityCooldown, abilityMaxCharge, abilityRepeaterTime = 6, abilityRepeaterFreq = 1, abilityExplosionPower;
	private float abilityPunchDamage = 1;
	
	// Projectile related fields
	private boolean projectileMoveThroughBlocks, projectileExplosionHasFire = true, projectileExplosionCanBreakBlocks = true, projectileIsPhysical = false;
	private int projectileTicks = 60, projectileExplosionPower;
	private float projectileAlpha = 255, projectileDamage = 1, projectileSpeed = 1.5F;
	private double projectileXRotation, projectileYRotation, projectileZRotation;
	private Color projectileColor = Color.decode("#FFFFFF");
	private double[] projectileScale = new double[] {1, 1, 1}, projectileCollisionSize = new double[] {0.25, 0.25, 0.25}, projectileModelOffset = new double[] {0, 0, 0};
	private ResourceLocation projectileTexture;
	private ModelBase projectileModel;
	
	// Effects
	private int potionEffectAoeRadius;
	private PotionEffect[] potionEffectsForProjectile, potionEffectsForUser, potionEffectsForAoE, potionEffectsForHit;
	
	
	public AbilityAttribute() {}	
	public AbilityAttribute(String name) 
	{ 
		this.attributeName = name; 
		this.abilityDisplayName = this.attributeName;
		this.abilityTexture = WyHelper.getFancyName(this.attributeName);
	}
		
	public AbilityAttribute(AbilityAttribute attr) 
	{
		this.attributeName = attr.attributeName;

		this.abilityIsChargeable = attr.abilityIsChargeable;
		this.abilityIsRepeater = attr.abilityIsRepeater;
		this.abilityIsPassive = attr.abilityIsPassive;
		this.abilityIsPunch = attr.abilityIsPunch;
		this.abilityStopCharging = attr.abilityStopCharging;
		this.abilityIsFreePassive = attr.abilityIsFreePassive;
		
		this.abilityCooldown = attr.abilityCooldown;
		this.projectileTicks = attr.projectileTicks;
		this.projectileSpeed = attr.projectileSpeed;
		this.abilityExplosionPower = attr.abilityExplosionPower;
		this.projectileExplosionPower = attr.projectileExplosionPower;
		this.potionEffectAoeRadius = attr.potionEffectAoeRadius;
		this.abilityMaxCharge = attr.abilityMaxCharge;
		this.abilityRepeaterTime = attr.abilityRepeaterTime;
		this.abilityRepeaterFreq = attr.abilityRepeaterFreq;
		this.projectileMoveThroughBlocks = attr.projectileMoveThroughBlocks;
		this.projectileExplosionHasFire = attr.projectileExplosionHasFire;
		this.projectileExplosionCanBreakBlocks = attr.projectileExplosionCanBreakBlocks;
		this.abilityExplosionHasFire = attr.abilityExplosionHasFire;
		this.abilityExplosionCanBreakBlocks = attr.abilityExplosionCanBreakBlocks;
		this.projectileIsPhysical = attr.projectileIsPhysical;
		
		this.projectileAlpha = attr.projectileAlpha;
		this.projectileDamage = attr.projectileDamage;
		
		this.projectileXRotation = attr.projectileXRotation;
		this.projectileYRotation = attr.projectileYRotation;
		this.projectileZRotation = attr.projectileZRotation;
		this.abilityPunchDamage = attr.abilityPunchDamage;
		
		this.projectileColor = attr.projectileColor;
		
		this.projectileScale = attr.projectileScale;
		this.projectileCollisionSize = attr.projectileCollisionSize;
		this.projectileModelOffset = attr.projectileModelOffset;
		
		this.projectileModel = attr.projectileModel;
		this.potionEffectsForProjectile = attr.potionEffectsForProjectile;
		this.potionEffectsForUser = attr.potionEffectsForUser;
		this.potionEffectsForAoE = attr.potionEffectsForAoE;
		this.potionEffectsForHit = attr.potionEffectsForHit;
		
		this.projectileTexture = attr.projectileTexture;
		this.abilityTexture = attr.abilityTexture;
		this.abilityDisplayName = attr.abilityDisplayName;
	}
	
	
	public AbilityAttribute setAttributeName(String name) { this.attributeName = name; return this; }
		//Ability
	public AbilityAttribute setAbilityCooldown(double seconds) { this.abilityCooldown = MathHelper.ceiling_double_int(seconds * 20); return this; }	
	public AbilityAttribute setAbilityCharges(int ticks) { this.abilityIsChargeable = true; this.abilityMaxCharge = ticks; return this; }
	public AbilityAttribute setAbilityCharges(int ticks, boolean earlyStop) { this.abilityIsChargeable = true; this.abilityMaxCharge = ticks; this.abilityStopCharging = earlyStop; return this; }
	public AbilityAttribute setAbilityExplosion(int i, boolean fire, boolean explosion) { this.abilityExplosionPower = i; this.abilityExplosionHasFire = fire; this.abilityExplosionCanBreakBlocks = explosion; return this; }
	public AbilityAttribute setAbilityExplosion(int i, boolean fire) { this.abilityExplosionPower = i; this.abilityExplosionHasFire = fire; return this; }
	public AbilityAttribute setAbilityExplosion(int i) { this.abilityExplosionPower = i; return this; }
	public AbilityAttribute setAbilityPassive() { this.abilityIsPassive = true; return this;}
	public AbilityAttribute setAbilityPassive(boolean freePassive) { this.abilityIsPassive = true; this.abilityIsFreePassive = freePassive; return this;}
	public AbilityAttribute setAbilityPunch() { this.abilityIsPassive = true; this.abilityIsPunch = true; return this; }
	public AbilityAttribute setAbilityPunch(float damage) { this.abilityIsPassive = true; this.abilityIsPunch = true; this.abilityPunchDamage = damage; return this; }
	public AbilityAttribute setAbilityRepeater() { this.abilityIsRepeater = true; this.abilityRepeaterTime = 6; this.abilityRepeaterFreq = 1; return this; }
	public AbilityAttribute setAbilityRepeater(int time) { this.abilityIsRepeater = true; this.abilityRepeaterTime = time; this.abilityRepeaterFreq = 1; return this; }
	public AbilityAttribute setAbilityRepeater(int time, int frequency) { this.abilityIsRepeater = true; this.abilityRepeaterTime = time; this.abilityRepeaterFreq = frequency; return this; }
	public AbilityAttribute setAbilityTexture(String textureName) {this.abilityTexture = textureName; return this;}
	public AbilityAttribute setAbilityDisplayName(String displayName) {this.abilityDisplayName = displayName; return this;}	
		//Projectile
	public AbilityAttribute setProjectileTicks(int i) {this.projectileTicks = i;return this;}
	public AbilityAttribute setProjectileDamage(float i) {this.projectileDamage = i;return this;}
	public AbilityAttribute setProjectileModel(ModelBase i) {this.projectileModel = i;return this;}
	public AbilityAttribute setProjectileColor(Color i) {this.projectileColor = i;return this;}
	public AbilityAttribute setProjectileColor(int i) {this.projectileColor = new Color(i);return this;}
	public AbilityAttribute setProjectileColor(String color) {if(color.contains("#")){this.projectileColor = Color.decode(color);}else{this.projectileColor = Color.decode("#" + color);}return this;}
	public AbilityAttribute setProjectileAlpha(float alpha) { this.projectileAlpha = alpha; return this; }
	public AbilityAttribute setProjectileSize(double x, double y, double z) { this.projectileScale = new double[] {x, y, z}; return this; }
	public AbilityAttribute setProjectileSize(double i[]) { this.projectileScale = i; return this; }
	public AbilityAttribute setProjectileExplosion(int i, boolean fire, boolean explosion) {this.projectileExplosionPower = i; this.projectileExplosionHasFire = fire; this.projectileExplosionCanBreakBlocks = explosion; return this;}
	public AbilityAttribute setProjectileExplosion(int i, boolean fire) {this.projectileExplosionPower = i;this.projectileExplosionHasFire = fire;return this;}
	public AbilityAttribute setProjectileExplosion(int i) {this.projectileExplosionPower = i;return this;}
	public AbilityAttribute setProjectileSpeed(float speed) {this.projectileSpeed = speed; return this;}
	public AbilityAttribute setProjectileTexture(String textureName) {this.projectileTexture = new ResourceLocation(ID.PROJECT_ID + ":textures/models/projectiles/" + textureName +".png"); return this;}
	public AbilityAttribute setProjectileXRotation(double angle) { projectileXRotation = angle; return this;}
	public AbilityAttribute setProjectileYRotation(double angle) { projectileYRotation = angle; return this;}
	public AbilityAttribute setProjectileZRotation(double angle) { projectileZRotation = angle; return this;}
	public AbilityAttribute setProjectileMoveThroughBlocks(boolean flag) { projectileMoveThroughBlocks = flag; return this; }
	public AbilityAttribute setProjectileCollisionSizes(double i) { this.projectileCollisionSize = new double[] {i, i, i}; return this; }
	public AbilityAttribute setProjectileCollisionSizes(double i, double j, double k) { this.projectileCollisionSize = new double[] {i, j, k}; return this; }
	public AbilityAttribute setModelOffsets(double i, double j, double k) { this.projectileModelOffset = new double[] {i, j, k}; return this; }
	public AbilityAttribute setProjectilePhysical() { this.projectileIsPhysical = true; return this; }
		//Potion Effects
	public AbilityAttribute addEffects(EffectType type, PotionEffect... e) 
	{
		if(type == EffectType.PROJECTILE) this.potionEffectsForProjectile = e;
		if(type == EffectType.USER) this.potionEffectsForUser = e;
		if(type == EffectType.AOE) this.potionEffectsForAoE = e;
		if(type == EffectType.HIT) this.potionEffectsForHit = e;
		return this;
	}
	public AbilityAttribute setEffectRadius(int i) { this.potionEffectAoeRadius = i;return this;}


		//Ability
	public int getAbilityCooldown() { return abilityCooldown; }
	public boolean isRepeater() { return this.abilityIsRepeater; }
	public boolean canStopChargeEarly() { return this.abilityStopCharging; }
	public boolean canAbilityBeCharged() { return this.abilityIsChargeable;}
	public int getAbilityExplosionPower() { return this.abilityExplosionPower; }
	public int getAbilityCharges() {return this.abilityMaxCharge;}	
	public boolean canAbilityExplosionSetFire() { return this.abilityExplosionHasFire; }
	public boolean canAbilityExplosionDestroyBlocks() { return this.abilityExplosionCanBreakBlocks; }
	public boolean isPassive() { return this.abilityIsPassive; }
	public int getAbilityRepeaterTime() { return this.abilityRepeaterTime; }
	public int getAbilityRepeaterFrequency() { return this.abilityRepeaterFreq; }
	public boolean isPunch() { return this.abilityIsPunch; }
	public float getPunchDamage() { return this.abilityPunchDamage; }
	public String getAbilityTexture() { return this.abilityTexture; }
	public String getAbilityDisplayName() { return this.abilityDisplayName; }
	public boolean isAbilityFreePassive() { return this.abilityIsFreePassive; }
		//Projectile
	public boolean hasProjectile() { return this.projectileTicks > 0 && this.projectileModel != null; }
	public int getProjectileTicks() { return projectileTicks; }
	public float getProjectileDamage() { return projectileDamage; }
	public Color getProjectileColor() { return projectileColor; }
	public ModelBase getProjectileModel() { return projectileModel; }
	public double[] getProjectileSize() { return projectileScale; }
	public float getProjectileSpeed() { return projectileSpeed; }
	public int getProjectileExplosionPower() { return projectileExplosionPower; }		
	public boolean canProjectileExplosionSetFire() { return projectileExplosionHasFire; }
	public boolean canProjectileExplosionDestroyBlocks() { return projectileExplosionCanBreakBlocks; }	
	public float getProjectileAlpha() { return this.projectileAlpha; }
	public ResourceLocation getProjectileTexture() { return this.projectileTexture; }
	public double getProjectileXRotation() { return this.projectileXRotation; }
	public double getProjectileYRotation() { return this.projectileYRotation; }
	public double getProjectileZRotation() { return this.projectileZRotation; }
	public boolean canProjectileMoveThroughBlocks() { return this.projectileMoveThroughBlocks; }
	public double[] getProjectileCollisionSizes() { return this.projectileCollisionSize; }
	public double[] getModelOffsets() { return this.projectileModelOffset; }
	public boolean isProjectilePhysical() { return this.projectileIsPhysical; }
		//Potion Effects
	public PotionEffect[] getPotionEffectsForHit() {return this.potionEffectsForHit;}
	public PotionEffect[] getPotionEffectsForProjectile() {return this.potionEffectsForProjectile;}
	public PotionEffect[] getPotionEffectsForUser() {return this.potionEffectsForUser;}
	public PotionEffect[] getPotionEffectsForAoE() {return this.potionEffectsForAoE;}
	public int getEffectRadius() {return this.potionEffectAoeRadius;}
		//Misc
	public String getAttributeName() {return this.attributeName;}
	
	
}
