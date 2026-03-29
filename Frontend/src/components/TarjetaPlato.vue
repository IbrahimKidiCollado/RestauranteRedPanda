<template>
	<div class="contenedor-tarjetas">
		<img :src="imagen" alt="producto">
		
	</div>
</template>

<script setup lang="ts">
interface Platos {
	nombre: string;
	descripcion: string;
	precio: number;
	categoria_slug: string;
	imagen: string;
}

defineProps<Platos>();
</script>

<style lang="scss" scoped>
	.contenedor-platos {
		max-width: 460px;
        min-width: 320px;
        height: 550px;
		width: 100px;
        border: 1px solid green; // Pon esto solo para ver si el recuadro existe
        overflow: hidden;

		img {
			width: 200px;
		}
	}
</style>