<script setup lang="ts">

</script>

<template>
	<div class="contenedor-titulos">
		<h1>{{ $t("tienda.titulo") }}</h1>
		<h2>{{ $t("tienda.descripcion") }}</h2>
	</div>
	<div class="contenedor-buscador-platos">
		<img src="/assets/busqueda.png" alt="buscar" @click="buscar">
		<input type="text" :placeholder="$t('tienda.buscador.buscar') + '...'">
	</div>
	<div class="contenedor-categorias">
		<img src="/assets/filtrar.png" alt="filtrar">
		<p>{{ $t("tienda.buscador.categ") }}</p>
	</div>
	<div class="contenedor-filtro">
		button
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
	margin:40px auto;
	
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
	};
	
	&:focus-within {
		border: 1px solid $color-rojo-panda;
	}
}

p {
	color: $color-texto-blanco;
}

.contenedor-categorias {
	display: flex;
	align-items: center;
	justify-content: center;
	gap:8px;
	font-size: 13px;
	font-weight: 600;
}

</style>