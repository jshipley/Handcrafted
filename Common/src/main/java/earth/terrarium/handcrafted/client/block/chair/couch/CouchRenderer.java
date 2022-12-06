package earth.terrarium.handcrafted.client.block.chair.couch;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.block.chair.ExpandableCouchBlock;
import earth.terrarium.handcrafted.block.chair.couch.CouchBlockEntity;
import earth.terrarium.handcrafted.block.property.CouchShape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CouchRenderer implements BlockEntityRenderer<CouchBlockEntity> {
    public CouchRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(CouchBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        CouchShape shape = entity.getBlockState().getValue(ExpandableCouchBlock.COUCH_SHAPE);
        CouchModel model = switch (shape) {
            case SINGLE -> new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_SINGLE));
            case LEFT -> new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_LEFT));
            case MIDDLE -> new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_MIDDLE));
            case RIGHT -> new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_RIGHT));
            case INNER_LEFT, INNER_RIGHT ->
                    new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_CORNER));
            case OUTER_LEFT, OUTER_RIGHT ->
                    new CouchModel(modelSet.bakeLayer(CouchModel.LAYER_LOCATION_INVERTED_CORNER));
        };
        render(Registry.ITEM.getKey(entity.getCushion().getItem()), Registry.BLOCK.getKey(entity.getBlockState().getBlock()), model, entity.getBlockState().getValue(ExpandableCouchBlock.FACING), shape, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private static void render(ResourceLocation cushion, ResourceLocation texture, CouchModel model, Direction direction, CouchShape shape, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 1.5, 0.5);
        poseStack.mulPose(switch (direction) {
            case EAST -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(90);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(180);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(0);
            };
            case SOUTH -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(0);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(90);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(270);
            };
            case WEST -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(270);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(0);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(180);
            };
            default -> switch (shape) {
                case OUTER_LEFT, INNER_RIGHT, MIDDLE, LEFT, RIGHT, SINGLE -> Vector3f.YP.rotationDegrees(180);
                case INNER_LEFT -> Vector3f.YP.rotationDegrees(270);
                case OUTER_RIGHT -> Vector3f.YP.rotationDegrees(90);
            };
        });
        poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/couch/" + texture.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        if (!cushion.toString().equals("minecraft:air")) {
            model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(texture.getNamespace(), "textures/block/chairs/couch/cushion/" + cushion.getPath() + ".png"))), packedLight, packedOverlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }
        poseStack.popPose();
    }

    public static class ItemRenderer extends BlockEntityWithoutLevelRenderer {
        public ItemRenderer() {
            super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        }

        @Override
        public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
            render(new ResourceLocation(Handcrafted.MOD_ID, "white_cushion"), Registry.ITEM.getKey(stack.getItem()), new CouchModel(Minecraft.getInstance().getEntityModels().bakeLayer(CouchModel.LAYER_LOCATION_SINGLE)), Direction.SOUTH, CouchShape.SINGLE, poseStack, buffer, packedLight, packedOverlay);
        }
    }
}
