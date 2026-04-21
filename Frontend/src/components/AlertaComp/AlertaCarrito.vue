<template>
    <div v-if="visible" class="contenedor-alerta">
        <div class="alerta">
            <div class="icono-circulo">
                <span class="tick">✓</span>
            </div>
        
            <h2 class="titulo">{{ titulo }}</h2>
            <p class="mensaje">{{ mensaje }}</p>
        
            <button v-if="mostrarBoton" @click="irACarrito" class="btn-carrito">
                Ver mi carrito
            </button>
        </div>
    </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';

defineProps({
    visible: Boolean,
    titulo: String,
    mensaje: String,
    mostrarBoton: Boolean
});

const emit = defineEmits(['cerrar']);
const router = useRouter();


const irACarrito = () => {
    emit('cerrar');
    router.push('/carrito');
}
</script>

<style lang="scss" scoped>


.contenedor-alerta {
    position: fixed; // Para que se quede fijo en la pantalla
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.7);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999;//Para que aparezca por encima de todo
    backdrop-filter: blur(4px); //Para que este difuminado el fondo

    .alerta {
        background: #1a1a1a;
        color: white;
        padding: 40px;
        border-radius: 20px;
        text-align: center;
        border: 2px solid $color-rojo-panda; 
        box-shadow: 0 0 30px rgba($color-rojo-panda, 0.3);
        max-width: 350px;
        width: 90%;

        .icono-circulo {
            width: 70px;
            height: 70px;
            background: $color-verde-exito; 
            border-radius: 50%; // Para que sea un círculo
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto 20px;

            .tick {
                color: white;
                font-size: 40px;
                font-weight: bold;
            }
        }

        .titulo {
            color: $color-rojo-panda;
            margin: 0 0 10px 0;
            font-size: 24px;
            text-transform: uppercase;
            font-weight: bold;
        }

        .mensaje {
            font-size: 16px;
            margin-bottom: 25px;
            color: #cccccc;
        }

        .btn-carrito {
            background-color: $color-rojo-panda;
            color: white;
            border: none;
            padding: 12px 25px;
            border-radius: 30px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.2s ease;
            display: inline-block;

            &:hover {
                transform: scale(1.05);
                background-color: darken($color-rojo-panda, 10%);
            }
            
            &:active {
                transform: scale(0.95);
            }
        }
    }
}


</style>