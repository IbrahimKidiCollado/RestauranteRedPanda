<template>
    <link
        rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=arrow_back"
    />
    <div class="carrito-container">
        <p @click="navegar('/tienda')" class="enlace-volver">
            <span class="material-symbols-outlined"> arrow_back </span>{{ $t('carrito.continuar') }}
        </p>
        <h1 class="">{{ $t('carrito.titulo') }}</h1>
        <p><!-- {{ $conteoProductos }} -->{{ $t('carrito.productos-cantidad') }}</p>
    </div>
</template>
<style lang="scss" scoped>
.carrito-container {
    padding-top: 50px;
    padding-left: 30px;

    .enlace-volver {
        display: flex;
        align-items: center;
        gap: 10px;

        color: $color-blanco-sucioMas;
        font-weight: 500;
        transition: 200ms;

        &:hover {
            color: $color-texto-blanco;
        }
    }

    h1 {
        padding-top: 10px;
        font-size: 40px;
    }

    p {
        color: $color-texto-blanco;
    }
}
</style>
<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref } from 'vue'

const router = useRouter()

const navegar = (path: string) => {
    router.push(path)
}

const conteoProductos = ref(0)

// eslint-disable-next-line @typescript-eslint/no-unused-vars
const añadirProductos = () => {
    conteoProductos.value++
}
</script>
