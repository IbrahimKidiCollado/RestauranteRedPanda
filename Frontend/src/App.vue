<script setup lang="ts">
import { ref } from 'vue'
import { computed } from 'vue'
import { useI18n } from 'vue-i18n'

const menuAbierto = ref(false) // Variable que controla si el menú está abierto
const opcionMenuAbierto = ref(0) // Para ver que menu está abierto
const { t } = useI18n() // Sacar la funcion t del framework

const listaBotonesInicio = computed( () => [ // Computed para traducir dinamicamente con el framework de traduccion
{id: 0, texto: t("header.nav.inicio") },
{id: 1, texto: t("header.nav.tienda") },
{id: 2, texto: t("header.botones.iniciar")}
]) // Objeto para crear botones dinamicos para el inicio

</script>

<template>
	<header>
		<div class="contenedor-1-header">
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
				<button
				class="menu-hamburguesa"
				:class="{ 'is-active': menuAbierto }"
				@click="menuAbierto = !menuAbierto"
				>
				<span></span>
			</button>
		</div>
	</div>
	<!-- bucle para recorrer el array de botones de inicio con llave obligatoria y cambiando la clase active en funcion de que boton se haya pulsado -->
	<div 
	class="contenedor-2-header" 
	:class="{ 'esta-abierto': menuAbierto }"
	@click.self="menuAbierto = false"
	>
	<button
	v-for="boton in listaBotonesInicio"
	:key="boton.id"
	:class="{'is-active2': opcionMenuAbierto === boton.id}"
	@click="opcionMenuAbierto = boton.id"
	>
	{{ boton.texto }}
</button>
</div>
</header>
<main>
	
</main>
<footer>
	
</footer>
</template>

<style lang="scss" scoped>

header {
	background-color: $color-fondo-oscuro;
	display: flex;
	flex-direction: column;
	
	.contenedor-2-header {
		color: $color-blanco-sucio;
		display: flex;
		flex-direction: column;
		gap: 10px;
		overflow: hidden;
		max-height: 0;
		opacity: 0;
		padding-top: 0;
		padding-bottom: 0;
		margin: 0px 20px;
		border-top: 1px solid transparent;
		transition: all 0.5s ease-in-out;
		
		&.esta-abierto {
			max-height: 500px;
			opacity: 1;
			padding-top: 20px;
			padding-bottom: 20px;
			margin-top: auto;
			margin-bottom: 20px;
			border-top: 1px solid $color-rojo-oscuro-claro;
		}
		
		button {
			padding: 15px;
			border-radius: 10px;
			background: none;
			border-style: none;
			color: $color-blanco-sucio;
			text-align: left;
			font-weight: bold;
			
			&:hover {
				background-color: $color-azul-sistema;
				transition: 200ms;
			}
			
			&.is-active2 {
				background-color: $color-rojo-oscuro;
				color: $color-rojo-claro;
			}
		}
	}
	
	.contenedor-1-header {
		display: flex;
		justify-content: space-around;
		
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
				
				@include mobile-down {
					width: 60px;
					height: auto;
				}
			}
			
			.contenedor-titulo {
				margin: 20px 0px;
				
				h1 {
					color: $color-texto-blanco;
					font-size: 30px;
					
					@include mobile-down {
						font-size: 20px;
					}
				}
				
				h2 {
					color: $color-rojo-fuerte-textos;
					font-size: 13px;
					font-weight: 400;
					
					@include mobile-down {
						font-size: 9px;
					}
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
				
				@include mobile-down {
					display: none;
				}
				
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
				
				@include mobile-down {
					display: none;
				}
				
				img {
					width: 17px;
					height: 17px
				}
				
				&:hover {
					transform: scale(1.05);
					background-color: $color-rojo-oscuro-claro;
				}
			}
			
			.menu-hamburguesa {
				display: none;
			}
			
			@include mobile-down {
				.menu-hamburguesa {
					width: 40px;
					height: 40px;
					background: transparent;
					border: none;
					cursor: pointer;
					display: flex;
					justify-content: center;
					align-items: center;
					position: relative;
					z-index: 100;
					
					// La línea del centro
					span {
						display: block;
						width: 30px;
						height: 3px;
						background-color: $color-texto-blanco; // Usa tu variable de color
						border-radius: 2px;
						position: relative;
						transition: all 0.3s ease;
						
						// Las líneas de arriba y abajo
						&::before,
						&::after {
							content: '';
							position: absolute;
							left: 0;
							width: 30px;
							height: 3px;
							background-color: $color-texto-blanco; // Usa tu variable de color
							border-radius: 2px;
							transition: all 0.3s ease;
						}
						
						// Posicionamos la de arriba
						&::before {
							transform: translateY(-8px); 
						}
						
						// Posicionamos la de abajo
						&::after {
							transform: translateY(8px);
						}
					}
					
					// --- LA MAGIA: CUANDO VUE PONE LA CLASE ACTIVA ---
					&.is-active {
						span {
							background-color: transparent; // Ocultamos la línea del centro
							
							&::before {
								transform: translateY(0) rotate(45deg); // Forma la barra /
							}
							
							&::after {
								transform: translateY(0) rotate(-45deg); // Forma la barra \
							}
						}
					}
				}
			}
		}
	}
}
</style>