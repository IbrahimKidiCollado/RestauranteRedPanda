<template>
	<button>{{ $t(nombre) }}</button>
</template>

<style lang="scss" scoped>
@use "@/styles/mixins" as *;

button {
	@include boton-rojo();

	background: $color-fondo-header;
	border: 1px solid $color-rojo-oscuro;

	&:hover {
		border: 1px solid $color-rojo-oscuro-claro;
	}

	&:focus{
		background:$color-rojo-boton;
	}
}
</style>

<script lang="ts" setup>

interface Categorias {
	nombre: string;
	slug:string;
}

defineProps<Categorias>();
</script>