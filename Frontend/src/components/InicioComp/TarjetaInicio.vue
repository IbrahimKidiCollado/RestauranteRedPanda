<template>
	<div class="contenedor-tarjeta">
		<div class="imagen"><img :src="imagen" alt="chef"></div>
		<h3>{{ titulo }}</h3>
		<p>{{ descripcion }}</p>
	</div>
</template>

<script setup lang="ts">
interface Tarjeta{
	imagen:string;
	titulo:string;
	descripcion:string;
}

defineProps<Tarjeta>();
</script>

<style lang="scss" scoped>

.contenedor-tarjeta {
	text-align: center;
	width: 280px;
	height: 240px;
	padding: 30px;
	border-radius: 20px;
	border:1px solid $color-rojo-oscuro;
	justify-content: center;
	align-items: center;

	background: radial-gradient(
	circle at top left,
	rgba(127, 29, 29, 0.25) 0%,
	rgba(69, 10, 10, 0.05) 70%,
	transparent 100%
	);

	h3 {
		color: $color-texto-blanco;
		font-weight: 500;
		padding-top: 20px;
	}

	p {
		color:$color-blanco-sucio;
		padding-top: 10px;
	}

	.imagen {
		img {
			padding: 20px;
			background-color: $color-rojo-oscuro;
			border-radius: 100%;
		}
	}
}

</style>