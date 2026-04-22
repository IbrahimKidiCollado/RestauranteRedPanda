<template>
    <AdminPanel />
    <AdminForm @actualizar-tabla="manejarAcciones('CREADO')" />
    <AdminCarta :platos="Platos" @actualizar-tabla="manejarAcciones('ELIMINADO')" />

    <AlertaCarrito
        :visible="alerta.visible"
        :titulo="alerta.titulo"
        :mensaje="alerta.mensaje"
        :mostrar-boton="alerta.mostrarBoton"
    />

</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import AdminPanel from "@/components/AdminComp/AdminPanel.vue";
import AdminForm from "@/components/AdminComp/AdminForm.vue";
import AdminCarta from "@/components/AdminComp/AdminCarta.vue";
import { obtenerPlatos } from '@/services/Tienda/PlatosService';
import { reactive } from 'vue';
import AlertaCarrito from '@/components/AlertaComp/AlertaCarrito.vue'

const alerta = reactive({
    visible: false,
    titulo: '',
    mensaje: '',
    mostrarBoton: false
});

const Platos = ref([]);
const cargarPlatos = async () => { 
    Platos.value = await obtenerPlatos();
}

const manejarAcciones = (accion: string) => {
    lanzarAlerta(accion);
    cargarPlatos();

}

const lanzarAlerta =(accion: string) =>{
    if(accion === 'CREADO'){ 
        alerta.visible = true;
        alerta.titulo = 'PLATO CREADO';
        alerta.mensaje = 'El plato ha sido creado correctamente.';
    } else if(accion === 'ELIMINADO') {
        alerta.visible = true;
        alerta.titulo = 'PLATO ELIMINADO';
        alerta.mensaje = 'El plato ha sido eliminado correctamente.';
    }

    setTimeout(() => {
        alerta.visible = false;
    },2500) // 2 segundos y medio :)
}

onMounted(cargarPlatos);

</script>