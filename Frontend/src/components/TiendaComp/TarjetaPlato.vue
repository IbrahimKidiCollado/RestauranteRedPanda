<template>
    <div class="contenedor-tarjeta">
        <div class="tarjeta-imagen">
            <img :src="imagen" alt="producto" width="348px" height="238.797px" />
            <p class="categoria">{{ categoria_slug }}</p>
        </div>
        <div class="tarjeta-info">
            <h3>{{ nombre }}</h3>
            <p>{{ descripcion }}</p>
            <div class="precio-añadir">
                <p class="precio">{{ precio }}€</p>
                <button class="añadir" @click="$emit('añadir')">
                    {{ $t('tienda.tarjeta-plato.añadir') }}
                </button>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
.contenedor-tarjeta {
    overflow: hidden;
    max-width: 100px;
    min-width: 350px;
    height: 400px;
    border-radius: 20px;
    gap: 10px;
    width: 100%;
    border: 1px solid $color-rojo-oscuro;
    overflow: hidden;
    transition: transform 0.3s ease;
    background-color: #030303;

    &:hover {
        border: 1px solid $color-rojo-oscuro-claro;
        transform: translateY(-5px);

        img {
            transform: scale(1.1);
        }
    }

    .tarjeta-imagen {
        height: 60%;
        position: relative;
        overflow: hidden;

        img {
            height: 100%;
            width: 100%;
            object-fit: cover;
            transition: transform 0.5s ease;
        }

        .categoria {
            position: absolute;
            bottom: 10px;
            left: 10px;
            z-index: 10;
            background-color: rgba(0, 0, 0, 0.9);
            color: $color-rojo-fuerte-textos;
            font-weight: 100;
            padding: 5px 10px;
            font-size: 10px;
            border-radius: 20px;
        }
    }
    .tarjeta-info {
        height: 40%;
        padding: 20px 20px;

        h3 {
            color: $color-texto-blanco;
            font-size: 18px;
            font-weight: 400;
            margin-bottom: 10px;
        }

        p {
            font-size: 13px;
            color: $color-blanco-sucio;
            margin-bottom: 10px;
        }

        .precio-añadir {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
            align-items: center;

            button {
                @include boton-rojo();
            }

            p {
                margin-bottom: 0px !important;
                font-size: 25px;
                font-weight: bold;
                color: $color-rojo-panda;
            }
        }
    }
}
</style>

<script setup lang="ts">
interface Platos {
    nombre: string
    descripcion: string
    precio: number
    categoria_slug: string
    imagen: string
}

defineProps<Platos>()
</script>
