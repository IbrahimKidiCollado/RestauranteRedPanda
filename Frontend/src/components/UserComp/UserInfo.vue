<template>
    <div class="contenedor-info-usuario">
        <h1>{{ $t('usuario.perfil') }}</h1>
        <div>
            <p class="texto">{{ $t('usuario.nombre') }}</p>
            <p>{{ nombreUsuario }}</p>
        </div>
        <div>
            <p class="texto">{{ $t('usuario.email') }}</p>
            <p>{{ emailUsuario }}</p>
        </div>
        <button class="btn-cerrar" @click="cerrarSesion()">
            {{ $t('usuario.cerrar') }}
        </button>
    </div>
</template>
<script setup lang="ts">
import router from '@/router'
import { useUserStore } from '@/stores/userStore'
import { computed } from 'vue'

const userStore = useUserStore()
const nombreUsuario = computed(() => userStore.nombreUsuario)
const emailUsuario = computed(() => userStore.emailUsuario)

const cerrarSesion = async () => {
    userStore.logout();
    router.push('/tienda')

}
</script>
<style lang="scss" scoped>
.contenedor-info-usuario {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 60px;
    background: $color-rojo-degradado;
    border-radius: 20px;
    margin-bottom: 20px;
    border: 1px solid $color-rojo-oscuro;
    gap: 10px;

    div {
        display: flex;
        flex-direction: column;
    }

    .texto {
        font-size: 18px;
        color: $color-gris;
        opacity: 0.8;
    }

    p {
        font-size: 22px;
        color: $color-texto-blanco;
        margin: 0;
    }
    select {
        font-size: 18px;
    }

    .prefeIdioma {
        border-radius: 10px;
    }

    .btn-cerrar {
        @include boton-rojo();
        margin-top: 20px;
        cursor: pointer;
    }
}
</style>
