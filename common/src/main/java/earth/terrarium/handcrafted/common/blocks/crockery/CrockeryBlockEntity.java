package earth.terrarium.handcrafted.common.blocks.crockery;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrockeryBlockEntity extends BlockEntity {
    private ItemStack item = ItemStack.EMPTY;

    public CrockeryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CROCKERY.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.item.isEmpty()) {
            tag.put("item", item.save(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.item = ItemStack.parse(registries, tag.getCompound("item")).orElse(ItemStack.EMPTY);
    }

    public ItemStack getStack() {
        return this.item;
    }

    public void setStack(ItemStack item) {
        this.item = item;
        this.update();
    }

    public void update() {
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
