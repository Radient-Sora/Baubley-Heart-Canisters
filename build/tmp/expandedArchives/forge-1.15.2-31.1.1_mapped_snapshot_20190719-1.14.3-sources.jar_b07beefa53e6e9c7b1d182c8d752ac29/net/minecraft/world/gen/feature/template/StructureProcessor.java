package net.minecraft.world.gen.feature.template;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorldReader;

public abstract class StructureProcessor {
   @Nullable
   @Deprecated
   public Template.BlockInfo process(IWorldReader p_215194_1_, BlockPos p_215194_2_, Template.BlockInfo p_215194_3_, Template.BlockInfo p_215194_4_, PlacementSettings p_215194_5_) {
      return p_215194_4_;
   }

   /**
    * FORGE: Add template parameter
    * 
    * @param p_215194_1_
    * @param p_215194_2_
    * @param p_215194_3_
    * @param p_215194_4_
    * @param p_215194_5_
    * @param template The template being placed, can be null due to deprecated
    *                 method calls.
    * @see #process(IWorldReader, BlockPos,
    *      net.minecraft.world.gen.feature.template.Template.BlockInfo,
    *      net.minecraft.world.gen.feature.template.Template.BlockInfo,
    *      PlacementSettings)
    */
   @Nullable
   public Template.BlockInfo process(IWorldReader p_215194_1_, BlockPos p_215194_2_, Template.BlockInfo p_215194_3_, Template.BlockInfo p_215194_4_, PlacementSettings p_215194_5_, @Nullable Template template) {
      return process(p_215194_1_, p_215194_2_, p_215194_3_, p_215194_4_, p_215194_5_);
   }

   /**
    * FORGE: Add entity processing.
    * <p>
    * Use this method to process entities from a structure in much the same way as
    * blocks, parameters are analogous.
    * 
    * @param world
    * @param seedPos
    * @param rawEntityInfo
    * @param entityInfo
    * @param placementSettings
    * @param template
    * 
    * @see #process(IWorldReader, BlockPos,
    *      net.minecraft.world.gen.feature.template.Template.BlockInfo,
    *      net.minecraft.world.gen.feature.template.Template.BlockInfo,
    *      PlacementSettings)
    */
   public Template.EntityInfo processEntity(IWorldReader world, BlockPos seedPos, Template.EntityInfo rawEntityInfo, Template.EntityInfo entityInfo, PlacementSettings placementSettings, Template template) {
      return entityInfo;
   }

   protected abstract IStructureProcessorType getType();

   protected abstract <T> Dynamic<T> serialize0(DynamicOps<T> ops);

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.mergeInto(this.serialize0(ops).getValue(), ops.createString("processor_type"), ops.createString(Registry.STRUCTURE_PROCESSOR.getKey(this.getType()).toString())));
   }
}