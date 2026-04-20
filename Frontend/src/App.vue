<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import { useCarritoStore } from './stores/counter'

const carritoStore = useCarritoStore();

import HeaderApp from './components/AppComp/HeaderApp.vue'
import FooterApp from './components/AppComp/FooterApp.vue'

const tabletMovil = ref(false)

const revisarTamaño = () => {
    tabletMovil.value = window.innerWidth <= 768 && window.innerWidth > 391
}

onMounted(() => {
    revisarTamaño()
    window.addEventListener('resize', revisarTamaño)
})

onUnmounted(() => {
    window.removeEventListener('resize', revisarTamaño)
})

//Para que el carrito se mantenga sincronizado con el backend cada vez que se recarga la página
onMounted(async () => {
    try{
        await fetch('http://localhost:8081/login', {
            credentials: 'include'
        })
        await carritoStore.sincronizarCarrito();
            

    }catch(error){
        console.error('Error al iniciar la sesion:', error);
    }
})

//Cuando se cierre la ventana se vacia el carrito
window.addEventListener('pagehide', () => {
    navigator.sendBeacon('http://localhost:8081/carrito/vaciar');
})
</script>

<template>
    <div class="contenedor-principal">
        <header>
            <HeaderApp />
        </header>

        <main class="contenido">
            <RouterView />
        </main>

        <footer>
            <FooterApp />
        </footer>
    </div>
</template>

<style lang="scss" scoped>
.contenedor-principal {
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    width: 100%;

    header {
        position: sticky;
        top: 0;
        z-index: 1000;
    }

    main {
        flex: 1;
    }

    footer {
        flex-shrink: 0;
    }
}

main {
    height: 800px;
    background-color: $color-fondo-main;
}
</style>
