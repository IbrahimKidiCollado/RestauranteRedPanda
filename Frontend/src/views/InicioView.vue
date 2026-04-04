<template>
	<EncabezadoInicio/>
	<h2 class="h2primero">{{ $t("inicio.razones") }}</h2>
	<div class="contenedor-tarjetas">
		<TarjetaInicio v-for="(ventaja, i) in infoVentaja" :key="i"
		:imagen="ventaja.imagen"
		:titulo="ventaja.titulo"
		:descripcion="ventaja.descripcion"
		/>
	</div>
	<h2>{{ $t("inicio.especialidades") }}</h2>
	<h3>{{ $t("inicio.especialidadesDescripcion") }}</h3>
	<div class="contenedor-tarjetas">
		<TarjetaInicio v-for="(especialidad, i) in infoEspecialidades" :key="i"
		:imagen="especialidad.imagen"
		:titulo="especialidad.titulo"
		:descripcion="especialidad.descripcion"
		/>
	</div>
</template>

<style lang="scss" scoped>

h2 {
	text-align: center;
	font-size: clamp(1.8rem, 3vw + 1rem, 2.8rem);
	color: $color-texto-blanco;
	padding-top: 170px;
}

h3 {
	text-align: center;
	color:$color-blanco-sucio;
	font-weight: 400;
	padding-top: 15px;
}

.h2primero {
	padding-top: 100px;
}

.contenedor-tarjetas {
	display: flex;
	flex-wrap: wrap;
	max-width: 1400px;
	justify-content: center;
	margin: 0 auto;
	gap:40px;
	padding-top: 60px;
}

</style>

<script setup lang="ts">

import { useI18n } from 'vue-i18n';
const { t } = useI18n()

import EncabezadoInicio from '@/components/InicioComp/EncabezadoInicio.vue';
import TarjetaInicio from '@/components/InicioComp/TarjetaInicio.vue';

const infoVentaja = {
	1:{imagen: "/assets/sombrero-de-cocinero.png", titulo:t("inicio.razonesOpciones.titulos.chef"),descripcion:t("inicio.razonesOpciones.detalle.chef")},
	2:{imagen: "/assets/fuego.png",titulo:t("inicio.razonesOpciones.titulos.ingredientes"),descripcion:t("inicio.razonesOpciones.detalle.ingredientes")},
	3:{imagen: "/assets/despertador.png",titulo:t("inicio.razonesOpciones.titulos.entrega"),descripcion:t("inicio.razonesOpciones.detalle.entrega")},
	4:{imagen: "/assets/medalla.png",titulo:t("inicio.razonesOpciones.titulos.calidad"),descripcion:t("inicio.razonesOpciones.detalle.calidad")}
}

const infoEspecialidades = {
	1:{imagen: "/assets/sombrero-de-cocinero.png", titulo:t("inicio.razonesOpciones.titulos.chef"),descripcion:t("inicio.razonesOpciones.detalle.chef")},
	2:{imagen: "/assets/fuego.png",titulo:t("inicio.razonesOpciones.titulos.ingredientes"),descripcion:t("inicio.razonesOpciones.detalle.ingredientes")},
	3:{imagen: "/assets/despertador.png",titulo:t("inicio.razonesOpciones.titulos.entrega"),descripcion:t("inicio.razonesOpciones.detalle.entrega")},
	4:{imagen: "/assets/medalla.png",titulo:t("inicio.razonesOpciones.titulos.calidad"),descripcion:t("inicio.razonesOpciones.detalle.calidad")}
}

</script>