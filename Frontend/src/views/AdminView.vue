<template>
    <AdminPanel />
    <AdminForm @actualizar-tabla="cargarPlatos" />
    <AdminCarta :platos="Platos" @actualizar-tabla="cargarPlatos" />

</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import AdminPanel from "@/components/AdminComp/AdminPanel.vue";
import AdminForm from "@/components/AdminComp/AdminForm.vue";
import AdminCarta from "@/components/AdminComp/AdminCarta.vue";
import { obtenerPlatos } from '@/services/Tienda/PlatosService';

const Platos = ref([]);
const cargarPlatos = async () => {
    Platos.value = await obtenerPlatos();
}

onMounted(cargarPlatos);

</script>