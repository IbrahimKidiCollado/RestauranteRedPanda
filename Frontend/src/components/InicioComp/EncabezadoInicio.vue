<template>
	<div class="contenedor-encabezado-inicio">
		<h1>{{ $t("inicio.descripcion") }}<br><span>{{ $t("inicio.descripcionSpan") }}</span></h1>
		<p>{{ $t("inicio.descripcionLarga") }}</p>
		<button>{{ $t("inicio.botones.pedir") }}<img src="/assets/envio-rapido.png" alt="Envio"></button>
		<p><img src="/assets/reloj-tres.png" alt="tiempo">{{ $t("inicio.tiempoEntrega") }}</p>
	</div>
</template>

<script setup lang="ts">

</script>

<style lang="scss" scoped>

.contenedor-encabezado-inicio {
	width: 100%;
	height: 95vh;
	background-image: url("/assets/EncabezadoInicio.png");
	background-color: rgba(0, 0, 0, 0.7);
	background-repeat: no-repeat;
	background-size: cover;
	background-blend-mode: multiply;
	display: flex;
	flex-direction: column;
	align-items: center;
	vertical-align: middle;
	justify-content: center;

	h1 {
		text-align: center;
		font-size: clamp(2.5rem, 5vw + 1rem, 5rem);
		line-height: 1;
		font-weight: 600;

		span {
			color: $color-rojo-titulo;
		}
	}

	p {
		color: $color-blanco-sucio;
		font-size: clamp(1.1rem, 1.5vw + 0.5rem, 2rem);
		text-align: center;
		padding: 40px 0 40px 0;
	}

	p:last-child {
		font-size: clamp(0.7rem, 1vw + 0.5rem, 1.5rem);
		color:$color-blanco-sucioMas;
		display: flex;
		align-items: center;
		justify-content: center;
		gap: 10px;
	}

	button {
		@include boton-rojo();
		display: flex;
		align-items: center;
		justify-content: center;
		gap: 10px;
		width: 300px;
		height: 100px;
		border-radius: 440px;
		font-size: 25px;
	}
}
</style>