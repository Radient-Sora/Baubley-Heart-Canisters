//package sora.bhc.handler;
//
//import sora.bhc.Reference;
//import net.minecraft.entity.SharedMonsterAttributes;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.common.util.FakePlayer;
//import net.minecraftforge.event.entity.EntityJoinWorldEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.EventPriority;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//
//@Mod.EventBusSubscriber(modid = Reference.MODID)
//public class StartingHealthHandler {
//
//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public static void setStartingHealth(EntityJoinWorldEvent event) {
//        if (OLDCONFIG.allowStartingHealthTweaks) {
//            if (event.getEntity() instanceof EntityPlayer && !(event.getEntity() instanceof FakePlayer)) {
//                EntityPlayer player = (EntityPlayer) event.getEntity();
//                if (OLDCONFIG.startingHealth > 0) {
//                    player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(OLDCONFIG.startingHealth);
//                }
//            }
//        }
//    }
//}
