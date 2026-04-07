<template>
	<header>
		<div class="contenedor-1-header">
			<div class="contenedor-imagen-nombre" @click="navegar('/')" style="cursor: pointer;">
				<img fetchpriority="high" src="/assets/logo.png" alt="Logo Profesional">
				<div class="contenedor-titulo">
					<h1>{{ $t("header.titulo") }}</h1>
					<h2>{{ $t("header.descripcion") }}</h2>
				</div>
			</div>
			<nav class="contenedor-enlaces">
				<li
				v-for="enlace in enlaces"
				:key="enlace.id"
				:class="{ 'active': opcionMenuAbierto === enlace.id }"
				@click="navegar(enlace.path)"
				>
				{{ $t(enlace.t) }}
			</li>
			
			<div
			class="barra-deslizante"
			:style="{ transform: `translateX(${opcionMenuAbierto * 100}%) translateX(${opcionMenuAbierto * 30}px)` }"
			></div>
		</nav>
		<div class="contenedor-carrito-perfil">
			<button class="admin" @click="navegar('/admin')"><span>AdmMode</span></button>
			<button class="carrito"><img src="/assets/carrito.png" alt="icono-carrito"></button>
			<button class="perfil" @click="navegar('/login')">
				<img src="/assets/user-icon.png" alt="icono-user">{{ $t("header.botones.iniciar") }}
			</button>
			<button
			class="menu-hamburguesa"
			:class="{ 'is-active': menuAbierto }"
			@click="menuAbierto = !menuAbierto"
			>
			<span></span>
		</button>
	</div>
</div>

<div class="contenedor-2-header" :class="{ 'esta-abierto': menuAbierto }">
	<template v-for="boton in listaBotonesInicio" :key="boton.id">
		<button
		v-if="!(tabletMovil && boton.id === 2)"
		:class="{
			'is-active2': opcionMenuAbierto === boton.id,
			'none': opcionMenuAbierto === 2
		}"
		@click="navegar(boton.path)"
		>
		{{ boton.texto }}
	</button>
</template>
</div>
</header>
</template>

<script setup lang="ts">

import {ref, computed} from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute()
const router = useRouter()
const menuAbierto = ref(false)
const { t } = useI18n()
const tabletMovil = ref(false)

const enlaces = [
{ id: 0, t: 'header.nav.inicio', path: '/' },
{ id: 1, t: 'header.nav.tienda', path: '/tienda' }
]

const opcionMenuAbierto = computed(() => {
	const rutaActual = enlaces.find(e => e.path === route.path)
	return rutaActual ? rutaActual.id : 0
})

const listaBotonesInicio = computed( () => [
{id: 0, texto: t("header.nav.inicio"), path: '/' },
{id: 1, texto: t("header.nav.tienda"), path: '/tienda' },
{id: 2, texto: t("header.botones.iniciar"), path: '/login' }
])

const navegar = (path: string) => {
	router.push(path)
	menuAbierto.value = false
}


</script>

<style lang="scss" scoped>
header {
	background-color: $color-fondo-header;
	display: flex;
	flex-direction: column;
	position: sticky;
	top: 0;
	width: 100%;
	z-index: 1000;
	flex-shrink: 0;
	border-bottom: 1px solid $color-rojo-oscuro-claro;
	
	
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
			cursor: pointer;
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
					font-size: clamp(1.8rem, 2.5vw, 2.5rem);
					
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
			position: relative;
			align-items: center;
			padding-bottom: 5px;
			
			@include tablet-down {
				display: none;
			}
			
			li {
				width: 80px;
				text-align: center;
				list-style: none;
				font-weight: 600;
				cursor: pointer;
				transition: color 0.3s ease;
				color: $color-blanco-sucio;
				
				&:hover {
					color: $color-texto-blanco;
				}
				
				&.active {
					color: $color-rojo-panda !important;
				}
			}
			
			.barra-deslizante {
				position: absolute;
				bottom: 0;
				left: 0;
				width: 80px;
				height: 3px;
				background-color: $color-rojo-panda;
				transition: transform 0.3s ease-in-out;
				pointer-events: none;
			}
		}
		
		.contenedor-2 {
			li {
				cursor: pointer;
				transition: color 0.2s;
				
				&:hover {
					color: $color-rojo-panda;
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
				
				@include movil-grande-down {
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

			.admin {
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
				
				@include movil-grande-down {
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
			
			@include tablet-down {
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
					
					span {
						display: block;
						width: 30px;
						height: 3px;
						background-color: $color-texto-blanco;
						border-radius: 2px;
						position: relative;
						transition: all 0.3s ease;
						
						&::before,
						&::after {
							content: '';
							position: absolute;
							left: 0;
							width: 30px;
							height: 3px;
							background-color: $color-texto-blanco;
							border-radius: 2px;
							transition: all 0.3s ease;
						}
						
						&::before {
							transform: translateY(-8px);
						}
						
						&::after {
							transform: translateY(8px);
						}
					}
					
					&.is-active {
						span {
							background-color: transparent;
							
							&::before {
								transform: translateY(0) rotate(45deg);
							}
							
							&::after {
								transform: translateY(0) rotate(-45deg);
							}
						}
					}
				}
			}
		}
	}
}
</style>