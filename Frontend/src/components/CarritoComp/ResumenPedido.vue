<template>
    <div class="contenedor-resumen">
        <div class="resumen">
            <div>
                <p>SUBTOTAL</p>
                <p>{{ subtotal.toFixed(2) }}€</p>
            </div>
            <div>
                <p>ENVIO: </p>
                <p :class="{'envio-gratuito' : envio === 0}">{{ envio === 0 ? 'GRATIS' : envio.toFixed(2) + '€' }}</p>
            </div>
            <div>
                <p>TOTAL A PAGAR: </p>
                <p>{{ total.toFixed(2) }}€</p>
            </div>
            <<div class="texto-aviso" v-if="envioRestante > 0">
                <p>¡¡SOLO TE QUEDAN {{ envioRestante }}€ PARA EL ENVIO GRATIS!!</p>
            </div>

        </div>
        <div class="contenedor-boton-pago">
            <div id="paypal-button-container"></div>
        </div>
    </div>
</template>
<script setup lang="ts">
    import {onMounted} from 'vue'
    import { loadScript } from '@paypal/paypal-js';
    import { useCarritoStore } from '@/stores/counter';

    const props = defineProps<{
        subtotal: number
        envio: number
        total: number
        envioRestante: number
    }>()  

    const emit = defineEmits(['exito']);

    const idCorreo = 'correoPruebaPago@prueba.pago.com';
    const pwd = 'contraPruebaPago';
    const clienteID = 'Ae7XmE263sT54nNN7yXEvSmXkK0zmMFhh8wMiB0b8d1WZRXlIIIm27QdmaazmhcXGVVuJnggDTYd0DsB';

    onMounted(async () =>{
        try {
            //Esto es para cargar el SDK de PayPal, con el clienteID y la moneda que queremos usar
            //El SDK es necesario para manejar el proceso de pago
            const paypal = await loadScript({
                "clientId": clienteID,
                currency :"EUR"
            })

            //Si el SDK se ha cargado correctamente, renderizamos el botón de PayPal en el contenedor designado
            if(paypal && paypal.Buttons){
                //Aquí definimos las acciones a realizar en cada etapa del proceso de pago
                await paypal.Buttons({
                    //Esta función se ejecuta cuando el usuario hace clic en el botón de PayPal para iniciar el proceso de pago
                    createOrder: (data, actions) => {
                        //Esto es lo que se envía a PayPal, en este caso se le indica el total a pagar que se muestra en el resumen del pedido
                        return actions.order.create({
                            intent: 'CAPTURE', //Esto indica que el pago se capturará inmediatamente después de la aprobación del usuario
                            purchase_units: [{
                                amount: {
                                    currency_code: 'EUR',
                                    value: props.total.toFixed(2) // El total a pagar, que se muestra en el resumen del pedido
                                }
                            }]
                        })
                    },

                    //Si el pago se ha realizado con éxito, se ejecuta
                    onApprove: async (data, actions) => {
                        if (actions.order){
                            const detalles = await actions.order.capture();
                            emit('exito'); // Lanzamos un mensaje para avisar que se ha dado con exito

                        }
                    },
                    //Si da error en el proceso de pago, se ejecuta 
                    onError: (err) => {
                        console.log("ERROR EN EL PROCESO DE PAGO");
                    }
                }).render("#paypal-button-container"); // Aqui  escogemos el contenedor donde se va a renderizar el botón de PayPal
            }
            
        } catch (error) {
            console.error("No se pudo cargar el botón de PayPal:", error);
        }
    })
</script>

<style lang="scss" scoped>
    .contenedor-resumen {
        display: flex;
        flex-direction: column;
        background-color: $color-fondo-tarjeta;
        border: 1px solid $color-rojo-oscuro;
        padding: 20px;
        border-radius: 10px;
        margin-bottom: 50px;
        gap: 5px;
        width: 80%;

        p{
            color: $color-texto-blanco;
        }

        .resumen{

            div{
                display: flex;
                flex-direction: row;
                justify-content: space-between;
            }
            .envio-gratuito{
                color: $color-verde-exito;
            }
            .texto-aviso{
                text-align: center;
                color: $color-rojo-panda;
                font-weight: 500;
                margin-bottom: 15px;
            }
        }
        .contenedor-boton-pago{
            display: flex;
            margin: 0;
            text-align: center;
            justify-content: center;
            align-items: center;
            .btn-pago{
                @include boton-rojo();
                background-color: $color-rojo-panda;
                border-radius: 10px;
                padding: 7px;
                cursor: pointer;
                width: 30%;
            }

        }
    }

</style>