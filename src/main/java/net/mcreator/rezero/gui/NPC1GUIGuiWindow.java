
package net.mcreator.rezero.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.rezero.ReZeroMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NPC1GUIGuiWindow extends ContainerScreen<NPC1GUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NPC1GUIGui.guistate;

	public NPC1GUIGuiWindow(NPC1GUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("re_zero:textures/npc_1_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 113, this.guiTop + -97, 46, 20, new StringTextComponent("CHAT"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(0, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 112, this.guiTop + -64, 67, 20, new StringTextComponent("INTERACT"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(1, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -175, this.guiTop + -103, 46, 20, new StringTextComponent("NPC1"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(2, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -174, this.guiTop + -72, 35, 20, new StringTextComponent("村民"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(3, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -176, this.guiTop + 43, 82, 20, new StringTextComponent("tasks to do"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(4, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 169, this.guiTop + 91, 35, 20, new StringTextComponent("关闭"), e -> {
			if (true) {
				ReZeroMod.PACKET_HANDLER.sendToServer(new NPC1GUIGui.ButtonPressedMessage(5, x, y, z));
				NPC1GUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
