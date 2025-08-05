package net.lulaboludo.createornithopterglider.item;

import net.lulaboludo.createornithopterglider.CreateOrnithopterGlider;
import net.lulaboludo.createornithopterglider.item.custom.OrnithopterGliderItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateOrnithopterGlider.MOD_ID);

    public static final Map<DyeColor, DeferredItem<Item>> ORNITHOPTER_ITEMS = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, DeferredItem<Item>> WING_MESHES = new EnumMap<>(DyeColor.class);
    public static final DeferredItem<Item> ELYTRA_PIECE = ITEMS.register(
            "elytra_piece", () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
            ));
    public static final DeferredItem<Item> ROPE = ITEMS.register(
            "rope", () -> new Item(new Item.Properties()));

    static {
        for (DyeColor color : DyeColor.values()) {
            String name = color == DyeColor.WHITE ? "ornithopterglider" : "ornithopterglider_" + color.getName();
            ORNITHOPTER_ITEMS.put(color, ITEMS.register(name,
                    () -> new OrnithopterGliderItem(new Item.Properties()
                            .durability(432)
                            .rarity(Rarity.UNCOMMON))
            ));
        }
        for (DyeColor color : DyeColor.values()) {
            String name = (color == DyeColor.WHITE) ? "wing_mesh" : "wing_mesh_" + color.getName();
            WING_MESHES.put(color, ITEMS.register(name,
                    () -> new Item(new Item.Properties())
            ));
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
