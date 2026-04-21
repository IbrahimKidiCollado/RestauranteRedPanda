<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { obtenerPlatos } from '@/services/Tienda/PlatosService'
import { obtenerCategorias } from '@/services/Tienda/CategoriasService'
import TarjetaPlato from '@/components/TiendaComp/TarjetaPlato.vue'
import CategoriasFiltro from '@/components/TiendaComp/CategoriasFiltro.vue'
import { useCarritoStore } from '@/stores/counter'
import AlertaCarrito from '@/components/AlertaComp/AlertaCarrito.vue'
import {reactive} from 'vue' 

interface Plato {
    id: number
    nombre: string
    precio: number
    imagen: string
    descripcion: string
    categoria_slug: string
}

interface Categoria {
    id: number
    nombre: string
    slug: string
}

const platos = ref<Plato[]>([])
const categorias = ref<Categoria[]>([])
const categoriaActiva = ref<string>('todos')
const carrito = useCarritoStore()
const { añadirProducto } = carrito

const cargarPlatos = async (cat?: string) => {
    categoriaActiva.value = cat || 'todos'

    if (cat === 'todos') platos.value = await obtenerPlatos()
    else platos.value = await obtenerPlatos(cat)
}

const alerta = reactive({
    visible: false,
    titulo: '',
    mensaje: '',
    mostrarBoton: false //Esto es para que al añadir salga un carrito que redirija al carrito :)
})

const lanzarAlerta = (tipo: String, nombreProducto: String = '') => {
    alerta.visible = true;

    if(tipo == 'ANNADIR'){
        alerta.titulo = '¡AÑADIDO';
        alerta.mensaje = `${nombreProducto} se ha añadido al carrito.`;
        alerta.mostrarBoton = true;
    }

    setTimeout(() => {
        alerta.visible = false;
    },2500) // 2 segundos y medio :)
}

const manejarAnnadir = (plato : Plato) => {
    añadirProducto(plato);
    lanzarAlerta('ANNADIR', plato.nombre)
}
onMounted(async () => {
    platos.value = await obtenerPlatos()
    categorias.value = await obtenerCategorias()
})

</script>

<template>
    <div class="contenedor-titulos">
        <h1>{{ $t('tienda.titulo') }}</h1>
        <h2>{{ $t('tienda.descripcion') }}</h2>
    </div>
    <div class="contenedor-buscador-platos">
        <img src="/assets/busqueda.png" alt="buscar" />
        <input type="text" :placeholder="$t('tienda.buscador.buscar') + '...'" />
    </div>
    <div class="contenedor-categorias">
        <div class="nombre-categoria">
            <img src="/assets/filtrar.png" alt="filtrar" />
            <p>{{ $t('tienda.buscador.categ') }}</p>
        </div>
        <div class="categorias">
            <CategoriasFiltro
                v-for="categoria in categorias"
                :key="categoria.id"
                :nombre="categoria.nombre"
                :slug="categoria.slug"
                @filtrar="cargarPlatos"
                :class="{ activo: categoriaActiva === categoria.slug }"
            />
        </div>
    </div>
    <div class="contenedor-platos">
        <TarjetaPlato
            v-for="plato in platos"
            @añadir="manejarAnnadir(plato)"
            :key="plato.id"
            :nombre="$t(plato.nombre)"
            :descripcion="$t(plato.descripcion)"
            :precio="plato.precio"
            :imagen="plato.imagen"
            :categoria_slug="plato.categoria_slug"
        />
    </div>
    <div>
        <AlertaCarrito
            :visible="alerta.visible"
            :titulo="alerta.titulo"
            :mensaje="alerta.mensaje"
            :mostrar-boton="alerta.mostrarBoton"
        />
    </div>
</template>

<style lang="scss" scoped>
.contenedor-titulos {
    text-align: center;
    margin-top: 40px;

    h2 {
        color: $color-blanco-sucio;
        font-size: clamp(16px, 2vw + 10px, 30px);
        font-weight: 400;
        margin-top: 13px;
    }

    h1 {
        font-size: clamp(24px, 4vw + 10px, 50px);
        color: $color-texto-blanco;
        font-weight: 700;
    }
}

.contenedor-buscador-platos {
    display: flex;
    align-items: center;
    border: 1px solid $color-rojo-oscuro;
    border-radius: 20px;
    width: clamp(250px, 90%, 800px);
    margin: 40px auto;

    gap: 10px;
    background-color: $color-fondo-header;

    input {
        border: none;
        background: none;
        font-size: 13px;
        width: 100%;
        height: 100%;
        color: $color-texto-blanco;
        padding: 18px 18px 18px 0px;
        &:focus {
            outline: none;
        }
    }

    img {
        padding-left: 18px;
    }

    &:focus-within {
        border: 1px solid $color-rojo-panda;
    }
}

p {
    color: $color-texto-blanco;
}

.contenedor-categorias {
    display: flex;
    flex-direction: column;

    align-items: center;
    justify-content: center;
    gap: 8px;
    font-size: 13px;
    font-weight: 600;

    .nombre-categoria {
        display: flex;
        gap: 10px;
    }

    .categorias {
        max-width: 1600px;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
        margin-top: 20px;

        .activo {
            background-color: $color-rojo-panda;
            border-color: $color-rojo-panda;
            color: white;
        }
    }
}

.contenedor-platos {
    display: flex;
    gap: 30px;
    justify-content: center;
    flex-wrap: wrap;
    max-width: 1600px;
    margin: 50px auto;
}
</style>
