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
    <div class="info-container">
        <div class="imagen"><img src="/assets/bolsa-de-la-compra.png" alt="Pedido" /></div>
        <h1>{{ $t('carrito.carrito-vacio') }}</h1>
        <p>{{ $t('carrito.propuesta-añadir') }}</p>
        <button @click="navegar('/tienda')">{{ $t('carrito.ver-menu') }}</button>
    </div>
</template>
<style lang="scss" scoped>
.carrito-container {
    position: absolute;
    top: 150px;
    left: clamp(2px, 10vw, 300px);
    z-index: 10;

    .enlace-volver {
        display: flex;
        align-items: center;
        gap: 10px;
        color: $color-blanco-sucioMas;
        font-weight: 500;
        transition: 200ms;
        cursor: pointer;

        &:hover {
            color: $color-texto-blanco;
        }
    }

    h1 {
        padding-top: 10px;
        font-size: 40px;
        color: $color-texto-blanco;
    }

    p {
        color: $color-texto-blanco;
    }
}

.info-container {
    display: flex;
    flex-direction: column;
    height: 100vh;
    justify-content: center;
    align-items: center;

    .imagen {
        border-radius: 50%;
        background-color: $color-rojo-oscuro;
        display: inline-block;

        img {
            padding: 30px;
            display: block;
        }
    }

    h1 {
        padding-top: 30px;
        text-align: center;
    }

    p {
        color: $color-blanco-sucioMas;
        font-weight: 500;
        padding-top: 20px;
        text-align: center;
    }

    button {
        @include boton-rojo();
        margin-top: 40px;
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
