<template>
    <a class="enlace-back"><span class="material-symbols-outlined"> arrow_back </span> Volver</a>
    <div class="contenedor">
        <h2 class="titulo">
            {{ !logueado ? $t('login.formRegistrar.inicio') : $t('login.formIniciar.inicio') }}
        </h2>
        <p class="pregunta">
            {{ !logueado ? $t('login.formRegistrar.noInicio') : $t('login.formIniciar.noInicio') }}
            <span class="pregunta-rsp">
                {{ !logueado ? $t('login.formRegistrar.regist') : $t('login.formIniciar.regist') }}
            </span>
        </p>
        <form action="">
            <template v-if="!logueado">
                <label for="nombre" class="label-nombre">{{
                    $t('login.formRegistrar.nombre')
                }}</label>
                <div class="container-nombre">
                    <span class="material-symbols-outlined person"> person </span>
                    <input
                        type="text"
                        name="nombre"
                        :placeholder="$t('login.placeHolderName')"
                        class="inputNombre"
                        v-model="datosFormulario.nombre"
                    />
                    <span :style="{ display: 'none' }" class="error-nombre">{{
                        $t('login.errorNombre')
                    }}</span>
                </div>
            </template>
            <label for="email" class="label-email">{{ $t('login.email') }}</label>
            <div class="container-email">
                <span class="material-symbols-outlined mail"> mail </span>
                <input
                    class="input-email"
                    type="text"
                    name="email"
                    :placeholder="$t('login.placeHolderEmail')"
                    v-model="datosFormulario.email"
                />
                <span class="error-email" :style="{ display: 'none' }">{{
                    $t('login.errorEmail')
                }}</span>
            </div>
            <label for="pwd" class="error-pwd">{{ $t('login.pwd') }}</label>
            <div class="container-pwd">
                <span class="material-symbols-outlined lock"> lock </span>
                <input class="input-pwd" type="password" name="pwd" placeholder="••••••••" v-model="datosFormulario.password" />
                <span class="error-pwd" :style="{ display: 'none' }">{{
                    $t('login.errorPwd')
                }}</span>
            </div>
            <button type="button" class="botonEnvio" @click="envio">
                {{ !logueado ? $t('login.formRegistrar.inicio') : $t('login.formIniciar.inicio') }}
            </button>
        </form>
        <p v-if="!logueado" class="terminos">{{ $t('login.formRegistrar.terminos') }}</p>
    </div>
</template>

<script setup lang="ts">
import { useUserStore } from '@/stores/userStore';
import { reactive } from 'vue';
import { useRouter } from 'vue-router';

const props = defineProps<{
    logueado: boolean
}>()

const userStore = useUserStore();
const router = useRouter();

//Obtenemos los datos del formulario
const datosFormulario = reactive({
    nombre: '',
    email: '',
    password: ''
});

const envio = async () => {
    if(props.logueado){
        const resultado = await userStore.login(datosFormulario.nombre,datosFormulario.email, datosFormulario.password);
        if(resultado){
            //router.push('/tienda');
        } else {
            alert(resultado);
        }
    }else{
        const resultado = await userStore.registrarse(datosFormulario.nombre,datosFormulario.email, datosFormulario.password);
        if(resultado){
            //router.push('/tienda');
        } else {
            alert(resultado);
        }
    }
}

</script>

<style scoped lang="scss">
a {
    display: flex;
    align-items: center;
    gap: 5px;
    color: $color-gris;
    font-weight: 500;
    margin-bottom: 20px;
}
.contenedor {
    background: linear-gradient(135deg, #221012 0%, #0a0a0a 35%, #050505 100%);
    border-radius: 16px;
    padding: 40px;
    color: $color-texto-blanco;
    max-width: 450px;
    box-sizing: border-box;
    border: 1px solid $color-rojo-oscuro-claro;
    height: 91.7%;
    display: flex;
    flex-direction: column;
    justify-content: center;

    .titulo {
        font-size: 28px;
        font-weight: 800;
        margin: 0 0 8px 0;
    }

    .pregunta {
        font-size: 14px;
        color: $color-blanco-sucioMas;
        margin: 0 0 32px 0;

        .pregunta-rsp {
            color: $color-rojo-fuerte-textos;
            font-weight: 600;
            cursor: pointer;
            margin-left: 4px;
        }
    }

    form {
        display: flex;
        flex-direction: column;

        .label-nombre,
        .label-email,
        label.error-pwd {
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 8px;
            color: $color-texto-blanco;
            display: block;
        }

        .container-nombre,
        .container-email,
        .container-pwd {
            display: flex;
            align-items: center;
            background-color: $color-fondo-controles;
            border: 1px solid $color-azul-sistema;
            border-radius: 10px;
            padding: 14px 16px;
            margin-bottom: 20px;
            transition: border-color 0.3s ease;

            &:focus-within {
                border-color: $color-azul-sistema;
            }

            .material-symbols-outlined {
                color: $color-gris;
                font-size: 20px;
                margin-right: 12px;
                user-select: none;
            }

            input {
                flex: 1;
                background: transparent;
                border: none;
                color: $color-texto-blanco;
                font-size: 15px;
                outline: none;
                width: 100%;

                &::placeholder {
                    color: $color-azul-sistema;
                }
            }

            input[type='password'] {
                &::placeholder {
                    color: #6d7a8c;
                    letter-spacing: 4px;
                    font-weight: 500;
                    font-size: 20px;
                }
            }

            .error-nombre,
            .error-email,
            span.error-pwd {
                color: $color-rojo-fuerte-textos;
                font-size: 12px;
                margin-left: auto;
            }
        }

        .botonEnvio {
            @include boton-rojo();
        }
    }

    .terminos {
        font-size: 12px;
        color: $color-gris-oscuro;
        text-align: center;
        margin-top: 24px;
        line-height: 1.5;
    }
}
</style>
