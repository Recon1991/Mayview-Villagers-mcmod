package com.github.Recon1991.mayview_villagers.villager;

import com.github.Recon1991.mayview_villagers.MayviewVillagers;
import com.google.common.collect.ImmutableSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.sound.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MayviewVillagers.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MayviewVillagers.MOD_ID);

    public static final Holder<PoiType> POKEBALLVENDOR_POI = POI_TYPES.register("pokeballvendor_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.EMERALD_BLOCK.getStateDefinition().getPossibleStates()), 1, 1));

    public static final Holder<VillagerProfession> POKEBALLVENDOR = VILLAGER_PROFESSIONS.register("pokeballvendor",
            () -> new VillagerProfession("pokeballvendor", holder -> holder.value() == POKEBALLVENDOR_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == POKEBALLVENDOR_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.ENCHANTMENT_TABLE_USE
            ));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}