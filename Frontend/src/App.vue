<script setup lang="ts">
import { ref, onMounted, onUnmounted, computed } from 'vue'
import { useI18n } from 'vue-i18n'
import { useRoute, useRouter } from 'vue-router'

const { t } = useI18n()
const route = useRoute()
const router = useRouter()

const menuAbierto = ref(false)
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

const revisarTamaño = () => {
	tabletMovil.value = window.innerWidth <= 768 && window.innerWidth > 391
}

onMounted(() => {
	revisarTamaño()
	window.addEventListener('resize', revisarTamaño)
})

onUnmounted(() => {
	window.removeEventListener('resize', revisarTamaño)
})
</script>

<template>
	<div class="contenedor-principal">
		<header>
			<div class="contenedor-1-header">
				<div class="contenedor-imagen-nombre" @click="navegar('/')" style="cursor: pointer;">
					<img src="/assets/logo.png" alt="Logo Profesional">
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

<main>
	<RouterView />
</main>

<footer>
	<div class="contenedor-1-footer">
		<div class="contenedor-1">
			<div class="contenedor-1-imagenNombre">
				<img src="/assets/logo.png" alt="Logo Profesional">
				<h2>{{ $t("header.titulo") }}</h2>
			</div>
			<p>{{ $t("footer.descripcion") }}</p>
		</div>
		<div class="contenedor-2">
			<span>{{ $t("footer.titulos.enlaces") }}</span>
			<li @click="navegar('/')" style="cursor: pointer;">{{ $t("header.nav.inicio") }}</li>
			<li @click="navegar('/tienda')" style="cursor: pointer;">{{ $t("header.nav.tienda") }}</li>
		</div>
		<div class="contenedor-3">
			<span>{{ $t("footer.titulos.contacto") }}</span>
			<div>
				<img src="/assets/marcador.png" alt="ubicacion">
				<p>{{ $t("footer.contacto.calle") }}</p>
			</div>
			<div>
				<img src="/assets/llamada-telefonica.png" alt="telefono">
				<p>{{ $t("footer.contacto.tlf")}}</p>
			</div>
			<div>
				<img src="/assets/sobre.png" alt="email">
				<p>{{ $t("footer.contacto.email") }}</p>
			</div>
		</div>
		<div class="contenedor-4">
			<span>{{ $t("footer.titulos.horario") }}</span>
			<p>{{ $t("footer.horario.diario") }}</p>
			<p>{{ $t("footer.horario.findes") }}</p>
			<div class="contenedor-social">
				<button><img src="/assets/facebook.png" alt="logoFacebook"></button>
				<button><img src="/assets/instagram.png" alt="logoInstagram"></button>
				<button><img src="/assets/gorjeo.png" alt="logoGorjeo"></button>
			</div>
		</div>
	</div>
	<div class="contenedor-2-footer">{{ $t("footer.derechos") }}</div>
</footer>
</div>
</template>

<style lang="scss" scoped>

footer {
	background-color: $color-fondo-masOscuro;
	color: $color-texto-blanco;
	max-height: 400px;
	
	.contenedor-1-footer {
		display: flex;
		justify-content:center;
		min-width: 600;
		
		&>div {
			width: 300px;
			margin-left: 40px;
			padding-top: 50px;
		}
		
		div>span {
			font-size: 20px;
			font-weight: 600;
			line-height: 50px;
		}
		
		.contenedor-1 {
			margin-top:-13px;
			
			img {
				width: 90px;
				height: 70px;
			}
			
			.contenedor-1-imagenNombre {
				display: flex;
				align-items:center;
			}
		}
		
		.contenedor-2 {
			list-style: none;
			li {
				margin-bottom: 10px;
			}
		}
		
		.contenedor-3 {
			div {
				display: flex;
				align-items: center;
				margin-bottom: 20px;
				gap:10px;
				
				p {
					margin-bottom: auto !important;
				}
			}
		}
		
		.contenedor-4 {
			p {
				margin-bottom: 10px;
			}
			
			.contenedor-social {
				display: flex;
				gap: 10px;
				button {
					width: 40px;  /* Ancho fijo */
					height: 40px; /* Alto fijo (igual al ancho) */
					border-radius: 50%;
					
					background: none;
					border: 1px solid $color-rojo-fuerte-textos;
					background-color: $color-rojo-oscuro;
					transition: transform 0.2s ease, background-color 0.2s ease;
					
					&:hover {
						transform: scale(1.05);
						background-color: $color-rojo-oscuro-claro;
					}
				}
			}
		}
	}
}

.contenedor-2-footer {
	text-align: center;
	margin: 30px 50px 60px 50px;
	border-top: 1px solid $color-rojo-oscuro-claro;
	font-size: 18px;
	color: $color-texto-blanco;
	padding-top: 50px;
}


.contenedor-principal {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	
	main {
		flex-grow: 1;
	}
	
	footer {
		flex-shrink: 0;
	}
}

main {
	height: 800px;
}

header {
	background-color: $color-fondo-oscuro;
	display: flex;
	flex-direction: column;
	position: sticky;
	top: 0;
	width: 100%;
	z-index: 1000;
	flex-shrink: 0;
	
	
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