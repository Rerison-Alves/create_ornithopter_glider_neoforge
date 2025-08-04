package net.lulaboludo.createornithopterglider.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.lulaboludo.createornithopterglider.CreateOrnithopterGlider;
import net.lulaboludo.createornithopterglider.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

@JeiPlugin
public class OrnithopterJeiPlugin implements IModPlugin {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(CreateOrnithopterGlider.MOD_ID, "jei_plugin");
    public static final ResourceLocation WING_MESH_REPAIR = ResourceLocation.fromNamespaceAndPath(CreateOrnithopterGlider.MOD_ID, "wing_mesh_repair");
    public static final ResourceLocation GLIDER_SELF_REPAIR = ResourceLocation.fromNamespaceAndPath(CreateOrnithopterGlider.MOD_ID, "glider_self_repair");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
        registerGlidersAnvilRepairs(registration, factory);
    }

    private void registerGlidersAnvilRepairs(@NotNull IRecipeRegistration registration, @NotNull IVanillaRecipeFactory factory) {
        ModItems.ORNITHOPTER_ITEMS.forEach((color, gliderRegistry) -> {
            Item glider = gliderRegistry.get();
            Item wingMesh = ModItems.WING_MESHES.get(color).get();

            ItemStack brokenGlider = brokenItem(glider);
            ItemStack damagedGlider = damagedItem(glider);
            ItemStack partialRepairedGlider = partialRepairedItem(glider);

            IJeiAnvilRecipe wingMeshRepair = factory.createAnvilRecipe(
                    brokenGlider,
                    Collections.singletonList(new ItemStack(wingMesh)),
                    Collections.singletonList(damagedGlider),
                    WING_MESH_REPAIR
            );

            IJeiAnvilRecipe gliderSelfRepair = factory.createAnvilRecipe(
                    damagedGlider,
                    Collections.singletonList(damagedGlider.copy()),
                    Collections.singletonList(partialRepairedGlider),
                    GLIDER_SELF_REPAIR
            );

            registration.addRecipes(RecipeTypes.ANVIL, List.of(wingMeshRepair, gliderSelfRepair));
        });
    }

    private static ItemStack brokenItem(Item item) {
        ItemStack stack = new ItemStack(item);
        stack.setDamageValue(stack.getMaxDamage()); // 0% durability
        return stack;
    }

    private static ItemStack damagedItem(Item item) {
        ItemStack stack = new ItemStack(item);
        stack.setDamageValue(stack.getMaxDamage() * 3 / 4); // 25% durability
        return stack;
    }

    private static ItemStack partialRepairedItem(Item item) {
        ItemStack stack = new ItemStack(item);
        stack.setDamageValue(stack.getMaxDamage() * 2 / 4); // 50% durability
        return stack;
    }

}