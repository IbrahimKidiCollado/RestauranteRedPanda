<template>
    <div class="contenedor-info-usuario">
        <h1>{{ $t('usuario.perfil') }}</h1>
        <div>
            <p class="texto-plantilla">{{ $t('usuario.nombre') }}</p>
            <p>{{ nombreUsuario }}</p>
        </div>
        <div>
            <p class="texto-plantilla">{{ $t('usuario.email') }}</p>
            <p>{{ emailUsuario }}</p>
        </div>
        <div>
            <p class="texto-plantilla">{{ $t('usuario.prefer') }}</p>
            <p>{{ preferenciaIdioma }}</p>
        </div>
    </div>
</template>
<script setup lang="ts">
import { useUserStore } from '@/stores/userStore';
import { computed } from 'vue';

const userStore = useUserStore();
const nombreUsuario = computed(() => userStore.nombreUsuario);
const emailUsuario = computed(() => userStore.emailUsuario);
const preferenciaIdioma = computed(() => userStore.prefenciaIdioma)


</script>
<style lang="scss" scoped>
.contenedor-info-usuario {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 40px;
    background-color: $color-fondo-tarjeta;
    border-radius: 20px;
    margin-bottom: 20px;
    border: 1px solid $color-rojo-oscuro;
    gap: 10px;


    div{
        display: flex;
        flex-direction: column;
    }

    .texto-plantilla{
        font-size: 14px;
        color: $color-gris;
        opacity: 0.8;
        
    }

    p {
        font-size: 18px;
        color: $color-texto-blanco;
        margin: 0;
    }
}

</style>