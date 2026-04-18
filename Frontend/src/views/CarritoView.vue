<template>
    <div class="tituloContainer">
        <p @click="navegar('/tienda')" class="enlace-volver">
            <span class="material-symbols-outlined"> arrow_back </span>{{ $t('carrito.continuar') }}
        </p>
        <h1 class="">{{ $t('carrito.titulo') }}</h1>
        <p>{{ cantidadProductosCarrito }} {{ $t('carrito.productos-cantidad') }}</p>
    </div>
    <div class="info-container" v-if="!hayProductos">
        <div class="imagen"><img src="/assets/bolsa-de-la-compra.png" alt="Pedido" /></div>
        <h1>{{ $t('carrito.carrito-vacio') }}</h1>
        <p>{{ $t('carrito.propuesta-añadir') }}</p>
        <button @click="navegar('/tienda')">{{ $t('carrito.ver-menu') }}</button>
    </div>
    <div class="carrito-container" v-if="hayProductos">
        <div class="productos-container">
            <TarjetaProducto
                v-for="p in productosCarrito"
                :key="p.id"
                :p="p"
                @eliminar="eliminarProducto(p)"
                @sumar="sumarCantidadProducto(p)"
                @restar="restarCantidadProducto(p)"
            />
        </div>
        <div class="resumen-container">
            <ResumenPedido
                :subtotal="subtotal"
                :envio="envio"
                :total="total"
                :envioRestante="envioRestante"
            />
        </div>
    </div>
</template>
<script setup lang="ts">
import { useRouter } from 'vue-router'
import { computed } from 'vue'
import { storeToRefs } from 'pinia'
import { useCarritoStore } from '@/stores/counter'
import TarjetaProducto from '@/components/CarritoComp/TarjetaProducto.vue'

const router = useRouter()
const carrito = useCarritoStore()
const { productosCarrito, subtotal, cantidadProductosCarrito, envio, total, envioRestante } =
    storeToRefs(carrito)

const { eliminarProducto, sumarCantidadProducto, restarCantidadProducto } = carrito

const navegar = (path: string) => {
    router.push(path)
}

const hayProductos = computed<boolean>(() => (productosCarrito.value.length > 0 ? true : false))
</script>
<style lang="scss" scoped>
.carrito-container {
    display: flex;
    margin: 30px 50px 0px 50px;

    .productos-container {
        width: 80%;
    }
}

.tituloContainer {
    margin-top: 30px;
    margin-left: 50px;

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
    height: 80vh;
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
