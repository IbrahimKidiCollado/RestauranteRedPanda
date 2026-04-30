<template>
    <div class="container">

    </div>
</template>
<script setup lang="ts">
import { useUserStore } from '@/stores/userStore';
import { computed } from 'vue';
import { usePedidoStore } from '@/stores/pedidoStore';
import { onMounted } from 'vue';

const userStore = useUserStore();
const pedidoStore = usePedidoStore();
const nombreUsuario = computed(() => userStore.nombreUsuario);
const pedidos = computed(() => pedidoStore.obtenerPedidos(userStore.id));

onMounted(() => {
    console.log('Pedidos del usuario:', pedidos.value);
});

</script>
<style lang="scss" scoped>

</style>