package net.edwinox.monkeykit.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(24).saturationModifier(2f).build();
    public static final FoodProperties BANANAPULP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5f).build();
}