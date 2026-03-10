<script setup lang="ts"></script>

<template>
	<header>
		<div class="contenedor-imagen-nombre">
			<img src="/assets/logo.png" alt="Logo Profesional">
			<div class="contenedor-titulo">
				<h1>{{ $t("header.titulo") }}</h1>
				<h2>{{ $t("header.descripcion") }}</h2>
			</div>
		</div>
		<nav class="contenedor-enlaces">
			<li>{{ $t("header.nav.inicio") }}</li>
			<li>{{ $t("header.nav.tienda") }}</li>
		</nav>
		<div class="contenedor-carrito-perfil">
			<button class="carrito"><img src="/assets/carrito.png" alt="icono-carrito"></button>
			<!-- MODIFICAR PARA LA COMPROBACION DE USUARIO -->
			<button class="perfil"><img src="/assets/user-icon.png" alt="icono-user">{{ $t("header.botones.iniciar") }}</button>
		</div>
	</header>
	<main>
		
	</main>
	<footer>
		
	</footer>
</template>

<style lang="scss" scoped>
header {
	display: flex;
	justify-content:space-around;
	background-color: $color-fondo-oscuro;
	
	.contenedor-imagen-nombre {
		display: flex;
		align-items: center;
		transition: transform 0.2s ease;
		
		&:hover {
			transform: scale(1.05);
		}
		
		img {
			width: 100px;
			height: 80px;
		}
		
		.contenedor-titulo {
			margin: 20px 0px;
			
			h1 {
				color: $color-texto-blanco;
				font-size: 30px;
			}
			
			h2 {
				color: $color-rojo-fuerte-textos;
				font-size: 13px;
				font-weight: 400;
			}
		}
	}
	
	.contenedor-enlaces {
		display: flex;
		gap: 30px;
		align-items: center;
		
		li {
			color: $color-blanco-sucio;
			list-style: none;
			font-size: 15px;
			font-weight: 600;
			
			&::after {
				content: "";
				position: absolute;
				bottom: 0;
				left: 0;
				width: 100%;
				height: 3px;
				background-color: $color-rojo-panda;
				transform: scaleX(0);
				transform-origin: right;
				transition: transform 0.3s ease-in-out;
			}
			
			&:hover {
				color: $color-texto-blanco;
				transition: 200ms;
				&::after {
					transform: scaleX(1);
					transform-origin: left;
				}
			}
			
			&.router-link-active {
				color: $color-rojo-panda;
				&::after {
					transform: scaleX(1);
					transform-origin: left;
				}
			}
		}
	}
	
	.contenedor-carrito-perfil {
		display: flex;
		align-items: center;
		gap: 25px;
		transition: transform 0.3s ease;
		.carrito{
			background: none;
			border: none;
			
			img {
				width: 25px;
				height: 25px;
				filter: brightness(1);
				
				&:hover {
					transform: scale(1.1);
					filter: brightness(1.8);
				}
			}
		}
		
		.perfil {
			display: flex;
			gap: 10px;
			background: none;
			color: $color-rojo-claro;
			font-weight: 600;
			align-items: center;
			border: 1px solid $color-rojo-fuerte-textos;
			background-color: $color-rojo-oscuro;
			padding: 10px 20px;
			border-radius: 10px;
			transition: transform 0.2s ease, background-color 0.2s ease;
			
			img {
				width: 17px;
				height: 17px
			}
			
			&:hover {
				transform: scale(1.05);
				background-color: $color-rojo-oscuro-claro;
			}
		}
	}
}

</style>