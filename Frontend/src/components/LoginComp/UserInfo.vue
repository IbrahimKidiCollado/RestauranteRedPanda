<template>
    <div class="contenedor-info-usuario">
        <p>{{ $t('usuario.bienvenido') }} {{ nombreUsuario }}</p>
    </div>
</template>
<script setup lang="ts">
import { useUserStore } from '@/stores/userStore';
import { computed } from 'vue';

const userStore = useUserStore();
const nombreUsuario = computed(() => userStore.nombreUsuario);


</script>
<style lang="scss" scoped>
.contenedor-info-usuario {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 10px;
    background-color: $color-fondo-header;
    border-radius: 5px;
    margin-bottom: 20px;
    border: 1px solid $color-rojo-oscuro;

    p {
        font-size: 18px;
        color: $color-texto-blanco;
        margin: 0;
    }
}

</style>