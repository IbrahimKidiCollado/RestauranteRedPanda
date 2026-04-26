<template>
    <Transition name="deslizar">
        <div v-if="visible" class="contenedor-alerta">
            <div class="alerta">
                <div class="icono-circulo">
                    {{ eleccionIcono }}
                </div>

                <div class="contenido">
                    <h2 class="titulo">{{ titulo }}</h2>
                    <p class="mensaje">{{ mensaje }}</p>

                    <button v-if="mostrarBoton" @click="irACarrito" class="btn-carrito">
                        Ver mi carrito
                    </button>
                </div>
            </div>
        </div>
    </Transition>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const props = defineProps({
    visible: Boolean,
    titulo: String,
    mensaje: String,
    mostrarBoton: Boolean,
    tipo: Number,
})

const emit = defineEmits(['cerrar'])
const router = useRouter()

const exclamacion = '<span class="material-symbols-outlined"> exclamation </span>'
const correcto = '<span class="material-symbols-outlined"> check </span>'

let eleccionIcono = ''

if (props.tipo === 0) eleccionIcono = exclamacion
else if (props.tipo === 1) eleccionIcono = correcto

const irACarrito = () => {
    emit('cerrar')
    router.push('/carrito')
}
</script>

<style lang="scss" scoped>
.contenedor-alerta {
    position: fixed;
    top: 20px;
    right: 20px;
    z-index: 1000;
    max-width: 350px;

    &.deslizar-enter-active,
    &.deslizar-leave-active {
        transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
    }
    &.deslizar-enter-from,
    &.deslizar-leave-to {
        opacity: 0;
        transform: translateY(-50px);
    }

    // Llamada al mixin
    .alerta {
        @include alerta-base;
    }
}
</style>
