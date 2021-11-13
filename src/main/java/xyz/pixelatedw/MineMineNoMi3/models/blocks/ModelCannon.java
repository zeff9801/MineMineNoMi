package xyz.pixelatedw.MineMineNoMi3.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCannon extends ModelBase
{
	public ModelRenderer cannon1;
	public ModelRenderer cart;
	public ModelRenderer cannon_deco_1;
	public ModelRenderer cannon_deco_2;
	public ModelRenderer cannon_deco_3;
	public ModelRenderer cannon_back;
	public ModelRenderer cannon_back_knob;
	public ModelRenderer cannon_back_2;
	public ModelRenderer cannon_thing;
	public ModelRenderer cart_bottom_1;
	public ModelRenderer cart_wall_front;
	public ModelRenderer cart_wall_left_0;
	public ModelRenderer cart_wall_right_0;
	public ModelRenderer cart_wheel_1;
	public ModelRenderer cart_wheel_2;
	public ModelRenderer cart_wheel_3;
	public ModelRenderer cart_wheel_4;
	public ModelRenderer cart_wall_left_1;
	public ModelRenderer cart_wall_left_2;
	public ModelRenderer cart_wall_right_1;
	public ModelRenderer cart_wall_right_2;

	public ModelCannon()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.cart = new ModelRenderer(this, 24, 44);
		this.cart.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.cart.addBox(-2.5F, 0.0F, -6.0F, 5, 5, 15, 0.0F);
		this.cannon_deco_3 = new ModelRenderer(this, 0, 0);
		this.cannon_deco_3.setRotationPoint(0.0F, -2.5F, -8.5F);
		this.cannon_deco_3.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 1, 0.0F);
		this.cannon_back_2 = new ModelRenderer(this, 0, 0);
		this.cannon_back_2.setRotationPoint(0.0F, -2.5F, 4.0F);
		this.cannon_back_2.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 2, 0.0F);
		this.cannon_back_knob = new ModelRenderer(this, 0, 0);
		this.cannon_back_knob.setRotationPoint(0.0F, -2.5F, 6.0F);
		this.cannon_back_knob.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
		this.cart_wall_right_1 = new ModelRenderer(this, 0, 44);
		this.cart_wall_right_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.cart_wall_right_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
		this.cart_wall_right_2 = new ModelRenderer(this, 0, 44);
		this.cart_wall_right_2.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.cart_wall_right_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 14, 0.0F);
		this.cannon_back = new ModelRenderer(this, 0, 0);
		this.cannon_back.setRotationPoint(0.0F, -2.5F, 0.0F);
		this.cannon_back.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 4, 0.0F);
		this.cart_wheel_1 = new ModelRenderer(this, 0, 0);
		this.cart_wheel_1.setRotationPoint(-1.0F, -1.5F, 2.0F);
		this.cart_wheel_1.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.cannon_deco_1 = new ModelRenderer(this, 0, 0);
		this.cannon_deco_1.setRotationPoint(0.0F, -2.5F, -26.7F);
		this.cannon_deco_1.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 2, 0.0F);
		this.cart_bottom_1 = new ModelRenderer(this, 0, 43);
		this.cart_bottom_1.setRotationPoint(-6.0F, 5.0F, -7.0F);
		this.cart_bottom_1.addBox(0.0F, 0.0F, 0.0F, 12, 1, 20, 0.0F);
		this.cart_wall_front = new ModelRenderer(this, 0, 45);
		this.cart_wall_front.setRotationPoint(-6.0F, -1.0F, -7.0F);
		this.cart_wall_front.addBox(0.0F, 0.0F, 0.0F, 12, 6, 1, 0.0F);
		this.cart_wheel_3 = new ModelRenderer(this, 0, 0);
		this.cart_wheel_3.setRotationPoint(11.0F, -1.5F, 2.0F);
		this.cart_wheel_3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.cannon1 = new ModelRenderer(this, 0, 0);
		this.cannon1.setRotationPoint(0.0F, 14.0F, 6.0F);
		this.cannon1.addBox(-3.0F, -5.5F, -25.0F, 6, 6, 25, 0.0F);
		this.cart_wall_right_0 = new ModelRenderer(this, 0, 44);
		this.cart_wall_right_0.setRotationPoint(4.0F, 3.0F, -6.0F);
		this.cart_wall_right_0.addBox(0.0F, 0.0F, 0.0F, 2, 2, 18, 0.0F);
		this.cart_wheel_2 = new ModelRenderer(this, 0, 0);
		this.cart_wheel_2.setRotationPoint(-1.0F, -1.5F, 12.5F);
		this.cart_wheel_2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.cannon_thing = new ModelRenderer(this, 0, 1);
		this.cannon_thing.setRotationPoint(0.0F, -1.5F, -5.0F);
		this.cannon_thing.addBox(-7.5F, 0.0F, 0.0F, 15, 2, 2, 0.0F);
		this.cart_wall_left_0 = new ModelRenderer(this, 0, 44);
		this.cart_wall_left_0.setRotationPoint(-6.0F, 3.0F, -6.0F);
		this.cart_wall_left_0.addBox(0.0F, 0.0F, 0.0F, 2, 2, 18, 0.0F);
		this.cart_wall_left_2 = new ModelRenderer(this, 0, 44);
		this.cart_wall_left_2.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.cart_wall_left_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 14, 0.0F);
		this.cart_wall_left_1 = new ModelRenderer(this, 0, 44);
		this.cart_wall_left_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.cart_wall_left_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 16, 0.0F);
		this.cannon_deco_2 = new ModelRenderer(this, 0, 0);
		this.cannon_deco_2.setRotationPoint(0.0F, -2.5F, -17.5F);
		this.cannon_deco_2.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 1, 0.0F);
		this.cart_wheel_4 = new ModelRenderer(this, 0, 0);
		this.cart_wheel_4.setRotationPoint(11.0F, -1.5F, 12.5F);
		this.cart_wheel_4.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.cannon1.addChild(this.cannon_deco_3);
		this.cannon1.addChild(this.cannon_back_2);
		this.cannon1.addChild(this.cannon_back_knob);
		this.cart_wall_right_0.addChild(this.cart_wall_right_1);
		this.cart_wall_right_0.addChild(this.cart_wall_right_2);
		this.cannon1.addChild(this.cannon_back);
		this.cart_bottom_1.addChild(this.cart_wheel_1);
		this.cannon1.addChild(this.cannon_deco_1);
		this.cart.addChild(this.cart_bottom_1);
		this.cart.addChild(this.cart_wall_front);
		this.cart_bottom_1.addChild(this.cart_wheel_3);
		this.cart.addChild(this.cart_wall_right_0);
		this.cart_bottom_1.addChild(this.cart_wheel_2);
		this.cannon1.addChild(this.cannon_thing);
		this.cart.addChild(this.cart_wall_left_0);
		this.cart_wall_left_0.addChild(this.cart_wall_left_2);
		this.cart_wall_left_0.addChild(this.cart_wall_left_1);
		this.cannon1.addChild(this.cannon_deco_2);
		this.cart_bottom_1.addChild(this.cart_wheel_4);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.cart.render(f5);
		this.cannon1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
